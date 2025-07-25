package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.filters.ColecaoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ColecaoRepository;
import br.edu.ifpb.gestaobibliotecadigital.repositories.LivroRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import br.edu.ifpb.gestaobibliotecadigital.utils.Paginacao;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;

public class CriarColecao extends javax.swing.JDialog {

    private final ColecaoService colecaoService = new ColecaoService();
    private final LivroRepository livroRepository = LivroRepository.getInstance();
    private final ColecaoRepository colecaoRepository = ColecaoRepository.getInstance();

    private List<Livro> listaLivros = livroRepository.listar();
    private List<Colecao> listaColecaos = colecaoRepository.listar();

    private Paginacao<Livro> paginacaoParaLivros;
    private Paginacao<Colecao> paginacaoParaColecao;

    private Livro livro;
    private Colecao colecao;

    public CriarColecao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        paginacaoParaLivros = new Paginacao<>(listaLivros, 20);
        paginacaoParaColecao = new Paginacao<>(listaColecaos, 20);

        tabelaLivros.setDados(paginacaoParaLivros.getPaginaAtual());
        tabelaColecao1.setDados(paginacaoParaColecao.getPaginaAtual());

        atualizarControlesDePaginacaoLivro();
        atualizarControlesDePaginacaoColecao();
        // Filtra a lista de livros quando digitar na caixa de pesquisa
        pesquisarLivroPanelColecao.events.onUpdate(() -> {
            String textoPesquisaLivros = pesquisarLivroPanelColecao.getText();
            LivroFiltro filtro = new LivroFiltro(listaLivros);
            if (!textoPesquisaLivros.trim().equals("")) {
                filtro.pesquisar(textoPesquisaLivros);
            }
            paginacaoParaLivros = new Paginacao<>(filtro.filtrar(), 20);
            tabelaLivros.setDados(paginacaoParaLivros.getPaginaAtual());
            atualizarControlesDePaginacaoLivro();
        });

