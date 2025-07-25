package br.edu.ifpb.gestaobibliotecadigital.services.interfaces;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public interface IEmprestimoService {

    public Emprestimo solicitarEmprestimo(Usuario usuario, LivroSimples livro);

    public void renovarEmprestimo(Emprestimo emprestimo);

    public void devolverLivro(Emprestimo emprestimo);

    public void reservarLivro(Usuario usuario, LivroSimples livro);

    public void cancelarReserva(Reserva reserva);

    public boolean livroEstaEmprestado(LivroSimples livro);

    public boolean livroEstaReservado(LivroSimples livro);

    public boolean livroDisponivelParaEmprestimo(LivroSimples livro);

    public boolean livroDisponivelParaReserva(LivroSimples livro);
}
