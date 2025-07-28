/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;

public class CriterioMaisAvaliados extends CriterioRecomendacao {
    private AvaliacaoService avaliacaoService;

    public CriterioMaisAvaliados(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    //Livros que foram bem avaliados
    public String recomendar(Livro livro) {
        double media = avaliacaoService.calcularMediaAvaliacoes(livro.getId());
        if (media >= 4.0) {
            //return "Livros mais bem Avaliados:" + livro.getTitulo();
            return livro.getTitulo();
        } else if (proximo != null) {
            return proximo.recomendar(livro);
        }
        return null;
    }
}