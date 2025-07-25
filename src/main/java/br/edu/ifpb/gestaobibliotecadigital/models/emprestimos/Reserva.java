package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos;

import br.edu.ifpb.gestaobibliotecadigital.models.Modelo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class Reserva extends Modelo {

    private final Usuario usuario;
    private final Livro livro;
    private final LocalDateTime dataReserva;
    private final LocalDate dataExpiracao;
    private LocalDateTime dataEncerrada;
    private Emprestimo emprestimo;

    private static int DIAS_EXPIRACAO = 30;

    public Reserva(Usuario usuario, Livro livro) {
        super();
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = DataProvider.agora();
        this.dataExpiracao = DataProvider.agora().toLocalDate().plusDays(DIAS_EXPIRACAO);
        this.dataEncerrada = null;
        this.emprestimo = null;
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public LocalDateTime getDataEncerrada() {
        return dataEncerrada;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    // Setters
    public void setDataEncerrada(LocalDateTime dataEncerrada) {
        this.dataEncerrada = dataEncerrada;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    // Métodos
    /**
     * Retorna um booleano indicando se a reserva foi encerrada (se encerrado
     * pelo usuário, se expirada ou se obteve o livro)
     *
     * @return true se a reserva foi encerrada
     */
    public boolean encerrada() {
        if (expirada()) {
            return true;
        }

        return dataEncerrada != null;
    }

    /**
     * Retorna um booleano indicando se a reserva expirada
     *
     * @return true se a reserva expirada
     */
    public boolean expirada() {
        if (dataEncerrada != null) {
            return false;
        }

        return DataProvider.hoje().isAfter(dataExpiracao);
    }

    /**
     * Encerra a reserva com um empréstimo
     *
     * @param emprestimo Empréstimo realizado através desta reserva, ou null se
     * cancelada
     */
    public void encerrar(Emprestimo emprestimo) {
        if (expirada()) {
            throw new IllegalStateException("Não é possível encerrar esta reserva, pois já expirou.");
        }

        if (encerrada()) {
            throw new IllegalStateException("Esta reserva já foi encerrada");
        }

        if (emprestimo != null) {
            setEmprestimo(emprestimo);
        }

        setDataEncerrada(DataProvider.agora());
    }

    /**
     * Cancela a reserva sem levar o livro
     */
    public void cancelar() {
        encerrar(null);
    }

    public int diasParaExpirar() {
        if (expirada()) {
            return -1;
        }

        return (int) ChronoUnit.DAYS.between(DataProvider.hoje(), dataExpiracao);
    }

    // To string
    @Override
    public String toString() {
        String dataReservaStr = dataReserva.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String dataExpiracaoStr = dataExpiracao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataEncerradaStr = dataEncerrada != null ? dataEncerrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : "Não";
        String expiracaoStatus = diasParaExpirar() < 0 ? "(expirado)" : diasParaExpirar() == 0 ? "(expira hoje)" : "(em " + diasParaExpirar() + " dias)";
        String comEmprestimo = emprestimo != null ? "Sim" : "Não";

        return ""
                + "\n[Reserva \"" + id + "\"]"
                + "\n* USUÁRIO: " + usuario.getNome()
                + "\n* LIVRO: " + livro.getTitulo()
                + "\n* DATA DE RESERVA: " + dataReservaStr
                + "\n* DATA DE EXPIRAÇÃO: " + dataExpiracaoStr + " " + expiracaoStatus
                + "\n* ENCERRADO EM: " + dataEncerradaStr
                + "\n* COM EMPRÉSTIMO: " + comEmprestimo
                + "\n";
    }
}
