package projetoa3;

public class EditarLivros extends javax.swing.JFrame {

    private final Livros janelaLivros;
    private final int codigo;

    public EditarLivros(Livros janelaLivros, int codigo) {
        initComponents();
        setLocationRelativeTo(null);
        this.janelaLivros = janelaLivros;
        this.codigo = codigo;
        if (codigo != -1) {
            this.setTitle("EDITAR LIVRO");
            DB db = new DB("bancodados.db");
            db.query("SELECT * FROM CadastroLivros WHERE codigo=" + codigo);
            if (db.next()) {
                String titulo = db.getString("titulo");
                String autor = db.getString("autor");
                String genero = db.getString("genero");

                txtTitulo.setText(titulo);
                txtAutor.setText(autor);
                txtGenero.setText(genero);

            }
            db.closeConnection();
        } else {
            this.setTitle("NOVO LIVRO");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtAutor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(514, 293));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Titulo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 70, 50, 17);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Autor");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(61, 114, 50, 19);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gênero");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(51, 155, 60, 19);

        txtTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        getContentPane().add(txtTitulo);
        txtTitulo.setBounds(121, 65, 318, 30);

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 220, 113, 30);

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 220, 90, 30);

        txtAutor.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        getContentPane().add(txtAutor);
        txtAutor.setBounds(121, 106, 318, 30);

        txtGenero.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        getContentPane().add(txtGenero);
        txtGenero.setBounds(121, 147, 318, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoa3/JavaB.JPG"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-1, -12, 520, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String genero = txtGenero.getText();
        DB db = new DB("bancodados.db");
        String query = "";
        if (codigo == -1) {
            query = "INSERT INTO CadastroLivros (titulo, autor, genero) ";
            query = query + "VALUES (";
            query = query + "'" + titulo + "',";
            query = query + "'" + autor + "',";
            query = query + "'" + genero + "'";
            query = query + ");";
        } else {
            query = "UPDATE CadastroLivros SET ";
            query = query + "titulo = '" + titulo + "', ";
            query = query + "autor = '" + autor + "', ";
            query = query + "genero = '" + genero + "'";
            query = query + " WHERE codigo=" + this.codigo;
        }
        db.execQuery(query);
        janelaLivros.refreshTable();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
