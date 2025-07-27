package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public class RelatorioSemanal extends RelatorioTemplate {

    protected String gerarCabecalho(){
        return "Relatorio Semanal\n";
    }

    protected String gerarCorpo(){
        return "Livros Emprestados: " + FakeDataBase.livrosEmprestados() + "\nReservas pendentes: " + FakeDataBase.reservasPendentes() + "\n";
    }

    
}
