package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;

public class ColecaoController extends Controller {

    private final ColecaoService service = new ColecaoService();

    public void criar(Colecao colecao) {
        verificaUsuarioLogado();
        verificaAdministrador();
        service.criarColecao(colecao);
    }

    public void removerColecao(Colecao colecao) {
        verificaUsuarioLogado();
        verificaAdministrador();
        service.remover(colecao);
    }
    
    public void removerLivroDaColecao(Colecao colecao, Livro livro){
        verificaUsuarioLogado();
        verificaAdministrador();
        service.removerDaColecao(colecao, livro);
    }
    
}
