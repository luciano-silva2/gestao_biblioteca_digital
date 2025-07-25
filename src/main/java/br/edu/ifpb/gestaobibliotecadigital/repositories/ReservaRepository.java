package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.filters.ReservaFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class ReservaRepository extends Repositorio<Reserva> {

    private static ReservaRepository instance;

    private ReservaRepository() {
        super("databases/reservas.dat");
    }

    @Override
    protected String getId(Reserva item) {
        return item.getId().toString();
    }

    public static ReservaRepository getInstance() {
        if (instance == null) {
            instance = new ReservaRepository();
        }
        return instance;
    }

    public Reserva reservaLivro(Livro livro) {
        // Procura se há reservas válidas com este livro
        List<Reserva> reservas = new ReservaFiltro(itens)
                .porLivro(livro).ativas().filtrar();

        // Se não houver reservas, retorna null
        if (reservas.isEmpty()) {
            return null;
        }

        // Retorna a primeira reserva, pois só pode haver uma
        return reservas.get(0);
    }

    @Override
    protected String getNome() {
        return "Reserva";
    }
}
