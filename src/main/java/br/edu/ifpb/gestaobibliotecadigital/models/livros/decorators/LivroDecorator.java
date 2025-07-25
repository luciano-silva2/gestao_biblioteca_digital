package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public abstract class LivroDecorator extends Livro {

    protected Livro livroDecorado;

    public LivroDecorator(Livro livro) {
        super(
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno(),
                livro.getEditora(),
                livro.getISBN(),
                livro.getSinopse(),
                livro.getCategoria()
        );
        this.livroDecorado = livro;
    }

    @Override
    public abstract String getDescricao();
}
