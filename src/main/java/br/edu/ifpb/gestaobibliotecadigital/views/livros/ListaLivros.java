package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.utils.Paginacao;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;

public class ListaLivros extends javax.swing.JFrame {
   
    private final LivroRepository livroRepository = LivroRepository.getInstance();
    private List<Livro> listaLivros = livroRepository.listar();
    private String pesquisa = "";
    private LivroFiltro filtro = new LivroFiltro();
    private Paginacao<Livro> paginacao;
    private final int TAMANHO_PAGINA = 12;

    public ListaLivros() {
        initComponents();

        proximoButton.setEnabled(false);
        voltarButton.setEnabled(false);

        paginacao = new Paginacao<>(listaLivros, TAMANHO_PAGINA);
        tabelaLivros.setDados(paginacao.getPaginaAtual());

        atualizarControlesDePaginacao();

        acoesLivro.events.onUpdate(() -> {
            listaLivros = livroRepository.listar();
            filtrar();
        });

        pesquisarLivrosPanel.events.onUpdate(() -> {
            pesquisa = pesquisarLivrosPanel.getText();
            filtrar();
        });

        pesquisaAvancadaLivros.events.onUpdate(() -> {
            filtro = pesquisaAvancadaLivros.getFiltro();
            filtrar();
        });

    }

    /**
     * Filtra a lista de livro com base na pesquisa e aplica paginação
     */
    private void filtrar() {
        LivroFiltro filtroClone = (LivroFiltro) filtro.clone();
        filtroClone.setItens(listaLivros);

        if (!pesquisa.trim().isEmpty()) {
            filtroClone.pesquisar(pesquisa);
        }

        // Aplica o filtro e obtém a lista filtrada
        List<Livro> filtrados = filtroClone.filtrar();

        // Cria nova paginação com os itens filtrados
        this.paginacao = new Paginacao<>(filtrados, TAMANHO_PAGINA);

        atualizarControlesDePaginacao();

        // Atualiza a tabela com os itens da página atual
        this.tabelaLivros.setDados(paginacao.getPaginaAtual());

        // Reseta item selecionado
        onItemDestacadoLivros(null);
    }

    /**
     * Ao destacar um item da tabela
     */
    private void onItemDestacadoLivros(Livro item) {
        sinopseLivro.setLivro(item == null ? null : item);
        detalhesAutor1.setLivro(item == null ? null : item);
        resumoEstendido.setLivro(item == null ? null : item);
        capaLivro1.setLivro(item == null ? null : item);
        acoesLivro.setLivro(item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisarLivrosPanel = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();
        titulo = new javax.swing.JLabel();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        pesquisaAvancadaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.PesquisaAvancadaLivros();
        sinopseLivro = new br.edu.ifpb.gestaobibliotecadigital.views.livros.SinopseLivro();
        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros();
        qntLabel = new javax.swing.JLabel();
        proximoButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        detalhesAutor1 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.DetalhesAutor();
        capaLivro1 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.CapaLivro();
        resumoEstendido = new br.edu.ifpb.gestaobibliotecadigital.views.livros.ResumoEstendido();
        acoesLivro = new br.edu.ifpb.gestaobibliotecadigital.views.livros.AcoesLivro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Livros");
        setMinimumSize(new java.awt.Dimension(844, 585));
        setResizable(false);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Listagem de Livros");

        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros(){
            @Override
            protected void onItemDestacado(br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro item) {
                onItemDestacadoLivros(item);
            };
        };

        qntLabel.setText("0 de 0");

        proximoButton.setText("Proximo");
        proximoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarLivrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pesquisaAvancadaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(capaLivro1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sinopseLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                    .addComponent(acoesLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(resumoEstendido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(qntLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addGap(108, 108, 108)
                                        .addComponent(voltarButton)
                                        .addGap(31, 31, 31)
                                        .addComponent(proximoButton))))
                            .addComponent(detalhesAutor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo)
                    .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesquisarLivrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detalhesAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capaLivro1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(tabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qntLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(voltarButton)
                                .addComponent(proximoButton))
                            .addComponent(acoesLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sinopseLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resumoEstendido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pesquisaAvancadaLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoButtonActionPerformed
        paginacao.proximaPagina();
        tabelaLivros.setDados(paginacao.getPaginaAtual());
        atualizarControlesDePaginacao();
    }//GEN-LAST:event_proximoButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        paginacao.paginaAnterior();
        tabelaLivros.setDados(paginacao.getPaginaAtual());
        atualizarControlesDePaginacao();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void atualizarControlesDePaginacao() {
        qntLabel.setText(paginacao.getNumeroPaginaAtual() + " de " + paginacao.getTotalPaginas());
        proximoButton.setEnabled(paginacao.temProxima());
        voltarButton.setEnabled(paginacao.temAnterior());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListaLivros().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.AcoesLivro acoesLivro;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.CapaLivro capaLivro1;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.DetalhesAutor detalhesAutor1;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.PesquisaAvancadaLivros pesquisaAvancadaLivros;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarLivrosPanel;
    private javax.swing.JButton proximoButton;
    private javax.swing.JLabel qntLabel;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.ResumoEstendido resumoEstendido;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.SinopseLivro sinopseLivro;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros tabelaLivros;
    private javax.swing.JLabel titulo;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
