package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import br.edu.ifpb.gestaobibliotecadigital.relatorios.Relatorio;

public class MainRelatorios{
    public static void main(String[] args){
        ReportFacade facade = new ReportFacade();
        facade.gerarRelatorioSemanal();

        RelatorioLivrosCadastrados relatorio = new RelatorioLivrosCadastrados();
        relatorio.gerar(new PdfExportador());

        Relatorio r = new Relatorio();
        r.livrosMaisEmprestados();
    }
}