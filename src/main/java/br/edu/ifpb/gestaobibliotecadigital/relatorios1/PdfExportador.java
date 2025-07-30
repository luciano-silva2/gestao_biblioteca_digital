package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;

public class PdfExportador implements Exportador {
    @Override
    public void exportar(String conteudo){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
            document.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font corpo = FontFactory.getFont(FontFactory.HELVETICA, 12);

            document.add(new Paragraph("Relatório", titulo));
            document.add(new Paragraph(" ", corpo)); // espaço

            String[] linhas = conteudo.split("\n");
            for (String linha : linhas) {
                document.add(new Paragraph(linha, corpo));
            }

            document.close();
            System.out.println("PDF gerado com sucesso: relatorio.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}
