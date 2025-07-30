package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.controllers.LivroController;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.recommendations.CriterioMaisAvaliados;
import br.edu.ifpb.gestaobibliotecadigital.recommendations.CriterioMaisLidos;
import br.edu.ifpb.gestaobibliotecadigital.recommendations.CriterioRecomendacao;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;
import br.edu.ifpb.gestaobibliotecadigital.views.GerenciarLivros;
import br.edu.ifpb.gestaobibliotecadigital.views.avaliacoes.Criar_AvaliacoesLivro;
import br.edu.ifpb.gestaobibliotecadigital.views.avaliacoes.LivroRecomendacao;

public class MainEquipe4 {

    public static void main(String[] args) {
        
        EmprestimoRepository repo_empres = EmprestimoRepository.getInstance();
        
        var repo_livro = LivroRepository.getInstance().listar();
        //var livro = repo_livro.get(1);
        //var idLivro = livro.getId();
        
        var repo_usuario = UsuarioRepository.getInstance().listar();
        var usuario1 = repo_usuario.get(0);
        var usuario2 = repo_usuario.get(1);
        
        //System.out.println(repo_empres.emprestimoLivro(repo_livro));
        
         AvaliacaoService avaliacaoService = new AvaliacaoService();
       
        
        
        for (Livro livro : repo_livro){
            double media = avaliacaoService.calcularMediaAvaliacoes(livro.getId());
            System.out.println("Média de avaliações para o livro '" + livro.getTitulo() + "': " + media);

            CriterioRecomendacao criterioAvaliados  = new CriterioMaisAvaliados(avaliacaoService);
            String recomendacao_nota = criterioAvaliados.recomendar(livro);
            System.out.println(recomendacao_nota);


            CriterioRecomendacao criterioMaisLidos = new CriterioMaisLidos(repo_empres);
            criterioMaisLidos.setProximo(criterioAvaliados);

            String recomendacao_maisLidos = criterioMaisLidos.recomendar(livro);
            System.out.println(recomendacao_maisLidos);
        }
        
        //new LivroRecomendacao().setVisible(true);
        //new Criar_AvaliacoesLivro().setVisible(true);
        
        // Integrado a Equipe 2 - Kayo e Marcelo
        new GerenciarLivros().setVisible(true);

             
        LivroController livroController = new LivroController();

        // Testar o método buscarLivroPorISBN - Simulando API
        String isbn = "978-3-16-148410-0"; // Exemplo de ISBN
        Livro livro = livroController.buscarLivroPorISBN(isbn);
        
        System.out.println("\n \n");

        if (livro != null) {
            System.out.println("Livro encontrado:");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Categoria: " + livro.getCategoria());
        } else {
            System.out.println("Livro não encontrado para o ISBN: " + isbn);
        }
    }
}
