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
import br.edu.ifpb.gestaobibliotecadigital.views.avaliacoes.Criar_AvaliacoesLivro;
import br.edu.ifpb.gestaobibliotecadigital.views.avaliacoes.LivroRecomendacao;

public class MainEquipe4 {

    public static void main(String[] args) {
        /*
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro padroeDeProjeto = new LivroBuilder()
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setISBN("978-8573076103")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais freqüentes na área de projeto, assinado por quatro profissionais com grande experiência em software orientado a objetos. Um best-seller mundial.")
                .setCategoria("Engenharia de Software")
                .builder();
        LivroRepository repo_livro = LivroRepository.getInstance();
        System.out.println(repo_livro.listar() + "\n" + "\n");
        
        Avaliacao jose_comentario  = new Avaliacao(padroeDeProjeto, usuario, 3, "lastimavél");
        System.out.println(jose_comentario);
        
        AvaliacaoRepository repo = AvaliacaoRepository.getInstance();
        repo.adicionar(jose_comentario);
        System.out.println(repo.listar());
*/
        EmprestimoRepository repo_empres = EmprestimoRepository.getInstance();
        
        var repo_livro = LivroRepository.getInstance().listar();
        //var livro = repo_livro.get(1);
        //var idLivro = livro.getId();
        
        var repo_usuario = UsuarioRepository.getInstance().listar();
        var usuario1 = repo_usuario.get(0);
        var usuario2 = repo_usuario.get(1);
        
        //System.out.println(repo_empres.emprestimoLivro(repo_livro));
        
         AvaliacaoService avaliacaoService = new AvaliacaoService();

        /*
        Avaliacao avaliacao1 = new Avaliacao(livro, usuario1, 4, "bom", livro.getId());
        Avaliacao avaliacao2 = new Avaliacao(livro, usuario2, 5, "Excelente", livro.getId());
        avaliacaoService.adicionarAvaliacao(avaliacao1);
        avaliacaoService.adicionarAvaliacao(avaliacao2);
       */
        
        
        //AvaliacaoRepository repo_avaliacoes = AvaliacaoRepository.getInstance();;
        //System.out.println(repo_avaliacoes.listar());
        
        
        
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
        
        //new RecomendacaoLivro().setVisible(true);
        new LivroRecomendacao().setVisible(true);
        new Criar_AvaliacoesLivro().setVisible(true);
        // 
        
        LivroController livroController = new LivroController();

        // Testar o método buscarLivroPorISBN
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
