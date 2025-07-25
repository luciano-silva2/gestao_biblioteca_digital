package br.edu.ifpb.gestaobibliotecadigital.filters;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.historico.HistoricoAcao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import java.util.List;

public class HistoricoFiltro extends Filtro<HistoricoAcao> {

    public HistoricoFiltro(List<HistoricoAcao> historico) {
        super(historico);
    }

    public HistoricoFiltro porLivro(LivroSimples livro) {
        filtros.add(historico -> historico.getLivro().getId().equals(livro.getId()));
        return this;
    }

    public HistoricoFiltro porUsuario(Usuario usuario) {
        filtros.add(historico -> historico.getUsuario().getId().equals(usuario.getId()));
        return this;
    }

}
