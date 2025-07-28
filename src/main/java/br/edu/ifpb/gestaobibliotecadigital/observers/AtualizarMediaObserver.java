/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.observers;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;

public class AtualizarMediaObserver implements AvaliacaoObserver {
    private AvaliacaoService avaliacaoService;

    public AtualizarMediaObserver(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    public void notificarNovaAvaliacao(Avaliacao avaliacao) {
        double novaMedia = avaliacaoService.calcularMediaAvaliacoes(avaliacao.getLivro().getId());
        System.out.println("A média de avaliações para o livro '" + avaliacao.getLivro().getTitulo() + "' foi atualizada para: " + novaMedia);
    }
}