package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.filters.EmprestimoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPadrao;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias.EmprestimoPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.LeitorComum;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.LeitorPremium;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.observers.NotificacaoObserver;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ReservaRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;
import br.edu.ifpb.gestaobibliotecadigital.utils.DataProvider;
import br.edu.ifpb.gestaobibliotecadigital.views.Testes;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

// ATENÇÃO: Este arquivo Main pertence a Equipe 3 (Jefferson e Marcos),
// e não deve ser alterado por outras equipes
// Este arquivo é temporário, só serve para realizar testes
public class MainEquipe3 {

    public static void main(String[] args) {
        setup();
        Main.setupSwingLook();

        new Testes().setVisible(true);

//        testarEmprestimos();
//        testarReservas();
//        testarRepositorio();
//        testarFiltros();
//        testarService();
//        testarNotificacao();
    }

    private static void testarEmprestimos() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro livro = new LivroSimples.Builder("978-8576832768")
                .setTitulo("Diário de um Banana 5: A verdade nua e crua")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("VR Editora")
                .setSinopse("Greg Heffley sem quis crescer logo. Mas será que ficar mais velho é tão legal assim? De repente, Greg começa a lidar com as pressões das festas de meninos e meninas.")
                .setCategoria("Infantil")
                .build();

        // Pegou emprestado em 01/07/2025 11:53:00
        // Devolver até: 08/07/2025
        DataProvider.setDateTime("2025-07-01T11:53:00");
        Emprestimo emprestimo = new Emprestimo(usuario, livro, new EmprestimoPadrao());
        System.out.println(emprestimo);

        // Se o cara devolveu em 08/07/2025 10:00:00
        // Sem multa, sem atraso, ficou 7 dias
        emprestimo.setDataDevolvido(LocalDateTime.parse("2025-07-08T12:00:00"));
        System.out.println(emprestimo);

        // Se o cara devolveu em 09/07/2025 10:00:00
        // Atrasou 1 dia, multa 1 real
        emprestimo.setDataDevolvido(LocalDateTime.parse("2025-07-09T10:00:00"));
        System.out.println(emprestimo);

        // Pagou a multa
        emprestimo.setDataPagamentoMulta(LocalDateTime.parse("2025-07-10T11:53:00"));
        System.out.println(emprestimo);

        // Outro empréstimo, dessa vez premium
        // Data: 01/01/2025 17:01
        // Devolver (ou renovar) até: 15/01/2025
        DataProvider.setDateTime("2025-01-01T17:01:00");
        Emprestimo emprestimo2 = new Emprestimo(usuario, livro, new EmprestimoPremium());
        System.out.println(emprestimo2);

        // Renovou dia 14
        DataProvider.setDateTime("2025-01-14T10:15:30");
        emprestimo2.renovar();
        emprestimo2.renovar();
        emprestimo2.renovar();
        emprestimo2.renovar();
        System.out.println(emprestimo2);

        // Renovou dia 29 (não pode, só pode até dia 28)
        // DataProvider.setDateTime("2025-01-29T10:15:30");
        // emprestimo2.renovar();
        // System.out.println(emprestimo2);
        // Renovou dia 28 (agora aparece "Devolver" ao invés de "Renovar"
        DataProvider.setDateTime("2025-01-28T10:15:30");
        emprestimo2.renovar();
        System.out.println(emprestimo2);

        // Só pode renovar 5 vezes
        // emprestimo2.renovar();
        DataProvider.resetClock();
        System.out.println(emprestimo2);
    }

    private static void testarReservas() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro livro = new LivroSimples.Builder("978-8595084759")
                .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setSinopse("Bilbo deixa o Condado para Frodo iniciar uma jornada pela Terra-média.")
                .setCategoria("Fantasia")
                .build();
        DataProvider.setDateTime("2025-01-01T10:15:30");
        Reserva reserva = new Reserva(usuario, livro);
        System.out.println(reserva);
        DataProvider.setDateTime("2025-01-30T10:15:30");
        System.out.println(reserva);
        DataProvider.setDateTime("2025-01-31T10:15:30");
        System.out.println(reserva);
        reserva.cancelar();
        DataProvider.resetClock();
        System.out.println(reserva);
    }

    private static void testarRepositorio() {
        EmprestimoRepository repo = EmprestimoRepository.getInstance();
        System.out.println(repo.listar());

        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro viagemCentroTerra = new LivroSimples.Builder("978-8595201736")
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
                .setCategoria("Infantil")
                .build();

        Emprestimo emprestimo = new Emprestimo(usuario, viagemCentroTerra, new EmprestimoPadrao());
        repo.adicionar(emprestimo);

        System.out.println(repo.listar());
    }

    private static void testarFiltros() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro viagemCentroTerra = new LivroSimples.Builder("978-8595201736")
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
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

        Emprestimo emprestimo1 = new Emprestimo(usuario, viagemCentroTerra, new EmprestimoPadrao());
        Emprestimo emprestimo2 = new Emprestimo(usuario, diarioBanana11, new EmprestimoPadrao());

        EmprestimoRepository repo = EmprestimoRepository.getInstance();
        System.out.println(repo.listar());

        repo.adicionar(emprestimo1);
        repo.adicionar(emprestimo2);

        emprestimo2.setDataDevolvido(DataProvider.agora());

        System.out.println(new EmprestimoFiltro(repo.listar())
                .porLivro(diarioBanana11)
                .devolvido()
                .filtrar()
        );
    }

    private static void testarService() {
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro viagemCentroTerra = new LivroSimples.Builder("978-8595201736")
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
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
        EmprestimoRepository erepo = EmprestimoRepository.getInstance();
        ReservaRepository rrepo = ReservaRepository.getInstance();
        erepo.resetar();
        rrepo.resetar();

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(viagemCentroTerra)); // true

        Emprestimo emprestimo1 = new Emprestimo(usuario, viagemCentroTerra, new EmprestimoPadrao());
        erepo.adicionar(emprestimo1);

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(viagemCentroTerra)); // false

        emprestimo1.setDataDevolvido(LocalDateTime.now());

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(viagemCentroTerra)); // true

        Reserva reserva = new Reserva(usuario, viagemCentroTerra);
        rrepo.adicionar(reserva);

        System.out.println(new EmprestimoService().livroDisponivelParaEmprestimo(viagemCentroTerra)); // false

    }

    private static void testarNotificacao() {
        Usuario jose = new LeitorComum("José", "00000000000000000000000000");
        Usuario ana = new LeitorPremium("Ana", "00000000000000000000000001");
        Livro viagemCentroTerra = new LivroSimples.Builder("978-8595201736")
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
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
        NotificacaoObserver notif = NotificacaoObserver.getInstance();
        notif.inscrever(jose, notificacao -> {
            System.out.println("[José] Notificação: " + notificacao.getMensagem());
        });
        notif.inscrever(ana, notificacao -> {
            System.out.println("[Ana] Notificação: " + notificacao.getMensagem());
        });

        DataProvider.setDateTime("2025-01-01T00:00:00");
        EmprestimoService servico = new EmprestimoService();
        Emprestimo emprestimo1 = servico.solicitarEmprestimo(jose, viagemCentroTerra);
        System.out.println(emprestimo1);

        DataProvider.setDateTime("2025-01-03T00:00:00");
        servico.reservarLivro(ana, viagemCentroTerra);

//        servico.renovarEmprestimo(emprestimo1); // recusa
        servico.devolverLivro(emprestimo1); // notifica ana
    }

    private static void setup() {
        // Configura o terminal para mostrar acentos corretamente na saída
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
