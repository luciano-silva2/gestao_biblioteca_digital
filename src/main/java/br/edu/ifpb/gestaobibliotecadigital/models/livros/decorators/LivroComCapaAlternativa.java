package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class LivroComCapaAlternativa extends LivroDecorator {

    private String urlImagem;

    public LivroComCapaAlternativa(Livro livro, String urlImagem) {
        super(livro);
        this.urlImagem = urlImagem;
    }

    /**
     * Retorna a URL da imagem da capa alternativa.
     *
     * @return String contendo a URL.
     */
    public String getUrlCapa() {
        return urlImagem;
    }

    /**
     *
     * @return String ocm a descrição e a capa
     */
    @Override
    public String getDescricao() {
        return livroDecorado.getDescricao() + String.format("\nCapa Alternativa: %s", urlImagem);
    }
}
