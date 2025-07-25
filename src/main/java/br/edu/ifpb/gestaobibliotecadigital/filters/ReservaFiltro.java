package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class ReservaFiltro extends Filtro<Reserva> {

    public ReservaFiltro() {
        super();
    }

    public ReservaFiltro(List<Reserva> reservas) {
        super(reservas);
    }

    public ReservaFiltro porNomeUsuario(String nome) {
        filtros.add(emprestimo -> Helpers.normalizarTexto(emprestimo.getUsuario().getNome()).contains(Helpers.normalizarTexto(nome)));
        return this;
    }

    public ReservaFiltro porNomeLivro(String nome) {
        filtros.add(emprestimo -> Helpers.normalizarTexto(emprestimo.getLivro().getTitulo()).contains(Helpers.normalizarTexto(nome)));
        return this;
    }

    public ReservaFiltro pesquisar(String texto) {
        filtros.add(emprestimo -> {
            String textoNormal = Helpers.normalizarTexto(texto);
            String titulo = Helpers.normalizarTexto(emprestimo.getLivro().getTitulo());
            String nomeUsuario = Helpers.normalizarTexto(emprestimo.getUsuario().getNome().toLowerCase());
            return titulo.contains(textoNormal) || nomeUsuario.contains(textoNormal);
        });
        return this;
    }

    public ReservaFiltro porLivro(Livro livro) {
        filtros.add(reserva -> reserva.getLivro().getId().equals(livro.getId()));
        return this;
    }

    public ReservaFiltro ativas() {
        filtros.add(reserva -> !reserva.encerrada());
        return this;
    }

    public ReservaFiltro encerradas() {
        filtros.add(reserva -> reserva.encerrada());
        return this;
    }
}
