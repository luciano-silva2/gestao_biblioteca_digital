package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.ItemBiblioteca;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.IColecaoService;
import java.util.List;
import javax.swing.JOptionPane;

public class ColecaoController extends Controller {

    private final IColecaoService colecaoService = new ColecaoService();

    /**
     * Método que a View chama para criar uma nova coleção.
     * @param nome O nome da coleção a ser criada.
     */
    public void criarNovaColecao(String nome) {
        try {
            verificaUsuarioLogado();
            verificaAdministrador();
            colecaoService.criarColecao(nome);
            JOptionPane.showMessageDialog(null, "Coleção '" + nome + "' criada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar coleção: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que a View chama para adicionar um item a uma coleção.
     * @param nomeColecao O nome da coleção alvo.
     * @param item O item (livro ou outra coleção) a ser adicionado.
     */
    public void adicionarItem(String nomeColecao, ItemBiblioteca item) {
        try {
            verificaUsuarioLogado();
            verificaAdministrador();
            Colecao colecao = colecaoService.buscarPorNome(nomeColecao);
            if (colecao != null) {
                colecaoService.adicionarItemAColecao(colecao, item);
                JOptionPane.showMessageDialog(null, "Item '" + item.getTitulo() + "' adicionado à coleção '" + nomeColecao + "'.");
            } else {
                throw new IllegalStateException("Coleção não encontrada: " + nomeColecao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar item: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retorna todas as coleções para serem exibidas na View.
     * @return Lista de todas as coleções.
     */
    public List<Colecao> getTodasAsColecoes() {
        return colecaoService.listarTodas();
    }
    
    /**
     * Remove uma coleção.
     * @param nome O nome da coleção a ser removida.
     */
    public void removerColecao(String nome) {
         try {
            verificaUsuarioLogado();
            verificaAdministrador();
            colecaoService.removerColecao(nome);
            JOptionPane.showMessageDialog(null, "Coleção removida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover coleção: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}