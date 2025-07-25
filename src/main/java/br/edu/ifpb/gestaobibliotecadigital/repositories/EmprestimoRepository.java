package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.filters.EmprestimoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class EmprestimoRepository extends Repositorio<Emprestimo> {

    private static EmprestimoRepository instance;

    private EmprestimoRepository() {
        super("databases/emprestimos.dat");
    }

    @Override
    protected String getId(Emprestimo item) {
        return item.getId().toString();
    }

    public static EmprestimoRepository getInstance() {
        if (instance == null) {
            instance = new EmprestimoRepository();
        }
        return instance;
    }

    public Emprestimo emprestimoLivro(Livro livro) {
        // Procura se há empréstimos com este livro que não foram devolvidos
        List<Emprestimo> emprestimoNaoDevolvido = new EmprestimoFiltro(itens)
                .porLivro(livro).naoDevolvido().filtrar();

        // Se não houver empréstimos, retorna null
        if (emprestimoNaoDevolvido.isEmpty()) {
            return null;
        }

        // Retorna o primeiro empréstimo, pois só pode haver um
        return emprestimoNaoDevolvido.get(0);
    }

    public List<Emprestimo> emprestimosLivro(Livro livro) {
        // Procura os empréstimos com este livro
        return new EmprestimoFiltro(itens).porLivro(livro).filtrar();
    }

    @Override
    protected String getNome() {
        return "Empréstimos";
    }
}
