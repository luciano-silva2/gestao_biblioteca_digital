package br.edu.ifpb.gestaobibliotecadigital.recommendations;


import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.recommendations.CriterioRecomendacao;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class CriterioMediaCategoria extends CriterioRecomendacao {

    private AvaliacaoService avaliacaoService;

    public CriterioMediaCategoria(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    public String recomendar(Livro livro) {
        return null;
    }


    public Map<String, List<Livro>> ordenarPorMediaECategoria(List<Livro> livros) {
        return livros.stream()
                .collect(Collectors.groupingBy(
                        Livro::getCategoria, 
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lista -> lista.stream()
                                        .sorted((livro1, livro2) -> {
                                            double media1 = avaliacaoService.calcularMediaAvaliacoes(livro1.getId());
                                            double media2 = avaliacaoService.calcularMediaAvaliacoes(livro2.getId());
                                            return Double.compare(media2, media1); 
                                        })
                                        .collect(Collectors.toList())
                        )
                ));
    }


    public void exibirLivrosOrdenadosPorCategoria(List<Livro> livros) {
        Map<String, List<Livro>> livrosPorCategoria = ordenarPorMediaECategoria(livros);

        System.out.println("Livros ordenados pela média das avaliações, agrupados por categoria:");
        for (Map.Entry<String, List<Livro>> entry : livrosPorCategoria.entrySet()) {
            String categoria = entry.getKey();
            List<Livro> livrosOrdenados = entry.getValue();

            System.out.println("Categoria: " + categoria);
            for (Livro livro : livrosOrdenados) {
                double media = avaliacaoService.calcularMediaAvaliacoes(livro.getId());
                System.out.println("  Livro: " + livro.getTitulo() + " | Média: " + media);
            }
        }
    }
}
