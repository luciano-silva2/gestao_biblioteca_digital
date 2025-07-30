package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.filters.ColecaoFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import java.util.List;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.ColecaoRepository;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import java.util.ArrayList;

public class ListaColecao extends javax.swing.JFrame {

    private final ColecaoRepository colecaoRepository = ColecaoRepository.getInstance();
    private final ColecaoService service = new ColecaoService();
    private List<Colecao> listarColecoes = colecaoRepository.listar();
    private Colecao colecao;
    private Livro livro;

    public ListaColecao() {
        initComponents();

        tabelaColecao1.setDados(listarColecoes);
        acoesColecao.events.onUpdate(() -> {
            listarColecoes = colecaoRepository.listar();
            tabelaColecao1.setDados(listarColecoes);

            // Limpa seleção
            this.colecao = null;
            this.livro = null;

            tabelaSelecionadaColecao1.setDados(service.obterLivrosDaColecao(null));

            // Limpa ações
            acoesColecao.setColecao(null);
            acoesColecao.setLivro(null);
        });

        pesquisarPanel1.events.onUpdate(() -> {
            String textoPesquisaColecao = pesquisarPanel1.getText();
            ColecaoFiltro filtro = new ColecaoFiltro(listarColecoes);

            if (!textoPesquisaColecao.trim().equals("")) {
                filtro.pesquisar(textoPesquisaColecao);
            }

            tabelaColecao1.setDados(filtro.filtrar());

            // Limpa tudo ao pesquisar
            this.colecao = null;
            this.livro = null;

            tabelaSelecionadaColecao1.setDados(service.obterLivrosDaColecao(null));

            acoesColecao.setColecao(null);
            acoesColecao.setLivro(null);
        });

    }

    /**
     * Ao destacar um item da tabela
     */
    private void onItemDestacadoColcoes(Colecao item) {
        this.colecao = item;
        tabelaSelecionadaColecao1.setDados(service.obterLivrosDaColecao(item));
        acoesColecao.setColecao(colecao);
    }

    private void onItemDestacadoLivros(Livro livroItem) {
        this.livro = livroItem;
        acoesColecao.setLivro(livro);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao();
        tabelaSelecionadaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao();
        acoesColecao = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.AcoesColecao();
        pesquisarPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Coleção");
        setMinimumSize(new java.awt.Dimension(844, 585));
        setResizable(false);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Lista de Coleção");

        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao(){
            @Override
            protected void onItemDestacado(Colecao item) {
                onItemDestacadoColcoes(item);
            }
        };

        tabelaSelecionadaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao(){
            @Override
            protected void onItemDestacado(Livro item) {
                onItemDestacadoLivros(item);
            }
        };

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(acoesColecao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(330, 330, 330))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pesquisarPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(tabelaColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabelaSelecionadaColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(pesquisarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabelaSelecionadaColecao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabelaColecao1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acoesColecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListaColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaColecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListaColecao().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.AcoesColecao acoesColecao;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarPanel1;
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao tabelaColecao1;
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao tabelaSelecionadaColecao1;
    private javax.swing.JLabel titulo;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    // End of variables declaration//GEN-END:variables
}
