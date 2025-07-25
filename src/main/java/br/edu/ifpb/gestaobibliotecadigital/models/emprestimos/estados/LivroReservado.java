package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class LivroReservado extends EstadoLivro {

    public LivroReservado(LivroSimples livro) {
        super(livro);
    }

    @Override
    public String getNome() {
        return "Reservado";
    }

    @Override
    public void devolver() {
        // Não tem como devolver livro reservado, pois não está com ele
    }

    @Override
    public void emprestar() {
        livro.setEstado(new LivroEmprestado(livro));
    }

    @Override
    public void reservar() {
        // Já está reservado
    }

    @Override
    public void atrasar() {
        // Não pode atrasar o livro, pois não está com ele
    }

    @Override
    public void expirarReserva() {
        // Problema: se o livro estiver emprestado e reservado ao mesmo tempo, ele ficará disponível, não tem como detectar isso por aqui por enquanto
        livro.setEstado(new LivroDisponivel(livro));
    }

}
