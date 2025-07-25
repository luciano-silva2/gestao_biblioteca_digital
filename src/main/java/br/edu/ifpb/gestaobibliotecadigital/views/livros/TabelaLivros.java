package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class TabelaLivros extends TabelaItensPanel<Livro> {

    public TabelaLivros() {
        super(new ArrayList<Livro>());
    }

    public TabelaLivros(List<Livro> livros) {
        super(livros);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"ISBN", "Titulo", "Editora", "Categoria", "Ano"};
        return colunas;
    }

    @Override
    protected Object getValueAt(Livro item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getISBN();
            case 1 ->
                item.getTitulo();
            case 2 ->
                item.getEditora();
            case 3 ->
                item.getCategoria();
            case 4 ->
                String.valueOf(item.getAno());
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 1;
    }

    @Override
    protected boolean isOrdenacaoDecrescente() {
        return true;
    }
}
