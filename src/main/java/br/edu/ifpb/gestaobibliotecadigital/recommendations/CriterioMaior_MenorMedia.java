/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;

import java.util.List;
import java.util.stream.Collectors;

public class CriterioMaior_MenorMedia extends CriterioRecomendacao {

    private AvaliacaoService avaliacaoService;

    public CriterioMaior_MenorMedia(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    public String recomendar(Livro livro) {
        return null;
    }

    public List<Livro> ordenarPorMedia(List<Livro> livros) {
        return livros.stream()
                .sorted((livro1, livro2) -> {
                    double media1 = avaliacaoService.calcularMediaAvaliacoes(livro1.getId());
                    double media2 = avaliacaoService.calcularMediaAvaliacoes(livro2.getId());
                    return Double.compare(media2, media1); 
                })
                .collect(Collectors.toList());
    }

    public void exibirLivrosOrdenados(List<Livro> livros) {
        List<Livro> livrosOrdenados = ordenarPorMedia(livros);
        System.out.println("Livros ordenados pela média das avaliações (maior para menor):");
        for (Livro livro : livrosOrdenados) {
            double media = avaliacaoService.calcularMediaAvaliacoes(livro.getId());
            System.out.println("Livro: " + livro.getTitulo() + " | Média: " + media);
        }
    }
}