        // Filtra a lista de coleção quando digitar na caixa de pesquisa
        pesquisarColecaoPanel.events.onUpdate(() -> {
            String textoPesquisaLivros = pesquisarColecaoPanel.getText();
            ColecaoFiltro filtro = new ColecaoFiltro(listaColecaos);
            if (!textoPesquisaLivros.trim().equals("")) {
                filtro.pesquisar(textoPesquisaLivros);
            }
            paginacaoParaColecao = new Paginacao<>(filtro.filtrar(), 20);
            tabelaColecao1.setDados(paginacaoParaColecao.getPaginaAtual());
            atualizarControlesDePaginacaoColecao();
        });
        aoAlterar();
    }

    public void aoDestacarColecao(Colecao colecao) {
        this.colecao = colecao;
        aoAlterar();
    }

    public void aoDestacarLivro(Livro livro) {
        this.livro = livro;
        aoAlterar();
    }

    private void aoAlterar() {
        ok.setEnabled(this.livro != null && this.colecao != null);
    }

    private void atualizarControlesDePaginacaoLivro() {
        qntLivros.setText(paginacaoParaLivros.getNumeroPaginaAtual() + " de " + paginacaoParaLivros.getTotalPaginas());
        proximaPaginaLivro.setEnabled(paginacaoParaLivros.temProxima());
        voltarPaginaLivro.setEnabled(paginacaoParaLivros.temAnterior());
    }

    private void atualizarControlesDePaginacaoColecao() {
        qntColecao.setText(paginacaoParaColecao.getNumeroPaginaAtual() + " de " + paginacaoParaColecao.getTotalPaginas());
        proximaPaginaColecao.setEnabled(paginacaoParaColecao.temProxima());
        voltarPaginaColecao.setEnabled(paginacaoParaColecao.temAnterior());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao();
        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros();
        pesquisarLivroPanelColecao = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();
        pesquisarColecaoPanel = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        salvarNomeColecao = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        qntLivros = new javax.swing.JLabel();
        proximaPaginaLivro = new javax.swing.JButton();
        voltarPaginaLivro = new javax.swing.JButton();
        voltarPaginaColecao = new javax.swing.JButton();
        proximaPaginaColecao = new javax.swing.JButton();
        qntColecao = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Coleção de Livros");
        setMinimumSize(new java.awt.Dimension(800, 720));
        setResizable(false);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Nova Coleção");

        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao(){
            @Override
            protected void onItemDestacado(Colecao item) {
                aoDestacarColecao(item);
            }
        };

        tabelaLivros = new br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros(){
            @Override
            protected void onItemDestacado(Livro item) {
                aoDestacarLivro(item);
            }
        };

        salvarNomeColecao.setText("Registar nome de coleção");
        salvarNomeColecao.setToolTipText("Cria uma nova coleção com o nome informado.");
        salvarNomeColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarNomeColecaoActionPerformed(evt);
            }
        });

        ok.setText("Salvar Livro na Coleção");
        ok.setToolTipText("Adiciona o livro selecionado à coleção escolhida.");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        qntLivros.setText("0 de 0");

        proximaPaginaLivro.setText("Próxima");
        proximaPaginaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaPaginaLivroActionPerformed(evt);
            }
        });

        voltarPaginaLivro.setText("Voltar");
        voltarPaginaLivro.setEnabled(false);
        voltarPaginaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarPaginaLivroActionPerformed(evt);
            }
        });

        voltarPaginaColecao.setText("Voltar");
        voltarPaginaColecao.setEnabled(false);
        voltarPaginaColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarPaginaColecaoActionPerformed(evt);
            }
        });

        proximaPaginaColecao.setText("Próxima");
        proximaPaginaColecao.setEnabled(false);
        proximaPaginaColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaPaginaColecaoActionPerformed(evt);
            }
        });

        qntColecao.setText("0 de 0");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabelaColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pesquisarColecaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesquisarLivroPanelColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvarNomeColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addGap(90, 90, 90)
                        .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltarPaginaColecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proximaPaginaColecao)
                        .addGap(104, 104, 104)
                        .addComponent(qntColecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(qntLivros)
                        .addGap(65, 65, 65)
                        .addComponent(voltarPaginaLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proximaPaginaLivro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pesquisarLivroPanelColecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarColecaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaLivros, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(tabelaColecao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qntLivros)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proximaPaginaLivro)
                        .addComponent(voltarPaginaLivro)
                        .addComponent(voltarPaginaColecao)
                        .addComponent(proximaPaginaColecao)
                        .addComponent(qntColecao)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarNomeColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed

        try {
            colecaoService.adicionarLivroAColecao(colecao, livro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_okActionPerformed

    private void salvarNomeColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarNomeColecaoActionPerformed
        String nome = JOptionPane.showInputDialog(this, "Nome da colção:");
        if (nome == null) {
            return;
        }
        if (nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome inválido ou cancelado.");
            return;
        }

        try {
            colecaoService.criarColecao(new Colecao(nome));
            JOptionPane.showMessageDialog(
                    this,
                    "Coleção salva com sucesso!",
                    "Coleção",
                    JOptionPane.INFORMATION_MESSAGE
            );

            tabelaLivros.setDados(listaLivros);
            tabelaColecao1.setDados(listaColecaos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_salvarNomeColecaoActionPerformed

    private void proximaPaginaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaPaginaLivroActionPerformed
        paginacaoParaLivros.proximaPagina();
        tabelaLivros.setDados(paginacaoParaLivros.getPaginaAtual());
        atualizarControlesDePaginacaoLivro();
    }//GEN-LAST:event_proximaPaginaLivroActionPerformed

    private void voltarPaginaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPaginaLivroActionPerformed
        paginacaoParaLivros.paginaAnterior();
        tabelaLivros.setDados(paginacaoParaLivros.getPaginaAtual());
        atualizarControlesDePaginacaoLivro();
    }//GEN-LAST:event_voltarPaginaLivroActionPerformed

    private void proximaPaginaColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaPaginaColecaoActionPerformed
        paginacaoParaLivros.proximaPagina();
        tabelaLivros.setDados(paginacaoParaLivros.getPaginaAtual());
        atualizarControlesDePaginacaoColecao();
    }//GEN-LAST:event_proximaPaginaColecaoActionPerformed

    private void voltarPaginaColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPaginaColecaoActionPerformed
        paginacaoParaColecao.proximaPagina();
        tabelaColecao1.setDados(paginacaoParaColecao.getPaginaAtual());
        atualizarControlesDePaginacaoColecao();
    }//GEN-LAST:event_voltarPaginaColecaoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CriarColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CriarColecao dialog = new CriarColecao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton ok;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarColecaoPanel;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarLivroPanelColecao;
    private javax.swing.JButton proximaPaginaColecao;
    private javax.swing.JButton proximaPaginaLivro;
    private javax.swing.JLabel qntColecao;
    private javax.swing.JLabel qntLivros;
    private javax.swing.JButton salvarNomeColecao;
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao tabelaColecao1;
    private br.edu.ifpb.gestaobibliotecadigital.views.livros.TabelaLivros tabelaLivros;
    private javax.swing.JLabel titulo;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    private javax.swing.JButton voltarPaginaColecao;
    private javax.swing.JButton voltarPaginaLivro;
    // End of variables declaration//GEN-END:variables
}
