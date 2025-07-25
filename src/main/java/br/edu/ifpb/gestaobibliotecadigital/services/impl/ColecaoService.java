package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ColecaoRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import java.util.ArrayList;

public class ColecaoService {

    private final ColecaoRepository colecaoRepository = ColecaoRepository.getInstance();
    private static final Logger logger = Logger.getLogger(ColecaoService.class.getName());

    public List<Colecao> listarColecoes() {
        return colecaoRepository.listar();
    }

    public void criarColecao(Colecao colecao) {
        logger.log(Level.INFO, "Criando coleção: {0}", colecao.getNome());
        colecaoRepository.adicionar(colecao);
    }

    // Conveter os livros dentro de uma coleção
    public List<Livro> listarLivrosDeColecao(Colecao colecao) {
        return colecao == null ? new ArrayList<>()
                : colecao.getItens().stream()
                        .filter(Livro.class::isInstance)
                        .map(Livro.class::cast)
                        .toList();
    }

    public void adicionarLivroAColecao(Colecao colecao, Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo.");
        }

        LivroFiltro livroFiltro = new LivroFiltro(listarLivrosDeColecao(colecao));
        List<Livro> resultados = livroFiltro.porLivro(livro.getISBN()).filtrar();

        if (!resultados.isEmpty()) {
            throw new IllegalStateException("Este livro já está cadastrado nessa coleção.");
        }

        colecao.adicionar(livro);
        logger.log(Level.INFO, "Adicionado à coleção: {0}", livro.getTitulo());
        colecaoRepository.atualizar(colecao);
    }

    public void remover(Colecao colecao) {
        colecaoRepository.excluir(colecao);
    }

    public void removerDaColecao(Colecao colecao, Livro livro) {
        colecao.remover(livro);
        colecaoRepository.atualizar(colecao);
    }

}
