package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.controllers.LivroController;
import br.edu.ifpb.gestaobibliotecadigital.views.components.UpdateObserver;
import javax.swing.JOptionPane;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.session.PermissaoProxy;
import br.edu.ifpb.gestaobibliotecadigital.session.UserSessionManager;

public class AcoesLivro extends javax.swing.JPanel {

    private Livro livro;
    private Usuario usuarioLogado = UserSessionManager.getInstance().getUsuarioLogado();

    private final LivroController livroController = new LivroController();
    public final UpdateObserver events = new UpdateObserver();

    public AcoesLivro() {
        initComponents();
    }

    /**
     * Atualiza o livro selecionado
     *
     * @param livro
     */
    public void setLivro(Livro livro) {
        this.livro = livro;

        comentar.setEnabled(livro != null);
        remover.setEnabled(livro != null);
        editar.setEnabled(livro != null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        comentar = new javax.swing.JButton();

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar");
        adicionar.setVisible(PermissaoProxy.podeAdicionarLivro());
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        remover.setText("Remover");
        remover.setEnabled(false);
        remover.setVisible(PermissaoProxy.podeExcluirLivro());
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.setVisible(PermissaoProxy.podeEditarLivro());
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        comentar.setText("Comentar");
        comentar.setVisible(!PermissaoProxy.podeAdicionarLivro());
        comentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarActionPerformed(evt);
            }
        });
        comentar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remover)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(remover)
                    .addComponent(atualizar)
                    .addComponent(editar)
                    .addComponent(comentar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        events.emit();
    }//GEN-LAST:event_atualizarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que vai remover esta reserva?",
                "Remover reserva",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                livroController.deletar(livro);
                events.emit();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Erro ao excluir reserva",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_removerActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        CriarLivros criarLivrosDialog = new CriarLivros(null, true);
        criarLivrosDialog.setVisible(true);
        events.emit();
    }//GEN-LAST:event_adicionarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        CriarLivros editarDialog = new CriarLivros(null, true, livro);
        editarDialog.setVisible(true);
    }//GEN-LAST:event_editarActionPerformed

    private void comentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarActionPerformed
        // TODO add your handling code here:
        System.out.println(usuarioLogado.getNome());
        ///
    }//GEN-LAST:event_comentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton comentar;
    private javax.swing.JButton editar;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables
}
