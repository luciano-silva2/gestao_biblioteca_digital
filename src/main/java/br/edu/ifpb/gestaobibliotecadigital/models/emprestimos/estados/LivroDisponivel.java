package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class LivroDisponivel extends EstadoLivro {

    public LivroDisponivel(LivroSimples livro) {
        super(livro);
    }

    @Override
    public String getNome() {
        return "Disponível";
    }

    @Override
    public void devolver() {
        // Já está disponível
    }

    @Override
    public void emprestar() {
        livro.setEstado(new LivroEmprestado(livro));
    }

    @Override
    public void reservar() {
        livro.setEstado(new LivroReservado(livro));
    }

    @Override
    public void atrasar() {
        // Não tem como ficar atrasado se não está emprestado
    }

    @Override
    public void expirarReserva() {
        // O livro não está reservado
    }

}
