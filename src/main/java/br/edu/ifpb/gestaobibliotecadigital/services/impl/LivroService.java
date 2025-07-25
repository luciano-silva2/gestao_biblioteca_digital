package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class LivroService {

    private static final Logger logger = Logger.getLogger(LivroService.class.getName());
    private static final Map<String, Integer> registroDeCategorias = new HashMap<>();
    private final LivroRepository livroRepository = LivroRepository.getInstance();

    public List<Livro> listarPorLivro(String ISBN) {
        logger.log(Level.INFO, "Buscando livro por ISBN: {0}", ISBN);
        LivroFiltro filtro = new LivroFiltro(livroRepository.listar());
        List<Livro> resultados = filtro.porLivro(ISBN).filtrar();
        return resultados;
    }

    public List<Livro> listar() {
        logger.info("Listando todos os livros");
        return livroRepository.listar();
    }

    public void criarLivro(Livro livro) {
        List<Livro> resultados = listarPorLivro(livro.getISBN());
        if (!resultados.isEmpty()) {
            throw new IllegalStateException("Este ISBN já está cadastrado no sistema.");
        }
        logger.log(Level.INFO, "Criando livro: {0}", livro);
        livroRepository.adicionar(livro);
    }

    public void atualizar(Livro novoAtualizar) {
        livroRepository.atualizar(novoAtualizar);
        logger.log(Level.INFO, "Livro atualizado com sucesso: {0}", novoAtualizar);
    }

    public void deletar(Livro novoDeletar) {
        logger.log(Level.INFO, "Deletando livro: {0}", novoDeletar.getTitulo());
        livroRepository.excluir(novoDeletar);
        logger.info("Livro deletado com sucesso");
    }
    
    public int livrosRegistrados(){
        return livroRepository.listar().size();
    }

    // Salvar as categorias que os usuários estão buscando
    public void registrarBuscaPorCategoria(String categoria) {
        registroDeCategorias.put(categoria, registroDeCategorias.getOrDefault(categoria, 0) + 1);
    }

    // Retorna o top 5 de categorias
    public List<Map.Entry<String, Integer>> getCategoriasmaisbuscadas() {
        return registroDeCategorias.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .toList();
    }

}
