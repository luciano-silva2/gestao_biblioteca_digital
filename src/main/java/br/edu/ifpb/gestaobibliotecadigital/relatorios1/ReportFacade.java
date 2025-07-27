package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public class ReportFacade {
    public void gerarRelatorioSemanal(){
        RelatorioTemplate relatorio = new RelatorioSemanal();
        relatorio.gerar(new PdfExportador());
    }

    // public void gerarRelatorioMensalCSV(){
    //     RelatorioTemplate relatorio = new RelatorioMensal();
    //     relatorio.gerar(new CsvExportador());
    // }
}
