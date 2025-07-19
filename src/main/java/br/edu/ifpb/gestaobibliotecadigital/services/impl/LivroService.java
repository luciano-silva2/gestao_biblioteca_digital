package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroService {

    private static final Logger logger = Logger.getLogger(LivroService.class.getName());
    private static final Map<String, Integer> registroDeCategorias = new HashMap<>();
    private final LivroRepository livroRepository = LivroRepository.getInstance();

    public void criarLivro(Livro livro) {
        List<Livro> resultados = listarPorLivro(livro.getISBN());
        if (!resultados.isEmpty()) {
            logger.log(Level.INFO, "Livro já registrado no sistema");
            return;
        }
        logger.log(Level.INFO, "Criando livro: {0}", livro);
        livroRepository.adicionar(livro);
    }

    public List<Livro> listar() {
        logger.info("Listando todos os livros");
        return livroRepository.listar();
    }

    public List<Livro> listarPorLivro(String ISBN) {
        logger.log(Level.INFO, "Buscando livro por ISBN: {0}", ISBN);
        LivroFiltro filtro = new LivroFiltro(livroRepository.listar());
        List<Livro> resultados = filtro.porLivro(ISBN).filtrar();
        System.out.println(resultados);
        logger.log(Level.INFO, "Livros encontrados: {0}", resultados.size());
        return resultados;
    }

    public boolean atualizar(String ISBN, Livro novoLivro) {
        logger.log(Level.INFO, "Atualizando livro com ISBN: {0}", ISBN);
        List<Livro> resultados = listarPorLivro(ISBN);
        if (!resultados.isEmpty()) {
            livroRepository.atualizar(novoLivro);
            logger.log(Level.INFO, "Livro atualizado com sucesso: {0}", novoLivro);
            return true;
        }
        logger.log(Level.WARNING, "Livro nao encontrado para atualizar: {0}", ISBN);
        return false;
    }

    public boolean deletar(String ISBN) {
        logger.log(Level.INFO, "Deletando livro com ISBN: {0}", ISBN);
        List<Livro> resultados = listarPorLivro(ISBN);

        if (!resultados.isEmpty()) {
            livroRepository.excluir(resultados.get(0));
            logger.info("Livro deletado com sucesso");
            return true;
        }
        logger.log(Level.WARNING, "Livro nao encontrado para deletar: {0}", ISBN);
        return false;
    }

    // Salvar as categorias que os usuários estão buscando
    public void registrarBuscaPorCategoria(String categoria) {
        // Vai salvar todas as categorias, execeto o placeholder
        registroDeCategorias.put(categoria, registroDeCategorias.getOrDefault(categoria, 0) + 1);
    }

    // Retorna o top 10 de categorias
    public List<Map.Entry<String, Integer>> getCategoriasmaisbuscadas() {
        return registroDeCategorias.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10) // até 10
                .toList();
    }

}
