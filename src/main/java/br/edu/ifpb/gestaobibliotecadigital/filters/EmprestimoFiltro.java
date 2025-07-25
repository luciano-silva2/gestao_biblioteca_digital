package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class EmprestimoFiltro extends Filtro<Emprestimo> {

    public EmprestimoFiltro() {
        super();
    }

    public EmprestimoFiltro(List<Emprestimo> emprestimos) {
        super(emprestimos);
    }

    public EmprestimoFiltro porLivro(Livro livro) {
        filtros.add(emprestimo -> emprestimo.getLivro().getId().equals(livro.getId()));
        return this;
    }

    public EmprestimoFiltro porNomeUsuario(String nome) {
        filtros.add(emprestimo -> Helpers.normalizarTexto(emprestimo.getUsuario().getNome()).contains(Helpers.normalizarTexto(nome)));
        return this;
    }

    public EmprestimoFiltro porNomeLivro(String nome) {
        filtros.add(emprestimo -> Helpers.normalizarTexto(emprestimo.getLivro().getTitulo()).contains(Helpers.normalizarTexto(nome)));
        return this;
    }

    public EmprestimoFiltro pesquisar(String texto) {
        filtros.add(emprestimo -> {
            String textoNormal = Helpers.normalizarTexto(texto);
            String titulo = Helpers.normalizarTexto(emprestimo.getLivro().getTitulo());
            String nomeUsuario = Helpers.normalizarTexto(emprestimo.getUsuario().getNome().toLowerCase());
            return titulo.contains(textoNormal) || nomeUsuario.contains(textoNormal);
        });
        return this;
    }

    public EmprestimoFiltro devolvido() {
        filtros.add(emprestimo -> emprestimo.foiDevolvido());
        return this;
    }

    public EmprestimoFiltro naoDevolvido() {
        filtros.add(emprestimo -> !emprestimo.foiDevolvido());
        return this;
    }
}
