/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public abstract class CriterioRecomendacao {
    protected CriterioRecomendacao proximo;

    public void setProximo(CriterioRecomendacao proximo) {
        this.proximo = proximo;
    }

    public abstract String recomendar(Livro livro);
}