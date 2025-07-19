package br.edu.ifpb.gestaobibliotecadigital.services.interfaces;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.ItemBiblioteca;
import java.util.List;

public interface IColecaoService {

    /**
     * Cria e persiste uma nova coleção.
     *
     * @param nome o nome da coleção.
     * @return A coleção que foi criada.
     */
    Colecao criarColecao(String nome);

    /**
     * Adiciona um item (Livro ou outra Colecao) a uma coleção existente.
     *
     * @param colecao A coleção onde o item será adicionado.
     * @param item O item a ser adicionado.
     * @return A coleção atualizada.
     */
    Colecao adicionarItemAColecao(Colecao colecao, ItemBiblioteca item);
    
    /**
     * Busca uma coleção pelo seu nome.
     * @param nome O nome da coleção a ser buscada.
     * @return A coleção encontrada ou null se não existir.
     */
    Colecao buscarPorNome(String nome);

    /**
     * Retorna uma lista com todas as coleções cadastradas.
     *
     * @return Uma lista de Colecoes.
     */
    List<Colecao> listarTodas();
    
    /**
     * Remove uma coleção pelo nome.
     * @param nome o nome da coleção a ser removida.
     */
    void removerColecao(String nome);
}