package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.Normalizer;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.Icon;

public class Helpers {

    /**
     * Normaliza o texto.
     *
     * @param texto O texto a ser normalizado.
     * @return O texto normalizado, sem acentuação e em minúsculas.
     */
    public static String normalizarTexto(String texto) {
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }

    /**
     * Array constante com categorias de livro utilizadas para classificação.
     */
    public static final String[] CATEGORIAS = {
        "Romance",
        "Ficção Científica",
        "Fantasia",
        "Suspense",
        "Aventura",
        "História",
        "Filosofia",
        "Poesia",
        "Drama",
        "Infantil",
        "Clássicos de Ficção",
        "Tecnologia",
        "Ciência",};

    /**
     * Retorna as categorias com ou sem o placeholder.
     *
     * @param incluirPlaceholder se true, inclui "Selecione uma categoria" no
     * início
     * @return array de categorias
     */
    public static String[] getCategorias(boolean incluirPlaceholder) {
        if (incluirPlaceholder) {
            String[] resultado = new String[CATEGORIAS.length + 1];
            resultado[0] = "Selecione uma categoria";
            System.arraycopy(CATEGORIAS, 0, resultado, 1, CATEGORIAS.length);
            return resultado;
        }
        return CATEGORIAS.clone();
    }

    /**
     * Gera uma lista de anos, iniciando em 1980 até o ano atual.
     *
     * @param incluirPlaceholder
     * @return Um array de Strings contendo os anos disponíveis.
     */
    public static String[] getAnos(boolean incluirPlaceholder) {
        List<String> anos = new ArrayList<>();
        int anoAtual = Year.now().getValue();
        if (incluirPlaceholder) {
            anos.add("Selecione um ano");
        }
        for (int i = anoAtual; i >= 1900; i--) {
            anos.add(String.valueOf(i));
        }
        return anos.toArray(String[]::new);
    }

    public static Image iconToImage(Icon icon) {
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }
}
