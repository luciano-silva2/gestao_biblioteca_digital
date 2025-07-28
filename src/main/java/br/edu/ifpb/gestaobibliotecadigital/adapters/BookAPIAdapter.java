/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.adapters;

import br.edu.ifpb.gestaobibliotecadigital.external.ExternalBookAPI;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class BookAPIAdapter {
    private ExternalBookAPI externalAPI;

    public BookAPIAdapter() {
        this.externalAPI = new ExternalBookAPI();
    }

    public Livro buscarLivroPorISBN(String isbn) {
        String info = externalAPI.getBookInfo(isbn);
        if (info.equals("Informações não encontradas")) {
            return null;
        }

        String[] dados = info.split(",");
        return new LivroSimples.Builder(isbn)
                .setTitulo(dados[0])
                .setAutor(dados[1])
                .setAno(2025)
                .setEditora("Editora Externa")
                .setSinopse("Descrição externa")
                .setCategoria(dados[2])
                .build();
    }
}