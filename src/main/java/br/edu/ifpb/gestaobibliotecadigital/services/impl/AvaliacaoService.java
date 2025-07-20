/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.repositories.AvaliacaoRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.AvaliacaoObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AvaliacaoService {
    private AvaliacaoRepository repositorio = AvaliacaoRepository.getInstance();
    private List<AvaliacaoObserver> observers = new ArrayList<>();

    public void adicionarObserver(AvaliacaoObserver observer) {
        observers.add(observer);
    }

    private void notificarObservers(Avaliacao avaliacao) {
        for (AvaliacaoObserver observer : observers) {
            observer.notificarNovaAvaliacao(avaliacao);
        }
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5 estrelas.");
        }
        repositorio.adicionar(avaliacao);
    }

    //Listar Avaliacoes
    public List<Double> listarAvaliacoesPorLivro(UUID livroId) {
        //System.out.println(repositorio.listar());

        List<Double> notas = new ArrayList<>();
        for (Avaliacao item : repositorio.listar()){

            if (item.getId().equals(livroId)){
                notas.add(item.getNota());
            }
        }
        return notas;
    }

    public double calcularMediaAvaliacoes(UUID livroId) {
        List<Double> avaliacoes = listarAvaliacoesPorLivro(livroId);
        double media = 0;
        
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        for (double nota : avaliacoes){
            media += nota;
        }
        return media / avaliacoes.size();
    }
    
}
