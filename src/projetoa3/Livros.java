package projetoa3;

import javax.swing.JOptionPane;


public class Livros extends javax.swing.JFrame {


    public Livros() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("LISTA DE LIVROS");  
        this.refreshTable();
    }

    public final void refreshTable() {
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM CadastroLivros");  
        String cols[] = { "CODIGO", "TITULO", "AUTOR", "GENERO" };  
        String fields[] = { "codigo", "titulo", "autor", "genero" }; 
        TableRender.render(table, cols, fields, db);
        db.closeConnection();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        Retornar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(870, 570));
        getContentPane().setLayout(null);

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(0, 153, 153));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 838, 402);

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setText("Adicionar ");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 63, 120, 30);

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setText("Deletar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(730, 63, 116, 30);

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton3.setText("Editar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(610, 63, 120, 30);

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(txtBusca);
        txtBusca.setBounds(160, 63, 284, 30);

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton4.setText("Buscar Livro");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 63, 130, 30);

        Retornar.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        Retornar.setText("Retornar ao Menu");
        Retornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornarActionPerformed(evt);
            }
        });
        getContentPane().add(Retornar);
        Retornar.setBounds(340, 10, 210, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoa3/javaA.jpeg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-70, 0, 940, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        EditarLivros cadastro = new EditarLivros(this,-1);
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        int linha = table.getSelectedRow();
        System.out.println("Linha selecionada: " + linha);
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. Selecione uma linha!");
            return;
        }
        String codigo = (String) table.getValueAt(linha, 0);
        System.out.println("Código :" + codigo);
        DB db = new DB("bancodados.db");
        String query = "DELETE FROM CadastroLivros WHERE codigo=" + codigo; 
        db.execQuery(query);
        refreshTable();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int linha = table.getSelectedRow();
        System.out.println("Linha selecionada: " + linha);
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. Selecione uma linha!");
            return;
        }
        String codigo = (String) table.getValueAt(linha, 0);
        System.out.println("Código :" + codigo);
        EditarLivros cadastro = new EditarLivros(this, Integer.parseInt(codigo));
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nomeBuscar = txtBusca.getText();
        System.out.println("texto da busca: " + nomeBuscar);
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM CadastroLivros WHERE titulo LIKE '%" + nomeBuscar + "%'");  
        String cols[] = { "CODIGO", "TITULO", "AUTOR", "GENERO" };  
        String fields[] = { "codigo", "titulo", "autor", "genero" };  
        TableRender.render(table, cols, fields, db);
        db.closeConnection();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
       
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornarActionPerformed
    Menu menu = new Menu();  
    menu.setVisible(true);
    this.dispose();  
    }//GEN-LAST:event_RetornarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Retornar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
