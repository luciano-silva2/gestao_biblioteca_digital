package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaColecao extends TabelaItensPanel<Colecao> {

    public TabelaColecao() {
        super(new ArrayList<>());
    }

    public TabelaColecao(List<Colecao> colecoes) {
        super(colecoes);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {"Nome"};
        return colunas;
    }

    @Override
    protected Object getValueAt(Colecao item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getNome();
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }
}
