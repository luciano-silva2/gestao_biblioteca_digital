package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.EstadoLivro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.LivroDisponivel;

public class LivroSimples extends Livro {

    private EstadoLivro estado = new LivroDisponivel(this);

    private LivroSimples(Builder builder) {
        super(builder.titulo, builder.autor, builder.ano, builder.editora, builder.ISBN, builder.sinopse, builder.categoria);
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public void definirDisponivel() {
        this.estado.devolver();
    }

    public void definirEmprestado() {
        this.estado.emprestar();
    }

    public void definirReservado() {
        this.estado.reservar();
    }

    public void definirAtrasado() {
        this.estado.atrasar();
    }

    @Override
    public String getDescricao() {
        return "Título: " + titulo + "\n"
                + "Autor: " + autor + "\n"
                + "Ano: " + ano + "\n"
                + "Editora: " + editora + "\n"
                + "ISBN: " + ISBN + "\n"
                + "Categoria: " + categoria + "\n"
                + "Sinopse: " + sinopse + "\n"
                + "Avaliação média: " + String.format("%.2f", getTotalAvaliacoes());
    }

    public static class Builder {

        private String titulo;
        private String autor;
        private int ano;
        private String editora;
        private String ISBN;
        private String sinopse;
        private String categoria;

        public Builder(String ISBN) {
            if (ISBN.trim().isBlank()) {
                throw new IllegalArgumentException("ISBN é obrigatório");
            }
            this.ISBN = ISBN;
        }

        public Builder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder setAutor(String autor) {
            this.autor = autor;
            return this;
        }
        
        public Builder setISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Builder setAno(int ano) {
            this.ano = ano;
            return this;
        }

        public Builder setEditora(String editora) {
            this.editora = editora;
            return this;
        }

        public Builder setSinopse(String sinopse) {
            this.sinopse = sinopse;
            return this;
        }

        public Builder setCategoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public LivroSimples build() {
            return new LivroSimples(this);
        }
    }

}
