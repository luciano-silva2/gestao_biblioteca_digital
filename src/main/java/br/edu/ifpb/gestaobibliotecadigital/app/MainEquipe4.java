package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.AvaliacaoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;

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
        var livro = repo_livro.get(1);
        
        var repo_usuario = UsuarioRepository.getInstance().listar();
        var usuario1 = repo_usuario.get(0);
        var usuario2 = repo_usuario.get(1);
        
        //System.out.println(repo_empres.emprestimoLivro(repo_livro));
        
         AvaliacaoService avaliacaoService = new AvaliacaoService();

        // observador
        avaliacaoService.adicionarObserver(avaliacao -> {
            System.out.println("Nova avaliação registrada para o livro: " + avaliacao.getLivro().getTitulo());
            System.out.println("Nota: " + avaliacao.getNota());
            System.out.println("Comentário: " + avaliacao.getComentario());
        });

        
        Avaliacao avaliacao1 = new Avaliacao(livro, usuario1, 4, "bom", livro.getId());
        Avaliacao avaliacao2 = new Avaliacao(livro, usuario2, 5, "Excelente", livro.getId());
        avaliacaoService.adicionarAvaliacao(avaliacao1);
        avaliacaoService.adicionarAvaliacao(avaliacao2);
       
        
        var idLivro = livro.getId();
        
        //AvaliacaoRepository repo_avaliacoes = AvaliacaoRepository.getInstance();;
        //System.out.println(repo_avaliacoes.listar());
        
        double media = avaliacaoService.calcularMediaAvaliacoes(idLivro);
        System.out.println("Média de avaliações para o livro '" + livro.getTitulo() + "': " + media);
        
        
        // 
    }
}
