package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.services.impl.LivroService;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class LivroController extends Controller {
    
    private final LivroService livroService = new LivroService();
    
    public void criar(Livro livroNovo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.criarLivro(livroNovo);
    }
    
    public void atualizar(Livro livroAtualizar) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.atualizar(livroAtualizar);
    }
    
    public void deletar(Livro livroDeletar) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.deletar(livroDeletar);
    }
    
}
