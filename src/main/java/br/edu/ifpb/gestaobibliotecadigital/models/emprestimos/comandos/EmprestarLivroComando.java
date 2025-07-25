package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.comandos;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;

public class EmprestarLivroComando implements ComandoEmprestimo {

    private final EmprestimoService service;
    private final Usuario usuario;
    private final LivroSimples livro;

    public EmprestarLivroComando(EmprestimoService service, Usuario usuario, LivroSimples livro) {
        this.service = service;
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void executar() {
        service.solicitarEmprestimo(usuario, livro);
    }

}
