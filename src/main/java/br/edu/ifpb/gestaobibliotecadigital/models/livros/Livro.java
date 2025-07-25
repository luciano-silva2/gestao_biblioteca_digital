package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import java.util.UUID;

public abstract class Livro implements IColecaoLivros {

    protected final UUID id;
    protected String titulo;
    protected String autor;
    protected int ano;
    protected String editora;
    protected String ISBN;
    protected String sinopse;
    protected String categoria;

    private int totalAvaliacoes = 0;
    private int somaNotas = 0;

    public Livro(String titulo, String autor, int ano, String editora, String ISBN, String sinopse, String categoria) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
        this.ISBN = ISBN;
        this.sinopse = sinopse;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getSinopse() {
        return sinopse;
    }

    public double getTotalAvaliacoes() {
        return totalAvaliacoes == 0 ? 0.0 : (double) somaNotas / totalAvaliacoes;
    }

    public void adicionarAvaliacao(int nota) {
        this.totalAvaliacoes++;
        this.somaNotas += nota;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public abstract String getDescricao();

    @Override
    public String toString() {
        return "id: " + id + "\n"
                + "Título: " + titulo + "\n"
                + "Autor: " + autor + "\n"
                + "Ano: " + ano + "\n"
                + "Editora: " + editora + "\n"
                + "ISBN: " + ISBN + "\n"
                + "Categoria: " + categoria + "\n"
                + "Sinopse: " + sinopse + "\n"
                + "Avaliação média: " + String.format("%.2f", getTotalAvaliacoes()
                );
    }
}
