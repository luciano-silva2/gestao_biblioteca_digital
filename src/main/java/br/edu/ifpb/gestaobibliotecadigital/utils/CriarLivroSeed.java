package br.edu.ifpb.gestaobibliotecadigital.utils;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators.LivroComCapaAlternativa;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators.LivroComResumoEstendido;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators.LivroComTag;
import java.util.Arrays;

public class CriarLivroSeed {

    private static final List<Livro> bancoDeLivros = new ArrayList<>();

    static {
        Livro padraoDeProjeto = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8573076103")
                                        .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                                        .setAutor("Erich Gamma")
                                        .setAno(2000)
                                        .setEditora("Bookman")
                                        .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais frequentes na área de projeto.")
                                        .setCategoria("Tecnologia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51bO3rI8hEL._SY445_SX342_.jpg"
                        ),
                        "Este livro clássico apresenta 23 padrões de projeto essenciais para o desenvolvimento de software orientado a objetos, oferecendo soluções testadas e comprovadas para problemas comuns de design. É uma leitura fundamental para arquitetos e desenvolvedores de software."
                ),
                Arrays.asList("Design Patterns", "Orientação a Objetos", "Engenharia de Software", "GoF")
        );

        Livro useCabecaJava = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8550819884")
                                        .setTitulo("Use a Cabeça Java – 3ª Edição: Guia do Aprendiz Para Programação no Mundo Real")
                                        .setAutor("Kathy Sierra")
                                        .setAno(2024)
                                        .setEditora("Alta Books")
                                        .setSinopse("Experiência completa de aprendizado em Java e programação orientada a objetos.")
                                        .setCategoria("Tecnologia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/41sWiXSdGTL._SY445_SX342_.jpg"
                        ),
                        "Um guia completo e divertido para aprender Java e programação orientada a objetos, com uma abordagem visual e didática que facilita o entendimento de conceitos complexos."
                ),
                Arrays.asList("Java", "Programação", "Orientação a Objetos", "Aprendizado")
        );

        Livro entendendoAlgoritmos = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8575225639")
                                        .setTitulo("Entendendo Algoritmos")
                                        .setAutor("Aditya Y. Bhargava")
                                        .setAno(2017)
                                        .setEditora("Novatec")
                                        .setSinopse("Introdução prática aos algoritmos mais utilizados.")
                                        .setCategoria("Tecnologia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/517I6z9QK4L._SY445_SX342_.jpg"
                        ),
                        "Uma introdução prática e ilustrada aos algoritmos mais comuns, como busca, ordenação e grafos, explicando conceitos complexos de forma acessível para iniciantes."
                ),
                Arrays.asList("Algoritmos", "Estrutura de Dados", "Programação", "Computação")
        );

        Livro oHobbit = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595084742")
                                        .setTitulo("O Hobbit")
                                        .setAutor("J.R.R. Tolkien")
                                        .setAno(2019)
                                        .setEditora("HarperCollins")
                                        .setSinopse("Bilbo Bolseiro era um dos mais respeitáveis hobbits de todo o Condado até que, um dia, o mago Gandalf bate à sua porta. A partir de então, toda sua vida pacata e campestre soprando anéis de fumaça com seu belo cachimbo começa a mudar.")
                                        .setCategoria("Fantasia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/91M9xPIf10L._SY385_.jpg"
                        ),
                        "Esta jornada fará Bilbo, Gandalf e 13 anãos atravessarem a Terra-média, passando por inúmeros perigos, como os imensos trols, as Montanhas Nevoentas infestadas de gobelins ou a muito antiga e misteriosa Trevamata, até chegarem (se conseguirem) na Montanha Solitária. Lá está um incalculável tesouro, mas há um porém. Deitado em cima dele está Smaug, o Dourado, um dragão malicioso que... bem, você terá que ler para descobrir."
                ),
                Arrays.asList("Fantasia", "Épico", "Aventura", "Tolkien", "O Senhor dos Anéis", "Terra-média")
        );

        Livro senhorDosAneisParte1 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595084759")
                                        .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                                        .setAutor("J.R.R. Tolkien")
                                        .setAno(2019)
                                        .setEditora("HarperCollins")
                                        .setSinopse("Bilbo deixa o Condado para Frodo iniciar uma jornada pela Terra-média.")
                                        .setCategoria("Fantasia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/41RBd2DvmgL._SY445_SX342_.jpg"
                        ),
                        "O primeiro volume da épica trilogia de J.R.R. Tolkien, que narra o início da jornada de Frodo Bolseiro para destruir o Um Anel e salvar a Terra-média das forças de Sauron."
                ),
                Arrays.asList("Fantasia", "Épico", "Aventura", "Tolkien")
        );

        Livro senhorDosAneisParte2 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595084766")
                                        .setTitulo("O Senhor dos Anéis: As duas torres")
                                        .setAutor("J.R.R. Tolkien")
                                        .setAno(2019)
                                        .setEditora("HarperCollins")
                                        .setSinopse("A jornada continua com Legolas, Gimli e Aragorn tentando resgatar os hobbits.")
                                        .setCategoria("Fantasia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/81lQ5N0QwJL._SY385_.jpg"
                        ),
                        "A segunda parte da saga de O Senhor dos Anéis, onde a Sociedade se divide e os caminhos de seus membros se entrelaçam em meio à guerra iminente contra as forças das trevas."
                ),
                Arrays.asList("Fantasia", "Épico", "Guerra", "Terra-média")
        );

        Livro senhorDosAneisParte3 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595084773")
                                        .setTitulo("O Senhor dos Anéis: O retorno do rei")
                                        .setAutor("J.R.R. Tolkien")
                                        .setAno(2019)
                                        .setEditora("HarperCollins")
                                        .setSinopse("Sam e Frodo enfrentam o desafio final em Mordor.")
                                        .setCategoria("Fantasia")
                                        .build(),
                                "https://m.media-amazon.com/images/I/41KWSPU9wcL._SY445_SX342_.jpg"
                        ),
                        "O clímax da trilogia, onde o destino da Terra-média é selado na batalha final contra Sauron, enquanto Frodo e Sam enfrentam o desafio supremo em Mordor."
                ),
                Arrays.asList("Fantasia", "Épico", "Conclusão", "Jornada")
        );

        Livro diarioBanana1 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576831303")
                                        .setTitulo("Diário de um Banana 1")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2008)
                                        .setEditora("VR Editora")
                                        .setSinopse("Não é fácil ser criança. E ninguém sabe disso melhor do que Greg Heffley, que se vê mergulhado no mundo do ensino fundamental.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/71fWaI5myqL._SY385_.jpg"
                        ),
                        "O primeiro livro da popular série que acompanha as hilárias desventuras de Greg Heffley no ensino fundamental, contadas através de seu diário com textos e desenhos."
                ),
                Arrays.asList("Infantil", "Humor", "Diário", "Quadrinhos")
        );

        Livro diarioBanana2 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576831952")
                                        .setTitulo("Diário de um Banana 2: Rodrick é o cara")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2009)
                                        .setEditora("VR Editora")
                                        .setSinopse("Faça o que quiser, só não pergunte a Greg Heffley como foram suas férias de verão, porque ele realmente não quer falar sobre isso.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51opwNLjX+L._SY445_SX342_.jpg"
                        ),
                        "A segunda aventura de Greg Heffley, onde ele tenta manter um segredo embaraçoso de verão longe de todos, especialmente de seu irmão mais velho, Rodrick."
                ),
                Arrays.asList("Infantil", "Humor", "Família", "Segredos")
        );

        Livro diarioBanana3 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576832294")
                                        .setTitulo("Diário de um Banana 3: A gota d’água")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2010)
                                        .setEditora("VR Editora")
                                        .setSinopse("Greg não toma jeito mesmo. E a cada dia se envolve em mais confusão. O difícil é fazer seu pai engolir esse talento de Greg para se meter em situações embaraçosas.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51aNcPvjetL._SY445_SX342_.jpg"
                        ),
                        "Greg Heffley e seu pai enfrentam uma batalha de vontades, enquanto o pai de Greg tenta, sem sucesso, endireitar o filho e fazê-lo se interessar por atividades 'masculinas'."
                ),
                Arrays.asList("Infantil", "Humor", "Família", "Crescimento")
        );

        Livro diarioBanana4 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576832768")
                                        .setTitulo("Diário de um Banana. Dias de Cão - Volume 4")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2011)
                                        .setEditora("Vergara e Riba")
                                        .setSinopse("Férias de verão: o tempo está lindo, e toda garotada está se divertindo ao ar livre. Onde está Greg Heffley?")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/41XZpFdwsLL._SY445_SX342_.jpg"
                        ),
                        "As férias de verão de Greg Heffley se transformam em um desastre hilário, com planos frustrados e desventuras que o mantêm longe do sol e da diversão ao ar livre."
                ),
                Arrays.asList("Infantil", "Humor", "Férias", "Verão")
        );
        Livro diarioBanana5 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576832768")
                                        .setTitulo("Diário de um Banana 5: A verdade nua e crua")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2011)
                                        .setEditora("VR Editora")
                                        .setSinopse("Greg Heffley sem quis crescer logo. Mas será que ficar mais velho é tão legal assim? De repente, Greg começa a lidar com as pressões das festas de meninos e meninas.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51JxKoUmSBL._SY445_SX342_.jpg"
                        ),
                        "Greg Heffley enfrenta os desafios de crescer, incluindo as pressões sociais, festas e as inevitáveis e embaraçosas mudanças da adolescência."
                ),
                Arrays.asList("Infantil", "Adolescência", "Humor", "Crescer")
        );

        Livro diarioBanana6 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576833680")
                                        .setTitulo("Diário de um Banana 6: Casa dos horrores")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2011)
                                        .setEditora("VR Editora")
                                        .setSinopse("Em sua sexta aventura, Greg Heffley passará por grandes apuros. As coisas para ele vão de mal a pior, tanto na escola como em sua casa. Greg será suspeito de vandalismo e se tornará um suposto foragido da polícia.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/71beaUwsF0L._SY385_.jpg"
                        ),
                        "Uma nevasca prende Greg Heffley e sua família em casa, transformando o lar em um caos e levando Greg a ser suspeito de vandalismo."
                ),
                Arrays.asList("Infantil", "Humor", "Neve", "Aventura Doméstica")
        );

        Livro diarioBanana7 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8576834847")
                                        .setTitulo("Diário de um Banana 7: Segurando vela")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2013)
                                        .setEditora("VR Editora")
                                        .setSinopse("O Dia dos Namorados está chegando e Greg Heffley continua sozinho. Mas um baile organizado pela escola pode mudar tudo. Ele precisa encontrar uma garota urgente. Para isso, conta com a ajuda de outro solteirão, Rowley, seu melhor amigo.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/41bzTG7e+qL._SY445_SX342_.jpg"
                        ),
                        "Greg Heffley tenta encontrar um par para o baile de Dia dos Namorados, contando com a ajuda de seu melhor amigo, Rowley, em uma série de situações cômicas e embaraçosas."
                ),
                Arrays.asList("Infantil", "Romance", "Humor", "Amizade")
        );

        Livro diarioBanana8 = new LivroComTag(
                new LivroComCapaAlternativa(
                        new LivroSimples.Builder("978-8576836902")
                                .setTitulo("Diário de um Banana 8: Maré de azar")
                                .setAutor("Jeff Kinney")
                                .setAno(2014)
                                .setEditora("VR Editora")
                                .setSinopse("Greg Heffley está bolado. Seu companheiro de todas as horas, Rowley, o abandonou, e encontrar novos amigos na escola acabou se revelando uma tarefa muito difícil.")
                                .setCategoria("Infantil")
                                .build(),
                        "https://m.media-amazon.com/images/I/716yGyLTIxL._SY385_.jpg"
                ),
                Arrays.asList("Infantil", "Amizade", "Humor", "Desafios")
        );

        Livro diarioBanana9 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroSimples.Builder("978-8576838234")
                                .setTitulo("Diário de um Banana 9: Caindo na estrada")
                                .setAutor("Jeff Kinney")
                                .setAno(2015)
                                .setEditora("VR Editora")
                                .setSinopse("As férias do Greg tinham tudo para serem perfeitas, até que sua mãe vem com a bomba: eles farão uma viagem de carro em família. ")
                                .setCategoria("Infantil")
                                .build(),
                        "Greg Heffley embarca em uma hilária e desastrosa viagem de carro em família, repleta de imprevistos e situações cômicas que transformam as férias em uma grande aventura."
                ),
                Arrays.asList("Infantil", "Viagem", "Aventura", "Família")
        );

        Livro diarioBanana10 = new LivroComTag(
                new LivroSimples.Builder("978-8576839422")
                        .setTitulo("Diário de um Banana 10: Bons Tempos")
                        .setAutor("Jeff Kinney")
                        .setAno(2015)
                        .setEditora("VR Editora")
                        .setSinopse("Greg Heffley está prestes a descobrir que a vida era muito melhor nos velhos tempos. Com sua cidade voluntariamente 'desconectada', a vida moderna tem seus desafios.")
                        .setCategoria("Infantil")
                        .build(),
                Arrays.asList("Infantil", "Tecnologia", "Nostalgia", "Humor")
        );

        Livro diarioBanana11 = new LivroComTag(
                new LivroSimples.Builder("978-8550700601")
                        .setTitulo("Diário de um Banana 11: Vai ou Racha")
                        .setAutor("Jeff Kinney")
                        .setAno(2016)
                        .setEditora("VR Editora")
                        .setSinopse("A pressão só aumenta para Greg Heffley. A única coisa em que ele parece ser realmente bom é em videojogos, mas a mãe quer que ele alargue os seus horizontes e faça mais alguma coisa - QUALQUER coisa! Quando o Greg encontra uma velha câmara de filmar, ele tem a certeza de que descobriu a forma ideal de, finalmente, mostrar a todos os seus grandes talentos escondidos.")
                        .setCategoria("Infantil")
                        .build(),
                Arrays.asList("Infantil", "Tecnologia", "Nostalgia", "Humor")
        );

        Livro diarioBanana12 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8550701448")
                                        .setTitulo("Diário de um Banana 12: Apertem os cintos")
                                        .setAutor("Jeff Kinney")
                                        .setAno(2017)
                                        .setEditora("VR Editora")
                                        .setSinopse("Os Heffley estão dando o fora! Greg e sua família decidem fugir do frio e do estresse das festas de fim de ano e embarcam no primeiro avião com destino a uma ilha tropical. Mas, e se o paraíso não for tudo isso?")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51FEcJ30g+L._SY445_SX342_.jpg"
                        ),
                        "A família Heffley embarca em uma viagem de férias para uma ilha tropical, mas o que parecia um paraíso se transforma em uma série de desventuras cômicas."
                ),
                Arrays.asList("Infantil", "Viagem", "Férias", "Aventura")
        );

        // Júlio Verne
        Livro viagemCentroTerra = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595201736")
                                        .setTitulo("Viagem ao Centro da Terra")
                                        .setAutor("Júlio Verne")
                                        .setAno(2023)
                                        .setEditora("Pé da Letra")
                                        .setISBN("978-8595201736")
                                        .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51Qdy-JzXAL._SY445_SX342_.jpg"
                        ),
                        "Acompanhe a emocionante expedição do professor Otto Lidenbrock e seu sobrinho Axel em uma jornada subterrânea rumo ao centro do nosso planeta, descobrindo paisagens e criaturas pré-históricas."
                ),
                Arrays.asList("Aventura", "Ficção Científica", "Clássico", "Júlio Verne")
        );

        Livro ilhaMisteriosa = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8595201736")
                                        .setTitulo("A ilha misteriosa")
                                        .setAutor("Júlio Verne")
                                        .setAno(2021)
                                        .setEditora("Principis")
                                        .setSinopse("Depois de sequestrar um balão de um campo confederado, um grupo de cinco abolicionistas americanos cai das nuvens em uma ilha vulcânica desconhecida no oceano Pacífico.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51F4Fs+g5oL._SY445_SX342_.jpg"
                        ),
                        "Um grupo de náufragos da Guerra Civil Americana se vê isolado em uma ilha deserta, onde sua engenhosidade e trabalho em equipe são postos à prova em uma luta pela sobrevivência e descoberta de mistérios."
                ),
                Arrays.asList("Aventura", "Sobrevivência", "Clássico", "Júlio Verne")
        );
        // Art Spiegelman
        Livro maus = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8535906288")
                                        .setTitulo("Maus")
                                        .setAutor("Art Spiegelman")
                                        .setAno(2005)
                                        .setEditora("Quadrinhos na Cia")
                                        .setSinopse("Maus (\"rato\", em alemão) é a história de Vladek Spiegelman, judeu polonês que sobreviveu ao campo de concentração de Auschwitz, narrada por ele próprio ao filho Art.")
                                        .setCategoria("Aventura")
                                        .build(),
                                "https://m.media-amazon.com/images/I/51Ud+Rl1SaL._SY445_SX342_.jpg"
                        ),
                        "Uma poderosa e comovente graphic novel que narra a história real de sobrevivência de Vladek Spiegelman, um judeu polonês, durante o Holocausto, contada ao seu filho."
                ),
                Arrays.asList("Graphic Novel", "Holocausto", "História", "Memórias")
        );

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

        Livro spiderwick1 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroComCapaAlternativa(
                                new LivroSimples.Builder("978-8532517708")
                                        .setTitulo("As Crônicas de Spiderwick: O guia de campo")
                                        .setAutor("Holly Black")
                                        .setAno(2004)
                                        .setEditora("Rocco")
                                        .setSinopse("Fadas, duendes, gnomos e seres fantásticos, podem estar do seu lado agora mesmo, então fique alerta! Há muito mais nesse mundo do que os olhos podem ver. Para divulgar essa informação, os irmãos Grace pediram que Holly Black e Tony DiTerlizzi transformassem a sua história em uma série de cinco livros.")
                                        .setCategoria("Infantil")
                                        .build(),
                                "https://rocco.com.br/wp-content/uploads/2022/12/9788532517708.jpg"
                        ),
                        "O primeiro volume das Crônicas de Spiderwick, onde os irmãos Grace descobrem um mundo secreto de criaturas mágicas e perigosas, revelado por um misterioso guia de campo."
                ),
                Arrays.asList("Fantasia", "Infantil", "Aventura", "Mundo Mágico")
        );

        Livro spiderwick2 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroSimples.Builder("978-8532517715")
                                .setTitulo("As Crônicas de Spiderwick: Pedra da visão")
                                .setAutor("Holly Black")
                                .setAno(2004)
                                .setEditora("Rocco")
                                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                                .setCategoria("Infantil")
                                .build(),
                        "No segundo livro das Crônicas de Spiderwick, os irmãos Grace continuam sua luta contra as criaturas do mundo mágico, fazendo alianças inesperadas para proteger seu irmão e o guia de campo."
                ),
                Arrays.asList("Fantasia", "Infantil", "Criaturas Mágicas", "Mistério")
        );

        Livro spiderwick3 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroSimples.Builder("978-8532518798")
                                .setTitulo("As Crônicas de Spiderwick: Segredo de Lucinda")
                                .setAutor("Holly Black")
                                .setAno(2005)
                                .setEditora("Rocco")
                                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                                .setCategoria("Infantil")
                                .build(),
                        "O terceiro volume das Crônicas de Spiderwick revela mais segredos sobre o mundo das fadas e a família Grace, enquanto os irmãos buscam respostas e enfrentam novos perigos."
                ),
                Arrays.asList("Fantasia", "Infantil", "Segredos", "Magia")
        );

        Livro spiderwick4 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroSimples.Builder("978-8532518804")
                                .setTitulo("A árvore de ferro: 4")
                                .setAutor("Holly Black")
                                .setAno(2005)
                                .setEditora("Rocco")
                                .setSinopse("Jared está vendo dois Simon ao mesmo tempo; enquanto um remexe a bolsa de Mallory, o outro está sentado ao lado da mãe. Para piorar a situação, eles ainda têm pela frente a arriscada missão de resgatar a irmã das garras de Korting, Mulgarath e de todos os outros seres fantásticos que exigem o Guia de Campo como recompensa.")
                                .setCategoria("Infantil")
                                .build(),
                        "No quarto livro de Spiderwick, os irmãos Grace enfrentam um novo e perigoso desafio para resgatar sua irmã, lidando com ilusões e a ameaça crescente das forças do mal."
                ),
                Arrays.asList("Fantasia", "Infantil", "Ilusão", "Resgate")
        );

        Livro spiderwick5 = new LivroComTag(
                new LivroComResumoEstendido(
                        new LivroSimples.Builder("978-8532519993")
                                .setTitulo("A ira de Mulgarath: 5")
                                .setAutor("Holly Black")
                                .setAno(2006)
                                .setEditora("Rocco")
                                .setSinopse("Mulgarath roubou o livro mágico de Arthur Spiderwick e deseja tornar-se o mestre do mundo. Com a ajuda do gnomo Tibério, do desajeitado Gritalhão e outros seres encantados que povoam a história, conseguirão Jared, Simon e Mallory triunfar sobre as forças do mal e fazer com que o precioso guia de campo seja usado para o bem de todos?")
                                .setCategoria("Infantil")
                                .build(),
                        "O volume final das Crônicas de Spiderwick culmina na batalha decisiva contra o terrível Mulgarath, onde os irmãos Grace devem usar toda sua coragem para proteger o mundo mágico e o guia de campo."
                ),
                Arrays.asList("Fantasia", "Infantil", "Batalha Final", "Aventura")
        );

        // Adicionar no banco de dados
        bancoDeLivros.add(padraoDeProjeto);
        bancoDeLivros.add(useCabecaJava);
        bancoDeLivros.add(entendendoAlgoritmos);
        bancoDeLivros.add(oHobbit);
        bancoDeLivros.add(senhorDosAneisParte1);
        bancoDeLivros.add(senhorDosAneisParte2);
        bancoDeLivros.add(senhorDosAneisParte3);
        // Diário de um Banana
        bancoDeLivros.add(diarioBanana1);
        bancoDeLivros.add(diarioBanana2);
        bancoDeLivros.add(diarioBanana3);
        bancoDeLivros.add(diarioBanana4);
        bancoDeLivros.add(diarioBanana5);
        bancoDeLivros.add(diarioBanana6);
        bancoDeLivros.add(diarioBanana7);
        bancoDeLivros.add(diarioBanana8);
        bancoDeLivros.add(diarioBanana9);
        bancoDeLivros.add(diarioBanana10);
        bancoDeLivros.add(diarioBanana11);
        bancoDeLivros.add(diarioBanana12);
        // // Júlio Verne
        bancoDeLivros.add(viagemCentroTerra);
        bancoDeLivros.add(ilhaMisteriosa);
        // Outros
        bancoDeLivros.add(maus);
        bancoDeLivros.add(bichos);
        bancoDeLivros.add(vidasSecas);
        // Spiderwick
        bancoDeLivros.add(spiderwick1);
        bancoDeLivros.add(spiderwick2);
        bancoDeLivros.add(spiderwick3);
        bancoDeLivros.add(spiderwick4);
        bancoDeLivros.add(spiderwick5);
    }

    public static List<Livro> getLivros() {
        return new ArrayList<>(bancoDeLivros);
    }
}
