package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.historico;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class HistoricoAcao implements Serializable {

    private final UUID id;
    private final LocalDateTime dataHora;

    private final Usuario usuario;
    private final Livro livro;
    private final Emprestimo emprestimo;
    private final Reserva reserva;
    private final TipoAcao acao;

    public HistoricoAcao(Usuario usuario, Livro livro, Emprestimo emprestimo, Reserva reserva, TipoAcao acao) {
        this.id = UUID.randomUUID();
        this.dataHora = DataProvider.agora();
        this.usuario = usuario;
        this.livro = livro;
        this.emprestimo = emprestimo;
        this.reserva = reserva;
        this.acao = acao;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public TipoAcao getAcao() {
        return acao;
    }

}
