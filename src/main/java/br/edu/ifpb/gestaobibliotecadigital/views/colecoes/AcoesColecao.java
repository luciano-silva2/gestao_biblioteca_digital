package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.controllers.ColecaoController;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import br.edu.ifpb.gestaobibliotecadigital.views.components.UpdateObserver;
import javax.swing.JOptionPane;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.session.PermissaoProxy;

public class AcoesColecao extends javax.swing.JPanel {

    public final UpdateObserver events = new UpdateObserver();
    private final ColecaoService colecaoService = new ColecaoService();
    private final ColecaoController colecaoController = new ColecaoController();

    private Colecao colecao;
    private Livro livro;

    public AcoesColecao() {
        initComponents();
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
        atualizarEstadoBotoes();
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
        atualizarEstadoBotoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        comentar = new javax.swing.JButton();
        removerColecao = new javax.swing.JButton();

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar Livro");
        adicionar.setVisible(PermissaoProxy.podeAdicionarLivro());
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        remover.setText("Remover Livro");
        remover.setEnabled(false);
        remover.setVisible(PermissaoProxy.podeExcluirLivro());
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        comentar.setText("Comentar");
        comentar.setVisible(!PermissaoProxy.podeAdicionarLivro());

        removerColecao.setText("Remover Coleção");
        removerColecao.setVisible(PermissaoProxy.podeExcluirLivro());
        removerColecao.setEnabled(false);
        removerColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerColecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removerColecao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comentar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(remover)
                    .addComponent(atualizar)
                    .addComponent(comentar)
                    .addComponent(removerColecao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        events.emit();
    }//GEN-LAST:event_atualizarActionPerformed


    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        try {
            colecaoService.removerLivroDaColecao(colecao, livro);
            events.emit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_removerActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        CriarColecao criarReservaDialog = new CriarColecao(null, true);
        criarReservaDialog.setVisible(true);
        events.emit();
    }//GEN-LAST:event_adicionarActionPerformed

    private void atualizarEstadoBotoes() {
        remover.setEnabled(colecao != null && livro != null);
        removerColecao.setEnabled(colecao != null);
    }


    private void removerColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerColecaoActionPerformed
        try {
            colecaoController.removerColecao(colecao);
            events.emit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_removerColecaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton comentar;
    private javax.swing.JButton remover;
    private javax.swing.JButton removerColecao;
    // End of variables declaration//GEN-END:variables
}
