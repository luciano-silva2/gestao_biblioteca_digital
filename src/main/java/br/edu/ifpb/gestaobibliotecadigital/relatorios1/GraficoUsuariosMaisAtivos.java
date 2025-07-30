package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GraficoUsuariosMaisAtivos {

    public void exibir(Map<String, Integer> dados) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entrada : dados.entrySet()) {
            dataset.addValue(entrada.getValue(), "Usuários", entrada.getKey());
        }

        JFreeChart grafico = ChartFactory.createBarChart(
                "Usuários Mais Ativos",
                "Nome",
                "Interações",
                dataset
        );

        try {
            ChartUtils.saveChartAsPNG(new File("/workspaces/gestao_biblioteca_digital/src/main/java/br/edu/ifpb/gestaobibliotecadigital/relatorios1/Graficos/grafico_usuarios_mais_ativos.png"), grafico, 800, 600);
            System.out.println("Gráfico salvo em: " + "/workspaces/gestao_biblioteca_digital/src/main/java/br/edu/ifpb/gestaobibliotecadigital/relatorios1/Graficos/grafico_usuarios_mais_ativos.png");
        } catch (IOException e) {
            System.err.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}

