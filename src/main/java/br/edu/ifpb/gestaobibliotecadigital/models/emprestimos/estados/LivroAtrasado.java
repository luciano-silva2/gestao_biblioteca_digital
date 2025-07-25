package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class LivroAtrasado extends EstadoLivro {

    public LivroAtrasado(LivroSimples livro) {
        super(livro);
    }

    @Override
    public String getNome() {
        return "Atrasado";
    }

    @Override
    public void devolver() {
        livro.setEstado(new LivroDisponivel(livro));
    }

    @Override
    public void emprestar() {
        // Já está emprestado, mas atrasado
    }

    @Override
    public void reservar() {
        livro.setEstado(new LivroReservado(livro));
    }

    @Override
    public void atrasar() {
        // Já está atrasado
    }

    @Override
    public void expirarReserva() {
        // O livro não está reservado
    }

}
