package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public class PdfExportador implements Exportador {
    public void exportar(String conteudo){
        System.out.println("Exportando para PDF:\n" + conteudo);
    }
}
