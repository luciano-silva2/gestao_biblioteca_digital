package br.edu.ifpb.gestaobibliotecadigital.repositories;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import java.util.Optional;

public class ColecaoRepository extends Repositorio<Colecao> {

    private static ColecaoRepository instance;

    private ColecaoRepository() {
        super("databases/colecoes.dat");
    }

    public static ColecaoRepository getInstance() {
        if (instance == null) {
            instance = new ColecaoRepository();
        }
        return instance;
    }
    

    @Override
    protected String getId(Colecao item) {
        return item.getNome();
    }
    
   
    public Optional<Colecao> findByNome(String nome) {
        return this.itens.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}

