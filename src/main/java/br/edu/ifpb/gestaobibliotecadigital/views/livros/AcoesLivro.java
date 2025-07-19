package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.views.components.UpdateObserver;
import javax.swing.JOptionPane;

public class AcoesLivro extends javax.swing.JPanel {

    private Livro livro;
    public final UpdateObserver events = new UpdateObserver();

    public AcoesLivro() {
        initComponents();
    }

    /**
     * Atualiza o livro selecionado
     */
    public void setLivro() {
        remover.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar");

        remover.setText("Remover");
        remover.setEnabled(false);
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(adicionar)
                .addComponent(remover)
                .addComponent(atualizar))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        events.emit();
    }//GEN-LAST:event_atualizarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed

        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja remover?",
                "Remove?",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            events.emit();
        }
    }//GEN-LAST:event_removerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables
}
