package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public class CsvExportador implements Exportador{
    public void exportar(String conteudo){
        System.out.println("Exportador para Csv:\n" + conteudo);
    }
}
