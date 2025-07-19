package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.LivroService;
import br.edu.ifpb.gestaobibliotecadigital.utils.Paginacao;
import java.util.List;

public class ListaLivros extends javax.swing.JFrame {

    private final LivroService livroService = new LivroService();
    private List<Livro> listaLivros = livroService.listar();
    private String pesquisa = "";
    private LivroFiltro filtro = new LivroFiltro();
    private Paginacao<Livro> paginacao;

    public ListaLivros() {
        initComponents();

        proximoButton.setEnabled(false);
        voltarButton.setEnabled(false);

        paginacao = new Paginacao<>(listaLivros, 5);
        tabelaLivros.setDados(paginacao.getPaginaAtual());

        atualizarControlesDePaginacao();

        acoesLivro1.events.onUpdate(() -> {
            listaLivros = livroService.listar();
            filtrar();
        });

        pesquisarPanel1.events.onUpdate(() -> {
            pesquisa = pesquisarPanel1.getText();
            filtrar();
        });

        pesquisaAvancadaLivros1.events.onUpdate(() -> {
            filtro = pesquisaAvancadaLivros1.getFiltro();
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
        this.paginacao = new Paginacao<>(filtrados, 5);

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
        sinopseLivro2.setLivro(item == null ? null : item);
        detalhesAutor1.setLivro(item == null ? null : item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisarPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();
        titulo = new javax.swing.JLabel();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        pesquisaAvancadaLivros1 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.PesquisaAvancadaLivros();
        sinopseLivro2 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.SinopseLivro();
        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros();
        acoesLivro1 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.AcoesLivro();
        qntLabel = new javax.swing.JLabel();
        proximoButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        detalhesAutor1 = new br.edu.ifpb.gestaobibliotecadigital.views.livros.DetalhesAutor();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Livros");
        setMinimumSize(new java.awt.Dimension(844, 585));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Listagem de Livros");

        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros(){
            @Override
            protected void onItemDestacado(Livro item) {
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
                    .addComponent(pesquisarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pesquisaAvancadaLivros1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sinopseLivro2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(acoesLivro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(qntLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(voltarButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(proximoButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detalhesAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tabelaLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo)
                    .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(pesquisarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(acoesLivro1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(qntLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(proximoButton)
                                .addComponent(voltarButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sinopseLivro2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(detalhesAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(pesquisaAvancadaLivros1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.AcoesLivro acoesLivro1;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.DetalhesAutor detalhesAutor1;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.PesquisaAvancadaLivros pesquisaAvancadaLivros1;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarPanel1;
    private javax.swing.JButton proximoButton;
    private javax.swing.JLabel qntLabel;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.SinopseLivro sinopseLivro2;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros tabelaLivros;
    private javax.swing.JLabel titulo;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
