package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;

public class AvaliacaoRepository extends Repositorio<Avaliacao> {

    private static AvaliacaoRepository instance;

    private AvaliacaoRepository() {
        super("databases/avaliacao.dat");
    }

    @Override
    protected String getId(Avaliacao item) {
        return item.getId().toString();
    }

    public static AvaliacaoRepository getInstance() {
        if (instance == null) {
            instance = new AvaliacaoRepository();
        }
        return instance;
    }

    @Override
    protected String getNome() {
        return "Avaliação";
    }
}
