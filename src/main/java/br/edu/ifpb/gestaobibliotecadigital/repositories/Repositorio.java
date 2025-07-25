package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.utils.Serializador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe genérica de repositório para persistência via serialização. Pode ser
 * estendida por qualquer entidade que tenha um identificador único em forma de
 * String.
 *
 * @param <T> Tipo da entidade armazenada
 */
public abstract class Repositorio<T> implements Serializable {

    protected final String dbPath;
    protected ArrayList<T> itens;

    /**
     * Construtor que define o caminho do arquivo e carrega os dados.
     *
     * @param dbPath Caminho do arquivo de persistência
     */
    protected Repositorio(String dbPath) {
        this.dbPath = dbPath;
        carregar();
    }

    /**
     * Método abstrato que retorna o ID único de um item. Usado para comparar
     * itens na hora de atualizar.
     *
     * @param item Item a ser identificado
     * @return ID como String
     */
    protected abstract String getId(T item);

    /**
     * Lista todos os itens armazenados.
     *
     * @return Lista de itens
     */
    public ArrayList<T> listar() {
        return itens;
    }

    /**
     * Adiciona um novo item ao repositório.
     *
     * @param item Item a ser adicionado
     */
    public void adicionar(T item) {
        itens.add(item);
        salvar();
    }

    /**
     * Atualiza um item com base em seu ID.
     *
     * @param item Novo objeto a substituir o antigo
     */
    public void atualizar(T item) {
        for (int i = 0; i < itens.size(); i++) {
            if (getId(itens.get(i)).equals(getId(item))) {
                itens.set(i, item);
                break;
            }
        }
        salvar();
    }

    /**
     * Remove um item da lista.
     *
     * @param item Item a ser removido
     */
    public void excluir(T item) {
        itens.remove(item);
        salvar();
    }

    /**
     * Limpa a lista de itens e remove o arquivo de persistência.
     */
    public void resetar() {
        this.itens.clear();
        excluir();
    }

    /**
     * Carrega os itens do arquivo. Se não existir, cria lista vazia.
     */
    private void carregar() {
        try {
            itens = (ArrayList<T>) Serializador.ler(dbPath);
        } catch (FileNotFoundException ex) {
            System.out.println("Aviso: Repositório não existe: " + getNome());
            itens = new ArrayList<>();
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println("Ocorreu um erro ao carregar repositório: " + getNome());
            ex.printStackTrace();
            itens = new ArrayList<>();
        }
    }

    /**
     * Salva a lista atual no arquivo.
     */
    private void salvar() {
        try {
            Serializador.escrever(dbPath, itens);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar repositório: " + getNome());
            e.printStackTrace();
        }
    }

    /**
     * Exclui o arquivo de persistência do disco.
     */
    private void excluir() {
        try {
            Serializador.excluir(dbPath);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao excluir repositório: " + getNome());
            e.printStackTrace();
        }
    }

    protected abstract String getNome();
}
