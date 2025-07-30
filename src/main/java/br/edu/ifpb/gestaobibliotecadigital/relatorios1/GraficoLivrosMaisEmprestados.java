package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GraficoLivrosMaisEmprestados {

    public void exibir(Map<String, Integer> dados) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entrada : dados.entrySet()) {
            dataset.addValue(entrada.getValue(), "Livros", entrada.getKey());
        }

        JFreeChart grafico = ChartFactory.createBarChart(
                "Livros Mais Emprestados",
                "Título",
                "Quantidade",
                dataset
        );

        try {
            ChartUtils.saveChartAsPNG(new File("/workspaces/gestao_biblioteca_digital/src/main/java/br/edu/ifpb/gestaobibliotecadigital/relatorios1/Graficos/grafico_livros_mais_emprestados.png"), grafico, 800, 600);
            System.out.println("Gráfico salvo em: " + "/workspaces/gestao_biblioteca_digital/src/main/java/br/edu/ifpb/gestaobibliotecadigital/relatorios1/Graficos/grafico_livros_mais_emprestados.png");
        } catch (IOException e) {
            System.err.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}

