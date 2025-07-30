package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.filters.ReservaFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.List;

public class LivroRepository extends Repositorio<Livro> {

    private static LivroRepository instance;
    private final EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();
    private final ReservaRepository reservaRepository = ReservaRepository.getInstance();

    private LivroRepository() {
        super("databases/livro.dat");
    }

    public static LivroRepository getInstance() {
        if (instance == null) {
            instance = new LivroRepository();
        }
        return instance;
    }

    @Override
    protected String getId(Livro item) {
        return item.getISBN();
    }

    private void removerVinculosDoLivro(Livro livro) {
        // Remover empréstimo, se houver
        List<Emprestimo> emprestimosRelacionados = emprestimoRepository.emprestimosLivro(livro);
        if (!emprestimosRelacionados.isEmpty()) {
            Emprestimo emprestimo = emprestimosRelacionados.get(0);
            emprestimoRepository.excluir(emprestimo);
        }

        // Remover reserva, se houver
        List<Reserva> reservasRelacionadas = new ReservaFiltro(reservaRepository.listar())
                .porLivro(livro)
                .filtrar();
        if (!reservasRelacionadas.isEmpty()) {
            Reserva reserva = reservasRelacionadas.get(0);
            reservaRepository.excluir(reserva);
        }
    }

    @Override
    public void excluir(Livro livro) {
        removerVinculosDoLivro(livro);
        super.excluir(livro);
    }

    @Override
    protected String getNome() {
        return "Livros";
    }
}
