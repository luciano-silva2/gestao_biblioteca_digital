/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CriterioAutor extends CriterioRecomendacao {
    private List<Livro> autorOrdenado;
    
    public CriterioAutor(List<Livro> livros){
        this.autorOrdenado = livros.stream()
                .sorted((livro1, livro2) -> livro1.getAutor().compareToIgnoreCase(livro2.getAutor()))
                .collect(Collectors.toList());
    }
    
    @Override
    public String recomendar(Livro livro) {
        for (Livro l : autorOrdenado) {
            //Livro recomendado por ordem alfabética de autor
            if (l.getId().equals(livro.getId())) {
                return livro.getTitulo();
            }
        }
        if (proximo != null) {
            return proximo.recomendar(livro);
        }
        return null;
    }
}
