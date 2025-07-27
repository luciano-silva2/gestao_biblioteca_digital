package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public class MainRelatorios{
    public static void main(String[] args){
        ReportFacade facade = new ReportFacade();
        facade.gerarRelatorioSemanal();

        RelatorioLivrosCadastrados relatorio = new RelatorioLivrosCadastrados();
        relatorio.gerar(new PdfExportador());
    }
}