package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class LivroEmprestado extends EstadoLivro {

    public LivroEmprestado(LivroSimples livro) {
        super(livro);
    }

    @Override
    public String getNome() {
        return "Emprestado";
    }

    @Override
    public void devolver() {
        livro.setEstado(new LivroDisponivel(livro));
    }

    @Override
    public void emprestar() {
        // Já está emprestado
    }

    @Override
    public void reservar() {
        // Na prática o livro deveria poder ter vários estados, mas o padrão State só permite um
        livro.setEstado(new LivroReservado(livro));
    }

    @Override
    public void atrasar() {
        livro.setEstado(new LivroAtrasado(livro));
    }

    @Override
    public void expirarReserva() {
        // O livro não está reservado
    }

}
