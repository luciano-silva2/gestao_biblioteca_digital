package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos;

import br.edu.ifpb.gestaobibliotecadigital.models.Modelo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EstrategiaEmprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class Emprestimo extends Modelo {

    private final Usuario usuario;
    private final Livro livro;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolvido;
    private final ArrayList<LocalDateTime> renovacoes;
    private final EstrategiaEmprestimo estrategiaEmprestimo;
    private LocalDateTime dataPagamentoMulta;

    public Emprestimo(Usuario usuario, Livro livro, EstrategiaEmprestimo estrategiaEmprestimo) {
        super();
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = DataProvider.agora();
        this.dataDevolvido = null;
        this.renovacoes = new ArrayList<>();
        this.estrategiaEmprestimo = estrategiaEmprestimo;
        this.dataPagamentoMulta = null;
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolvido() {
        return dataDevolvido;
    }

    public ArrayList<LocalDateTime> getRenovacoes() {
        return renovacoes;
    }

    public EstrategiaEmprestimo getEstrategiaEmprestimo() {
        return estrategiaEmprestimo;
    }

    public LocalDateTime getDataPagamentoMulta() {
        return dataPagamentoMulta;
    }

    // Setters
    public void setDataDevolvido(LocalDateTime dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

    public void setDataPagamentoMulta(LocalDateTime dataPagamentoMulta) {
        if (!foiDevolvido()) {
            throw new IllegalStateException("O livro ainda não foi devolvido");
        }

        this.dataPagamentoMulta = dataPagamentoMulta;
    }

    // Métodos
    /**
     * Retorna um boolean indicando se o livro foi devolvido
     *
     * @return true se o livro foi devolvido
     */
    public boolean foiDevolvido() {
        return dataDevolvido != null;
    }

    /**
     * Retorna um boolean indicando se o usuário pode renovar o livro
     *
     * @return true se pode renovar o livro
     */
    public boolean podeRenovar() {
        // Se o livro foi devolvido, não pode renovar
        if (foiDevolvido()) {
            return false;
        }

        int renovacoesRestantes = getQuantidadeRenovacoesRestantes();

        // Se o número de renovações for 0, significa que não pode mais renovar
        if (renovacoesRestantes <= 0) {
            return false;
        }

        // Se o livro está atrasado, significa que não pode mais renovar
        return !estaAtrasado();
    }

    /**
     * Renova o empréstimo na data atual
     *
     * @throws IllegalStateException Se não puder renovar, seja por limite de
     * renovações, ou por estar atrasado
     */
    public void renovar() {
        if (!podeRenovar()) {
            if (estaAtrasado()) {
                throw new IllegalStateException("Você não pode renovar, pois seu livro está atrasado");
            }
            throw new IllegalStateException("Você excedeu o limite de renovações");
        }

        renovacoes.add(DataProvider.agora());
    }

    /**
     * Retorna a data da última renovação, caso não exista, retorna null
     *
     * @return LocalDateTime da última renovação ou null
     */
    public LocalDateTime getDataUltimaRenovacao() {
        if (renovacoes.isEmpty()) {
            return null;
        }

        LocalDateTime ultimaRenovacao = renovacoes.get(renovacoes.size() - 1);
        return ultimaRenovacao;
    }

    /**
     * Retorna a data da última renovação, caso não exista, retorna a data do
     * empréstimo
     *
     * @return LocalDateTime da última renovação ou data do empréstimo
     */
    public LocalDateTime getDataUltimaRenovacaoOuEmprestimo() {
        if (renovacoes.isEmpty()) {
            return dataEmprestimo;
        }

        return getDataUltimaRenovacao();
    }

    /**
     * Retorna a data que o usuário tem que renovar ou devolver o livro
     *
     * @return Data limite de renovação/devolução
     */
    public LocalDate getDataRenovacaoOuDevolucao() {
        LocalDateTime dataUltimaRenovacao = getDataUltimaRenovacaoOuEmprestimo();
        int maximoDias = getMaximoDias();
        LocalDateTime dataDevolucao = dataUltimaRenovacao.plusDays(maximoDias);
        return dataDevolucao.toLocalDate();
    }

    /**
     * Calcula o número de dias que o livro foi emprestado para o usuário
     *
     * @return Dias de empréstimo
     */
    public int getDiasEmprestado() {
        if (foiDevolvido()) {
            return (int) ChronoUnit.DAYS.between(dataEmprestimo.toLocalDate(), dataDevolvido.toLocalDate());
        } else {
            LocalDateTime dataAtual = DataProvider.agora();
            return (int) ChronoUnit.DAYS.between(dataEmprestimo.toLocalDate(), dataAtual.toLocalDate());
        }
    }

    /**
     * Calcula o número de dias que o livro foi emprestado para o usuário desde
     * a última renovação
     *
     * @return Dias desde a última renovação
     */
    public int getDiasEmprestadoDesdeUltimaRenovacao() {
        if (foiDevolvido()) {
            LocalDateTime dataUltimaRenovacao = getDataUltimaRenovacaoOuEmprestimo();
            return (int) ChronoUnit.DAYS.between(dataUltimaRenovacao.toLocalDate(), dataDevolvido.toLocalDate());
        } else {
            LocalDateTime dataAtual = DataProvider.agora();
            LocalDateTime dataUltimaRenovacao = getDataUltimaRenovacaoOuEmprestimo();
            return (int) ChronoUnit.DAYS.between(dataUltimaRenovacao.toLocalDate(), dataAtual.toLocalDate());
        }
    }

    /**
     * Calcula o número de dias que o livro está atrasado
     *
     * @return Quantidade de dias de atraso
     */
    public int getDiasAtraso() {
        int diasEmprestado = getDiasEmprestadoDesdeUltimaRenovacao();
        int maximoDias = getMaximoDias();
        int diasAtraso = diasEmprestado - maximoDias;

        // Se os dias de atraso são negativos, significa que não está atrasado
        if (diasAtraso <= 0) {
            return 0;
        }

        return diasAtraso;
    }

    /**
     * Retorna um boolean indicando se o livro está ou não atrasado
     *
     * @return true se o livro está atrasado
     */
    public boolean estaAtrasado() {
        return getDiasAtraso() > 0;
    }

    /**
     * Retorna o número máximo de dias que o usuário pode ficar com o livro sem
     * precisar renovar ou devolver
     *
     * @return Número máximo de dias
     */
    public int getMaximoDias() {
        return estrategiaEmprestimo.calcularMaximoDias();
    }

    /**
     * Retorna o valor da multa. Caso não haja multa, retorna 0
     *
     * @return Valor da multa
     */
    public double getMulta() {
        return estrategiaEmprestimo.calcularMulta(getDiasAtraso());
    }

    /**
     * Retorna um boolean indicando se tem multa que precisa ser paga
     *
     * @return true se tem multa pendente
     */
    public boolean temMultaPendente() {
        // Caso o valor da multa seja 0, significa que não tem multa
        if (getMulta() == 0) {
            return false;
        }

        return dataPagamentoMulta == null;
    }

    /**
     * Retorna o número máximo de renovações que podem ser feitas neste
     * empréstimo
     *
     * @return Número máximo de renovações
     */
    public int getMaximoRenovacoes() {
        return estrategiaEmprestimo.calcularMaximoRenovacoes();
    }

    /**
     * Retorna a quantidade de renovações que já foram feitas
     *
     * @return Quantidade de renovações
     */
    public int getQuantidadeRenovacoes() {
        return renovacoes.size();
    }

    /**
     * Retorna a quantidade de renovações que o usuário ainda pode fazer
     *
     * @return Renovações restantes
     */
    public int getQuantidadeRenovacoesRestantes() {
        return getMaximoRenovacoes() - getQuantidadeRenovacoes();
    }

    // To string
    @Override
    public String toString() {
        String dataEmprestimoStr = dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String dataDevolucaoStr = getDataRenovacaoOuDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String renovarDevolverStr = (podeRenovar() ? "RENOVAR ATÉ: " : "DEVOLVER ATÉ: ");
        String dataUltimaRenovacaoStr = getDataUltimaRenovacao() == null ? "Nunca" : getDataUltimaRenovacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String atrasadoStr = estaAtrasado() ? getDiasAtraso() + " dias" : "Não";
        double multa = getMulta();
        String valorMultaStr = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(multa);
        String dataPagamentoMultaStr = dataPagamentoMulta == null ? "" : dataPagamentoMulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String multaPagaStr = dataPagamentoMulta == null ? "(pendente)" : "(paga em: " + dataPagamentoMultaStr + ")";
        String multaStr = multa == 0 ? "Não" : valorMultaStr + " " + multaPagaStr;

        return ""
                + "\n[Empréstimo \"" + id + "\"]"
                + "\n* USUÁRIO: " + usuario.getNome()
                + "\n* LIVRO: " + livro.getTitulo()
                + "\n* ESTRATÉGIA: " + estrategiaEmprestimo.getNome()
                + "\n* DATA DE EMPRÉSTIMO: " + dataEmprestimoStr
                + "\n* DATA DA ÚLTIMA RENOVAÇÃO: " + dataUltimaRenovacaoStr
                + "\n* " + renovarDevolverStr + dataDevolucaoStr
                + "\n* QTD. DIAS COM O LIVRO: " + getDiasEmprestado()
                + "\n* QTD. DIAS DESDE A ÚLTIMA RENOVAÇÃO: " + getDiasEmprestadoDesdeUltimaRenovacao()
                + "\n* ATRASADO: " + atrasadoStr
                + "\n* MULTA: " + multaStr
                + "\n";
    }
}
