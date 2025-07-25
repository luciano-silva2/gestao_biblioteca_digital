package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.List;

public class ColecaoFiltro extends Filtro<Colecao> {

    public ColecaoFiltro() {
        super();
    }

    public ColecaoFiltro(List<Colecao> livros) {
        super(livros);
    }

    //Pesquisar em todos os campos
    public ColecaoFiltro pesquisar(String texto) {
        filtros.add(livro -> {
            String textoNormal = Helpers.normalizarTexto(texto);
            String nomeColecao = Helpers.normalizarTexto(livro.getNome());
            return nomeColecao.contains(textoNormal);
        });
        return this;
    }

    // Por Palavras-chave 
    public ColecaoFiltro porPalavra(String palavraChave) {
        String palavraChaveNormalizado = Helpers.normalizarTexto(palavraChave);

        filtros.add((Colecao livro) -> {
            String palavraChaveDoLivroNormalizado = Helpers.normalizarTexto(livro.getNome());
            return palavraChaveDoLivroNormalizado.contains(palavraChaveNormalizado);
        });
        return this;
    }

}
