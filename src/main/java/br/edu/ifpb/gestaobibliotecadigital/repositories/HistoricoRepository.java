package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.historico.HistoricoAcao;

public class HistoricoRepository extends Repositorio<HistoricoAcao> {

    private static HistoricoRepository instance;

    private HistoricoRepository() {
        super("databases/historico.dat");
    }

    @Override
    protected String getId(HistoricoAcao item) {
        return item.getId().toString();
    }

    public static HistoricoRepository getInstance() {
        if (instance == null) {
            instance = new HistoricoRepository();
        }
        return instance;
    }

    @Override
    protected String getNome() {
        return "Histórico";
    }
}
