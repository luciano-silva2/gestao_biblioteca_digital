package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPadrao;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.LeitorComum;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.LeitorPremium;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.HistoricoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ReservaRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.UsuarioRepository;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import java.util.UUID;

public class Seed {

    private static final EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();
    private static final ReservaRepository reservaRepository = ReservaRepository.getInstance();
    private static final LivroRepository livroRepository = LivroRepository.getInstance();
    private static final HistoricoRepository historicoRepository = HistoricoRepository.getInstance();
    private static final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public static void main(String[] args) {
        executarSeed();
    }

    public static void executarSeed() {
        System.out.println("[SEED] Limpando dados antigos...");
        usuarioRepository.resetar();
        livroRepository.resetar();
        emprestimoRepository.resetar();
        historicoRepository.resetar();
        reservaRepository.resetar();

        System.out.println("[SEED] Criando livros...");

        Livro padroeDeProjeto = new LivroSimples.Builder("978-8573076103")
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais frequentes na área de projeto.")
                .setCategoria("Tecnologia")
                .build();

        Livro useCabecaJava = new LivroSimples.Builder("978-8550819884")
                .setTitulo("Use a Cabeça Java – 3ª Edição: Guia do Aprendiz Para Programação no Mundo Real")
                .setAutor("Kathy Sierra")
                .setAno(2024)
                .setEditora("Alta Books")
                .setSinopse("Experiência completa de aprendizado em Java e programação orientada a objetos.")
                .setCategoria("Tecnologia")
                .build();

        Livro entendendoAlgoritmos = new LivroSimples.Builder("978-8575225639")
                .setTitulo("Entendendo Algoritmos")
                .setAutor("Kathy Sierra")
                .setAno(2017)
                .setEditora("Novatec")
                .setSinopse("Introdução prática aos algoritmos mais utilizados.")
                .setCategoria("Tecnologia")
                .build();

        Livro senhorDosAneisParte1 = new LivroSimples.Builder("978-8595084759")
                .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setSinopse("Bilbo deixa o Condado para Frodo iniciar uma jornada pela Terra-média.")
                .setCategoria("Fantasia")
                .build();

        Livro senhorDosAneisParte2 = new LivroSimples.Builder("978-8595084766")
                .setTitulo("O Senhor dos Anéis: As duas torres")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setSinopse("A jornada continua com Legolas, Gimli e Aragorn tentando resgatar os hobbits.")
                .setCategoria("Fantasia")
                .build();

        Livro senhorDosAneisParte3 = new LivroSimples.Builder("978-8595084773")
                .setTitulo("O Senhor dos Anéis: O retorno do rei")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setSinopse("Sam e Frodo enfrentam o desafio final em Mordor.")
                .setCategoria("Fantasia")
                .build();
//        Novros livros
        Livro diarioBanana1 = new LivroSimples.Builder("978-8576831303")
                .setTitulo("Diário de um Banana 1")
                .setAutor("Jeff Kinney")
                .setAno(2008)
                .setEditora("VR Editora")
                .setSinopse("Não é fácil ser criança. E ninguém sabe disso melhor do que Greg Heffley, que se vê mergulhado no mundo do ensino fundamental.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana2 = new LivroSimples.Builder("978-8576831952")
                .setTitulo("Diário de um Banana 2: Rodrick é o cara")
                .setAutor("Jeff Kinney")
                .setAno(2009)
                .setEditora("VR Editora")
                .setSinopse("Faça o que quiser, só não pergunte a Greg Heffley como foram suas férias de verão, porque ele realmente não quer falar sobre isso.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana3 = new LivroSimples.Builder("978-8576832294")
                .setTitulo("Diário de um Banana 3: A gota d’água")
                .setAutor("Jeff Kinney")
                .setAno(2010)
                .setEditora("VR Editora")
                .setSinopse("Greg não toma jeito mesmo. E a cada dia se envolve em mais confusão. O difícil é fazer seu pai engolir esse talento de Greg para se meter em situações embaraçosas.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana4 = new LivroSimples.Builder("978-8576832768")
                .setTitulo("Diário de um Banana. Dias de Cão - Volume 4")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("Vergara e Riba")
                .setSinopse("Férias de verão: o tempo está lindo, e toda garotada está se divertindo ao ar livre. Onde está Greg Heffley?")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana5 = new LivroSimples.Builder("978-8576832768")
                .setTitulo("Diário de um Banana 5: A verdade nua e crua")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("VR Editora")
                .setSinopse("Greg Heffley sem quis crescer logo. Mas será que ficar mais velho é tão legal assim? De repente, Greg começa a lidar com as pressões das festas de meninos e meninas.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana6 = new LivroSimples.Builder("978-8576833680")
                .setTitulo("Diário de um Banana 6: Casa dos horrores")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("VR Editora")
                .setSinopse("Em sua sexta aventura, Greg Heffley passará por grandes apuros. As coisas para ele vão de mal a pior, tanto na escola como em sua casa. Greg será suspeito de vandalismo e se tornará um suposto foragido da polícia.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana7 = new LivroSimples.Builder("978-8576834847")
                .setTitulo("Diário de um Banana 7: Segurando vela")
                .setAutor("Jeff Kinney")
                .setAno(2013)
                .setEditora("VR Editora")
                .setSinopse("O Dia dos Namorados está chegando e Greg Heffley continua sozinho. Mas um baile organizado pela escola pode mudar tudo. Ele precisa encontrar uma garota urgente. Para isso, conta com a ajuda de outro solteirão, Rowley, seu melhor amigo.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana8 = new LivroSimples.Builder("978-8576836902")
                .setTitulo("Diário de um Banana 8: Maré de azar")
                .setAutor("Jeff Kinney")
                .setAno(2014)
                .setEditora("VR Editora")
                .setSinopse("Greg Heffley está bolado. Seu companheiro de todas as horas, Rowley, o abandonou, e encontrar novos amigos na escola acabou se revelando uma tarefa muito difícil.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana9 = new LivroSimples.Builder("978-8576838234")
                .setTitulo("Diário de um Banana 9: Caindo na estrada")
                .setAutor("Jeff Kinney")
                .setAno(2015)
                .setEditora("VR Editora")
                .setSinopse("As férias do Greg tinham tudo para serem perfeitas, até que sua mãe vem com a bomba: eles farão uma viagem de carro em família. ")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana10 = new LivroSimples.Builder("978-8576839422")
                .setTitulo("Diário de um Banana 10: Bons Tempos")
                .setAutor("Jeff Kinney")
                .setAno(2015)
                .setEditora("VR Editora")
                .setSinopse("Greg Heffley está prestes a descobrir que a vida era muito melhor nos velhos tempos. Com sua cidade voluntariamente 'desconectada', a vida moderna tem seus desafios.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana11 = new LivroSimples.Builder("978-8550700601")
                .setTitulo("Diário de um Banana 11: Vai ou Racha")
                .setAutor("Jeff Kinney")
                .setAno(2016)
                .setEditora("VR Editora")
                .setSinopse("A pressão só aumenta para Greg Heffley. A única coisa em que ele parece ser realmente bom é em videojogos, mas a mãe quer que ele alargue os seus horizontes e faça mais alguma coisa - QUALQUER coisa! Quando o Greg encontra uma velha câmara de filmar, ele tem a certeza de que descobriu a forma ideal de, finalmente, mostrar a todos os seus grandes talentos escondidos.")
                .setCategoria("Infantil")
                .build();

        Livro diarioBanana12 = new LivroSimples.Builder("978-8550701448")
                .setTitulo("Diário de um Banana 12: Apertem os cintos")
                .setAutor("Jeff Kinney")
                .setAno(2017)
                .setEditora("VR Editora")
                .setSinopse("Os Heffley estão dando o fora! Greg e sua família decidem fugir do frio e do estresse das festas de fim de ano e embarcam no primeiro avião com destino a uma ilha tropical. Mas, e se o paraíso não for tudo isso?")
                .setCategoria("Infantil")
                .build();

        // Júlio Verne
        Livro viagemCentroTerra = new LivroSimples.Builder("978-8595201736")
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
                .setCategoria("Infantil")
                .build();

        Livro ilhaMisteriosa = new LivroSimples.Builder("978-8595201736")
                .setTitulo("A ilha misteriosa")
                .setAutor("Júlio Verne")
                .setAno(2021)
                .setEditora("Principis")
                .setSinopse("Depois de sequestrar um balão de um campo confederado, um grupo de cinco abolicionistas americanos cai das nuvens em uma ilha vulcânica desconhecida no oceano Pacífico.")
                .setCategoria("Infantil")
                .build();

        // Art Spiegelman
        Livro maus = new LivroSimples.Builder("978-8535906288")
                .setTitulo("Maus")
                .setAutor("Art Spiegelman")
                .setAno(2005)
                .setEditora("Quadrinhos na Cia")
                .setSinopse("Maus (\"rato\", em alemão) é a história de Vladek Spiegelman, judeu polonês que sobreviveu ao campo de concentração de Auschwitz, narrada por ele próprio ao filho Art.")
                .setCategoria("Aventura")
                .build();

        Livro bichos = new LivroSimples.Builder("978-8535909555")
                .setTitulo("A revolução dos bichos: Um conto de fadas")
                .setAutor("George Orwell")
                .setAno(2007)
                .setEditora("Companhia das Letras")
                .setSinopse("Narra a insurreição dos animais de uma granja contra seus donos. Progressivamente, porém, a revolução degenera numa tirania ainda mais opressiva que a dos humanos.")
                .setCategoria("Clássicos de Ficção")
                .build();

        Livro vidasSecas = new LivroSimples.Builder("978-6554700276")
                .setTitulo("Vidas Secas")
                .setAutor("Graciliano Ramos")
                .setAno(2024)
                .setEditora("Editora Itatiaia")
                .setSinopse("\"Vidas Secas\" é um retrato magistral das condições humanas diante das adversidades, explorando temas universais como a busca por um lar, a esperança em meio à desolação e a resistência humana perante a natureza implacável.")
                .setCategoria("Clássicos de Ficção")
                .build();
        // Holly Black
        Livro spiderwick1 = new LivroSimples.Builder("978-8532517708")
                .setTitulo("O guia de campo: 1")
                .setAutor("Holly Black")
                .setAno(2004)
                .setEditora("Rocco")
                .setSinopse("Fadas, duendes, gnomos e seres fantásticos, podem estar do seu lado agora mesmo, então fique alerta! Há muito mais nesse mundo do que os olhos podem ver. Para divulgar essa informação, os irmãos Grace pediram que Holly Black e Tony DiTerlizzi transformassem a sua história em uma série de cinco livros.")
                .setCategoria("Infantil")
                .build();

        Livro spiderwick2 = new LivroSimples.Builder("978-8532517715")
                .setTitulo("Pedra da visão: 2")
                .setAutor("Holly Black")
                .setAno(2004)
                .setEditora("Rocco")
                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                .setCategoria("Infantil")
                .build();

        Livro spiderwick3 = new LivroSimples.Builder("978-8532518798")
                .setTitulo("Segredo de Lucinda: 3")
                .setAutor("Holly Black")
                .setAno(2005)
                .setEditora("Rocco")
                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                .setCategoria("Infantil")
                .build();

        Livro spiderwick4 = new LivroSimples.Builder("978-8532518804")
                .setTitulo("A árvore de ferro: 4")
                .setAutor("Holly Black")
                .setAno(2005)
                .setEditora("Rocco")
                .setSinopse("Jared está vendo dois Simon ao mesmo tempo; enquanto um remexe a bolsa de Mallory, o outro está sentado ao lado da mãe. Para piorar a situação, eles ainda têm pela frente a arriscada missão de resgatar a irmã das garras de Korting, Mulgarath e de todos os outros seres fantásticos que exigem o Guia de Campo como recompensa.")
                .setCategoria("Infantil")
                .build();

        Livro spiderwick5 = new LivroSimples.Builder("978-8532519993")
                .setTitulo("A ira de Mulgarath: 5")
                .setAutor("Holly Black")
                .setAno(2006)
                .setEditora("Rocco")
                .setSinopse("Mulgarath roubou o livro mágico de Arthur Spiderwick e deseja tornar-se o mestre do mundo. Com a ajuda do gnomo Tibério, do desajeitado Gritalhão e outros seres encantados que povoam a história, conseguirão Jared, Simon e Mallory triunfar sobre as forças do mal e fazer com que o precioso guia de campo seja usado para o bem de todos?")
                .setCategoria("Infantil")
                .build();

        // Adicionar no banco de dados
        livroRepository.adicionar(padroeDeProjeto);
        livroRepository.adicionar(useCabecaJava);
        livroRepository.adicionar(entendendoAlgoritmos);
        livroRepository.adicionar(senhorDosAneisParte1);
        livroRepository.adicionar(senhorDosAneisParte2);
        livroRepository.adicionar(senhorDosAneisParte3);
        // Diário de um Banana
        livroRepository.adicionar(diarioBanana1);
        livroRepository.adicionar(diarioBanana2);
        livroRepository.adicionar(diarioBanana3);
        livroRepository.adicionar(diarioBanana4);
        livroRepository.adicionar(diarioBanana5);
        livroRepository.adicionar(diarioBanana6);
        livroRepository.adicionar(diarioBanana7);
        livroRepository.adicionar(diarioBanana8);
        livroRepository.adicionar(diarioBanana9);
        livroRepository.adicionar(diarioBanana10);
        livroRepository.adicionar(diarioBanana11);
        livroRepository.adicionar(diarioBanana12);
        // // Júlio Verne
        livroRepository.adicionar(viagemCentroTerra);
        livroRepository.adicionar(ilhaMisteriosa);
        // Outros
        livroRepository.adicionar(maus);
        livroRepository.adicionar(bichos);
        livroRepository.adicionar(vidasSecas);
        // Spiderwick
        livroRepository.adicionar(spiderwick1);
        livroRepository.adicionar(spiderwick2);
        livroRepository.adicionar(spiderwick3);
        livroRepository.adicionar(spiderwick4);
        livroRepository.adicionar(spiderwick5);

        ////////////////////////////////////////////////////////////////////////
        // TODO: adicionar coleções
        System.out.println("[SEED] Criando coleções de livros...");

        ////////////////////////////////////////////////////////////////////////
        System.out.println("[SEED] Criando usuários...");

        Administrador adminCarlos = new Administrador("Carlos Silva", UUID.randomUUID().toString());
        Administrador adminFernanda = new Administrador("Fernanda Souza", UUID.randomUUID().toString());

        LeitorComum leitorJoao = new LeitorComum("João Pereira", UUID.randomUUID().toString());
        LeitorComum leitorMariana = new LeitorComum("Mariana Lima", UUID.randomUUID().toString());
        LeitorComum leitorLucas = new LeitorComum("Lucas Oliveira", UUID.randomUUID().toString());
        LeitorComum leitorBianca = new LeitorComum("Bianca Martins", UUID.randomUUID().toString());
        LeitorComum leitorFelipe = new LeitorComum("Felipe Andrade", UUID.randomUUID().toString());

        LeitorPremium leitorAna = new LeitorPremium("Ana Costa", UUID.randomUUID().toString());
        LeitorPremium leitorRafael = new LeitorPremium("Rafael Mendes", UUID.randomUUID().toString());
        LeitorPremium leitorJuliana = new LeitorPremium("Juliana Rocha", UUID.randomUUID().toString());

        usuarioRepository.adicionar(adminCarlos);
        usuarioRepository.adicionar(adminFernanda);

        usuarioRepository.adicionar(leitorJoao);
        usuarioRepository.adicionar(leitorMariana);
        usuarioRepository.adicionar(leitorLucas);
        usuarioRepository.adicionar(leitorBianca);
        usuarioRepository.adicionar(leitorFelipe);

        usuarioRepository.adicionar(leitorAna);
        usuarioRepository.adicionar(leitorRafael);
        usuarioRepository.adicionar(leitorJuliana);
        ////////////////////////////////////////////////////////////////////////
        System.out.println("[SEED] Criando empréstimos...");

        DataProvider.setDateTime("2025-01-01T00:00:00");
        var emp1 = new Emprestimo(leitorAna, useCabecaJava, new EmprestimoPadrao());
        DataProvider.setDateTime("2025-01-03T00:00:00");
        var emp2 = new Emprestimo(leitorJoao, padroeDeProjeto, new EmprestimoPremium());
        DataProvider.setDateTime("2025-01-04T00:00:00");
        var emp3 = new Emprestimo(leitorJoao, senhorDosAneisParte3, new EmprestimoPadrao());
        DataProvider.setDateTime("2025-01-10T00:00:00");
        var emp4 = new Emprestimo(leitorAna, senhorDosAneisParte2, new EmprestimoPadrao());
        DataProvider.setDateTime("2025-02-03T00:00:00");
        var emp5 = new Emprestimo(leitorAna, entendendoAlgoritmos, new EmprestimoPremium());

        DataProvider.setDateTime("2025-01-20T00:00:00");
        emp4.setDataDevolvido(DataProvider.agora());

        DataProvider.setDateTime("2025-01-07T00:00:00");
        emp1.setDataDevolvido(DataProvider.agora());

        emp3.setDataDevolvido(DataProvider.agora());
        emp3.setDataPagamentoMulta(DataProvider.agora());

        DataProvider.setDateTime("2025-01-27T00:00:00");
        emp4.setDataDevolvido(DataProvider.agora());

        emprestimoRepository.adicionar(emp1);
        emprestimoRepository.adicionar(emp2);
        emprestimoRepository.adicionar(emp3);
        emprestimoRepository.adicionar(emp4);
        emprestimoRepository.adicionar(emp5);

        ////////////////////////////////////////////////////////////////////////
        System.out.println("[SEED] Criando reservas...");
        DataProvider.setDateTime("2025-01-02T00:00:00");
        var res1 = new Reserva(leitorJuliana, padroeDeProjeto);
        DataProvider.setDateTime("2025-01-03T00:00:00");
        var res2 = new Reserva(leitorBianca, entendendoAlgoritmos);
        DataProvider.setDateTime("2025-01-04T00:00:00");
        var res3 = new Reserva(leitorBianca, diarioBanana7);
        DataProvider.setDateTime("2025-07-16T00:00:00");
        var res4 = new Reserva(leitorMariana, useCabecaJava);

        reservaRepository.adicionar(res1);
        reservaRepository.adicionar(res2);
        reservaRepository.adicionar(res3);
        reservaRepository.adicionar(res4);

        ////////////////////////////////////////////////////////////////////////
        DataProvider.resetClock();

        System.out.println("[SEED] Concluído");
    }
}
