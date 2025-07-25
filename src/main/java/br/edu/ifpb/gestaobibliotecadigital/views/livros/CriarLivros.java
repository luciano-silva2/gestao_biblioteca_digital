package br.edu.ifpb.gestaobibliotecadigital.views.livros;

import br.edu.ifpb.gestaobibliotecadigital.controllers.LivroController;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators.LivroComCapaAlternativa;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators.LivroComResumoEstendido;
import br.edu.ifpb.gestaobibliotecadigital.utils.Helpers;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroSimples;

public class CriarLivros extends javax.swing.JDialog {

    private final LivroController livroService = new LivroController();

    public CriarLivros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        editar.setEnabled(false);
    }

    public CriarLivros(java.awt.Frame parent, boolean modal, Livro livro) {
        super(parent, modal);
        initComponents();
        ok.setEnabled(false);

        nomeLivro.setText(livro.getTitulo());
        nomeAutor.setText(livro.getAutor());
        nomeEditora.setText(livro.getEditora());
        inputISBN.setText(livro.getISBN());
        inputISBN.setEditable(false);
        sinopseLivro.setText(livro.getSinopse());

        if (livro instanceof LivroComResumoEstendido liroComResumo) {
            resumoLivro.setText(liroComResumo.getResumoEstendido());
        }

        if (livro instanceof LivroComCapaAlternativa decoradoCapa) {
            capaAlternativa.setText(decoradoCapa.getUrlCapa());
        }

        anoPublicacaoComboBox.setSelectedItem(String.valueOf(livro.getAno()));
        categoriaComboBox.setSelectedItem(livro.getCategoria());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinopseLivro = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        resumoLivro = new javax.swing.JTextArea();
        resumoLivroLabel = new javax.swing.JLabel();
        sinopseLabel = new javax.swing.JLabel();
        nomeLivro = new javax.swing.JTextField();
        nomeAutor = new javax.swing.JTextField();
        nomeEditora = new javax.swing.JTextField();
        anoPublicacaoComboBox = new javax.swing.JComboBox<>();
        categoriaComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editoraLabel = new javax.swing.JLabel();
        nomeLivroLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputISBN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tags = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        capaAlternativa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Livro");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(795, 709));
        setResizable(false);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Novo Livro");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        ok.setText("Salvar");
        ok.setEnabled(false);
        ok.setEnabled(true);
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        sinopseLivro.setColumns(20);
        sinopseLivro.setRows(5);
        sinopseLivro.setLineWrap(true);
        sinopseLivro.setWrapStyleWord(true);
        jScrollPane1.setViewportView(sinopseLivro);

        resumoLivro.setColumns(20);
        resumoLivro.setRows(5);
        resumoLivro.setLineWrap(true);
        resumoLivro.setWrapStyleWord(true);
        jScrollPane2.setViewportView(resumoLivro);

        resumoLivroLabel.setText("Resumo do Livro");

        sinopseLabel.setText("Sinopse do Livro");

        anoPublicacaoComboBox.setModel(new DefaultComboBoxModel<>(Helpers.getAnos(false)));

        categoriaComboBox.setModel(new DefaultComboBoxModel<>(Helpers.getCategorias(false)));

        jLabel1.setText("Categoria");

        jLabel2.setText("Ano de publicação");

        editoraLabel.setText("Editora");

        nomeLivroLabel.setText("Título do Livro");

        jLabel4.setText("Nome do Auor");

        jLabel3.setText("ISBN");

        jLabel5.setText("Tags");

        jLabel6.setText("Capa do Livro");

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(capaAlternativa)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeLivro)
                                    .addComponent(inputISBN)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(nomeLivroLabel)
                                            .addComponent(editoraLabel)
                                            .addComponent(sinopseLabel)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                                        .addGap(1, 1, 1))
                                    .addComponent(nomeEditora))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(resumoLivroLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(nomeAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(categoriaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(anoPublicacaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(tags, javax.swing.GroupLayout.Alignment.TRAILING))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tags, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLivroLabel)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(editoraLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(anoPublicacaoComboBox)
                    .addComponent(nomeEditora, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(capaAlternativa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sinopseLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resumoLivroLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(ok)
                    .addComponent(editar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private Livro formData() {
        String tituloLivro = nomeLivro.getText();
        String autor = nomeAutor.getText();
        String editora = nomeEditora.getText();
        String isbn = inputISBN.getText();
        String categoria = categoriaComboBox.getSelectedItem().toString();
        String anoSelecionado = anoPublicacaoComboBox.getSelectedItem().toString();
        String sinopse = sinopseLivro.getText();
        String resumo = resumoLivro.getText();
        String urlCapa = capaAlternativa.getText();

        Livro livro = new LivroSimples.Builder(isbn)
                .setTitulo(tituloLivro)
                .setAutor(autor)
                .setAno(Integer.parseInt(anoSelecionado))
                .setEditora(editora)
                .setCategoria(categoria)
                .setSinopse(sinopse)
                .build();

        if (!resumo.isBlank()) {
            livro = new LivroComResumoEstendido(livro, resumo);
        }

        if (!urlCapa.isBlank()) {
            livro = new LivroComCapaAlternativa(livro, urlCapa);
        }

        return livro;
    }

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        try {
            Livro livro = formData();
            livroService.criar(livro);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao salvar livro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_okActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            Livro livroAtulizar = formData();
            livroService.atualizar(livroAtulizar);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao editar livro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_editarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            CriarLivros dialog = new CriarLivros(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anoPublicacaoComboBox;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField capaAlternativa;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JButton editar;
    private javax.swing.JLabel editoraLabel;
    private javax.swing.JTextField inputISBN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeAutor;
    private javax.swing.JTextField nomeEditora;
    private javax.swing.JTextField nomeLivro;
    private javax.swing.JLabel nomeLivroLabel;
    private javax.swing.JButton ok;
    private javax.swing.JTextArea resumoLivro;
    private javax.swing.JLabel resumoLivroLabel;
    private javax.swing.JLabel sinopseLabel;
    private javax.swing.JTextArea sinopseLivro;
    private javax.swing.JTextField tags;
    private javax.swing.JLabel titulo;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    // End of variables declaration//GEN-END:variables
}
