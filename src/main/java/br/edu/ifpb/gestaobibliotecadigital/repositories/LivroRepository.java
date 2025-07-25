package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

/**
 * Repository: Abstração da persistência de dados dos livros.
 */
public class LivroRepository extends Repositorio<Livro> {

    private static LivroRepository instance;

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

    @Override
    protected String getNome() {
        return "Livros";
    }

}
