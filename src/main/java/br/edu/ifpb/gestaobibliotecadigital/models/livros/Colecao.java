package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.Modelo;
import java.util.ArrayList;
import java.util.List;

public class Colecao extends Modelo implements IColecaoLivros {

    private final String nome;
    private final List<IColecaoLivros> colecaoLivros = new ArrayList<>();

    public Colecao(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<IColecaoLivros> getColecaoLivros() {
        return colecaoLivros;
    }

    public void adicionar(IColecaoLivros livro) {
        colecaoLivros.add(livro);
    }

    public void remover(IColecaoLivros livro) {
        colecaoLivros.remove(livro);
    }

    public List<IColecaoLivros> getColecao() {
        return colecaoLivros;
    }

    public List<IColecaoLivros> getItens() {
        return colecaoLivros;
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder("Coleção: " + nome + "\n");
        for (IColecaoLivros livro : colecaoLivros) {
            sb.append("  - ").append(livro.getDescricao()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (IColecaoLivros livro : colecaoLivros) {
            sb.append(livro.getDescricao()).append('\n');
        }
        return sb.toString();
    }
}
