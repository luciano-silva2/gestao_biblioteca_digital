package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.observers.Notificacao;
import br.edu.ifpb.gestaobibliotecadigital.observers.NotificacaoObserver;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class EmprestimoController extends Controller {

    private final EmprestimoService emprestimoService = new EmprestimoService();
    private final NotificacaoObserver notificacao = NotificacaoObserver.getInstance();

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.solicitarEmprestimo(usuario, livro);
        notificacao.notificar(new Notificacao("Empréstimo realizado do livro " + livro.getTitulo(), usuario));
        notificacao.notificar(new Notificacao("Empréstimo realizado para " + usuario.getNome(), usuarioLogado));
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        verificaUsuarioLogado();

        // Verifica se é o proprio usuario
        if (!isAdmin() && !usuarioLogado.getId().equals(emprestimo.getUsuario().getId())) {
            throw new IllegalStateException("Você não pode renovar o empréstimo de outra pessoa");
        }

        emprestimoService.renovarEmprestimo(emprestimo);
        notificacao.notificar(new Notificacao("Empréstimo renovado de " + emprestimo.getUsuario().getNome(), usuarioLogado));
    }

    public void devolverLivro(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.devolverLivro(emprestimo);
        notificacao.notificar(new Notificacao("Livro devolvido: " + emprestimo.getLivro().getTitulo(), usuarioLogado));
    }

    public void reservarLivro(Livro livro) {
        verificaUsuarioLogado();

        // Caso o usuário seja um administrador, ele deveria utilizar o outro método
        if (isAdmin()) {
            throw new IllegalStateException("Método incorreto para administrador, utilize o método void reservarLivro(Usuario usuario, Livro livro)");
        }

        emprestimoService.reservarLivro(usuarioLogado, livro);
        notificacao.notificar(new Notificacao("Livro reservado: " + livro.getTitulo(), usuarioLogado));
    }

    public void reservarLivro(Usuario usuario, Livro livro) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.reservarLivro(usuario, livro);
        notificacao.notificar(new Notificacao("Livro reservado para " + usuario.getNome() + ": " + livro.getTitulo(), usuarioLogado));
    }

    public void cancelarReserva(Reserva reserva) {
        verificaUsuarioLogado();

        // Verifica se é o proprio usuario
        if (!isAdmin() && !usuarioLogado.getId().equals(reserva.getUsuario().getId())) {
            throw new IllegalStateException("Você não pode cancelar a reserva de outra pessoa");
        }

        emprestimoService.cancelarReserva(reserva);
        notificacao.notificar(new Notificacao("Reserva cancelada do livro: " + reserva.getLivro().getTitulo(), usuarioLogado));
    }

    public void multaPaga(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.multaPaga(emprestimo);
        notificacao.notificar(new Notificacao("Multa paga do livro: " + emprestimo.getLivro().getTitulo(), usuarioLogado));
    }

    public void excluir(Emprestimo emprestimo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.excluir(emprestimo);
        notificacao.notificar(new Notificacao("Empréstimo excluído do livro: " + emprestimo.getLivro().getTitulo(), usuarioLogado));
    }

    public void excluirReserva(Reserva reserva) {
        verificaUsuarioLogado();
        verificaAdministrador();
        emprestimoService.excluirReserva(reserva);
        notificacao.notificar(new Notificacao("Reserva excluída do livro: " + reserva.getLivro().getTitulo(), usuarioLogado));
    }
}
