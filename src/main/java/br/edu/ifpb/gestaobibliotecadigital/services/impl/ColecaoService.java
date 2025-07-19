package br.edu.ifpb.gestaobibliotecadigital.services.impl;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.ItemBiblioteca;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ColecaoRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.interfaces.IColecaoService;
import java.util.List;

public class ColecaoService implements IColecaoService {

    private final ColecaoRepository colecaoRepository = ColecaoRepository.getInstance();

    @Override
    public Colecao criarColecao(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da coleção não pode ser vazio.");
        }
        colecaoRepository.findByNome(nome).ifPresent(c -> {
            throw new IllegalStateException("Já existe uma coleção com o nome: " + nome);
        });
        
        Colecao novaColecao = new Colecao(nome);
        colecaoRepository.adicionar(novaColecao);
        return novaColecao;
    }

    @Override
    public Colecao adicionarItemAColecao(Colecao colecao, ItemBiblioteca item) {
        if (colecao == null || item == null) {
            throw new IllegalArgumentException("Coleção e item não podem ser nulos.");
        }
        colecao.adicionar(item);
        colecaoRepository.atualizar(colecao);
        return colecao;
    }

    @Override
    public Colecao buscarPorNome(String nome) {
        return colecaoRepository.findByNome(nome).orElse(null);
    }

    @Override
    public List<Colecao> listarTodas() {
        return colecaoRepository.listar();
    }
    
    @Override
    public void removerColecao(String nome) {
        Colecao colecao = buscarPorNome(nome);
        if (colecao != null) {
            colecaoRepository.excluir(colecao);
        } else {
            throw new IllegalStateException("Coleção não encontrada para remoção.");
        }
    }
}