package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.filters.EmprestimoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.filters.ReservaFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPadrao;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EstrategiaEmprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.historico.HistoricoAcao;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.historico.TipoAcao;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.LeitorPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.observers.Notificacao;
import br.edu.ifpb.gestaobibliotecadigital.observers.NotificacaoObserver;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.HistoricoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ReservaRepository;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();
    private final ReservaRepository reservaRepository = ReservaRepository.getInstance();
    private final LivroRepository livroRepository = LivroRepository.getInstance();
    private final HistoricoRepository historicoRepository = HistoricoRepository.getInstance();
    private final NotificacaoObserver notificacao = NotificacaoObserver.getInstance();

    public List<Emprestimo> listarEmprestimosUsuario(Usuario usuario) {
        return new EmprestimoFiltro(emprestimoRepository.listar()).porUsuario(usuario).filtrar();
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.listar();
    }

    public List<Reserva> listarReservasUsuario(Usuario usuario) {
        return new ReservaFiltro(reservaRepository.listar()).porUsuario(usuario).filtrar();
    }

    public List<Reserva> listarTodasReservas() {
        return reservaRepository.listar();
    }

    public Emprestimo solicitarEmprestimo(Usuario usuario, Livro livro) {
        if (livroEstaEmprestado(livro)) {
            throw new IllegalStateException("O livro já está emprestado para alguém");
        }

        // Verifica se há alguma reserva para este livro
        Reserva reserva = reservaRepository.reservaLivro(livro);

        // Se houver uma reserva e o usuário não for o que solicitou o empréstimo, lança um erro
        if (reserva != null && !reserva.getUsuario().getId().equals(usuario.getId())) {
            throw new IllegalStateException("O livro já está reservado por outra pessoa");
        }

        EstrategiaEmprestimo estrategia = usuario instanceof LeitorPremium ? new EmprestimoPremium() : new EmprestimoPadrao();
        Emprestimo emprestimo = new Emprestimo(usuario, livro, estrategia);
//        livro.definirEmprestado();
        emprestimoRepository.adicionar(emprestimo);
        livroRepository.atualizar(livro);

        // Se o usuário reservou o livro, então encerra a reserva
        if (reserva != null) {
            reserva.setDataEncerrada(DataProvider.agora());
            reserva.setEmprestimo(emprestimo);
            reservaRepository.atualizar(reserva);
        }

        historicoRepository.adicionar(new HistoricoAcao(usuario, livro, emprestimo, reserva, TipoAcao.EMPRESTIMO));

        return emprestimo;
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        if (livroEstaReservado(emprestimo.getLivro())) {
            throw new IllegalStateException("Não é possível renovar o livro, pois ele foi reservado por alguém");
        }

        emprestimo.renovar();
        emprestimoRepository.atualizar(emprestimo);

        historicoRepository.adicionar(new HistoricoAcao(emprestimo.getUsuario(), emprestimo.getLivro(), emprestimo, null, TipoAcao.RENOVACAO));
    }

    public void devolverLivro(Emprestimo emprestimo) {
        if (emprestimo.foiDevolvido()) {
            throw new IllegalStateException("O livro já foi devolvido");
        }

        emprestimo.setDataDevolvido(DataProvider.agora());
//        emprestimo.getLivro().definirDisponivel();
        emprestimoRepository.atualizar(emprestimo);
        livroRepository.atualizar(emprestimo.getLivro());

        historicoRepository.adicionar(new HistoricoAcao(emprestimo.getUsuario(), emprestimo.getLivro(), emprestimo, null, TipoAcao.DEVOLUCAO));

        Reserva reserva = reservaRepository.reservaLivro(emprestimo.getLivro());

        if (reserva != null) {
            Usuario usuario = reserva.getUsuario();
            Livro livro = reserva.getLivro();
            String dataExpiracao = reserva.getDataExpiracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String mensagem = "Olá " + usuario.getNome() + "! O livro \"" + livro.getTitulo() + "\" que você reservou está disponível na biblioteca e reservado para você até " + dataExpiracao;
            notificacao.notificar(new Notificacao(mensagem, usuario));
        }
    }

    public void reservarLivro(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = emprestimoRepository.emprestimoLivro(livro);

        // Usuário não pode reservar o livro enquanto estiver com ele
        if (emprestimo != null && emprestimo.getUsuario().getId().equals(usuario.getId())) {
            throw new IllegalStateException("Você não pode reservar o livro, pois você está com ele");
        }

        // O usuário não pode reservar o livro enquanto estiver reservado por alguém
        if (livroEstaReservado(livro)) {
            throw new IllegalStateException("O livro já está reservado por alguém");
        }

        Reserva reserva = new Reserva(usuario, livro);
//        livro.definirReservado();
        reservaRepository.adicionar(reserva);
        livroRepository.atualizar(livro);

        historicoRepository.adicionar(new HistoricoAcao(usuario, livro, null, reserva, TipoAcao.RESERVA));
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva.encerrada()) {
            throw new IllegalStateException("Esta reserva já está encerrada");
        }

        reserva.cancelar();
        reservaRepository.atualizar(reserva);

        historicoRepository.adicionar(new HistoricoAcao(reserva.getUsuario(), reserva.getLivro(), null, reserva, TipoAcao.CANCELAMENTO_RESERVA));
    }

    public void multaPaga(Emprestimo emprestimo) {
        if (!emprestimo.foiDevolvido()) {
            throw new IllegalStateException("O livro ainda não foi devolvido");
        }

        if (!emprestimo.temMultaPendente()) {
            throw new IllegalStateException("Não tem multa pendente neste empréstimo");
        }

        emprestimo.setDataPagamentoMulta(DataProvider.agora());
        emprestimoRepository.atualizar(emprestimo);

        historicoRepository.adicionar(new HistoricoAcao(emprestimo.getUsuario(), emprestimo.getLivro(), emprestimo, null, TipoAcao.PAGAMENTO_MULTA));
    }

    public void excluir(Emprestimo emprestimo) {
        emprestimoRepository.excluir(emprestimo);
    }

    public void excluirReserva(Reserva reserva) {
        reservaRepository.excluir(reserva);
    }

    public boolean livroEstaEmprestado(Livro livro) {
        return emprestimoRepository.emprestimoLivro(livro) != null;
    }

    public boolean livroEstaReservado(Livro livro) {
        return reservaRepository.reservaLivro(livro) != null;
    }

    public boolean livroDisponivelParaEmprestimo(Livro livro) {
        return !livroEstaEmprestado(livro) && !livroEstaReservado(livro);
    }

    public boolean livroDisponivelParaReserva(Livro livro) {
        return !livroEstaReservado(livro);
    }

    public int contagemEmprestimosLivro(Livro livro) {
        return emprestimoRepository.emprestimosLivro(livro).size();
    }

    public List<Map.Entry<Livro, Long>> ranking() {
        Map<Livro, Long> ranking = emprestimoRepository.listar().stream()
                .collect(Collectors.groupingBy(
                        Emprestimo::getLivro,
                        Collectors.counting()
                ));

        List<Map.Entry<Livro, Long>> livrosMaisEmprestados = ranking.entrySet().stream()
                .sorted(Map.Entry.<Livro, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

//        livrosMaisEmprestados.forEach(entry -> {
//            System.out.println("LivroSimples: " + entry.getKey().getTitulo() + " - Empréstimos: " + entry.getValue());
//        });
        return livrosMaisEmprestados;
    }
}
