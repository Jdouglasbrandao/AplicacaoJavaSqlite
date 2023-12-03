package projetoa3;

import javax.swing.JOptionPane;

public class Clientes extends javax.swing.JFrame {

    public Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("LISTA DE CLIENTE");
        this.refreshTable();
    }

    public void refreshTable() {
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM CadastroClientes");
        String cols[] = { "CÓDIGO", "NOME", "GÊNERO", "CPF", "DATA DE NASCIMENTO" };
        String fields[] = { "codigo", "nome", "genero", "cpf", "datanascimento" };        
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
        jLabel1 = new javax.swing.JLabel();
        Retornar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(870, 570));
        setPreferredSize(new java.awt.Dimension(891, 530));
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
        jScrollPane1.setBounds(20, 130, 860, 410);

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setText("Adicionar ");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 70, 120, 30);

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setText("Deletar ");
        jButton2.setAlignmentY(0.0F);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 70, 128, 30);

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton3.setText("Editar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(610, 70, 128, 30);
        getContentPane().add(txtBusca);
        txtBusca.setBounds(160, 70, 255, 30);

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton4.setText("Buscar Cliente");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 70, 128, 30);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(421, 6, 313, 0);

        Retornar.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        Retornar.setText("Retornar ao Menu");
        Retornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornarActionPerformed(evt);
            }
        });
        getContentPane().add(Retornar);
        Retornar.setBounds(360, 20, 190, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoa3/javaA.jpeg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-30, 0, 940, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaClientes cadastro = new TelaClientes(this,-1);
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int linha = table.getSelectedRow();
        System.out.println("Linha selecionada: "+linha);
        if(linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. Selecione uma linha!");
            return;
        }
        String codigo = (String) table.getValueAt(linha, 0);
        System.out.println("Código :"+codigo);
        TelaClientes cadastro = new TelaClientes(this, Integer.parseInt(codigo));
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int linha = table.getSelectedRow();
        System.out.println("Linha selecionada: "+linha);
        if(linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. Selecione uma linha!");
            return;
        }
        String codigo = (String) table.getValueAt(linha, 0);
        System.out.println("Código :"+codigo);
        DB db = new DB("bancodados.db");
        String query = "DELETE FROM CadastroClientes WHERE codigo="+codigo;
        db.execQuery(query);
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        String nomeBuscar = txtBusca.getText();
        System.out.println("texto da busca: "+nomeBuscar);
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM CadastroClientes WHERE nome LIKE '%" + nomeBuscar + "%'");
        String cols[] = { "CÓDIGO", "NOME", "GÊNERO", "CPF", "DATA DE NASCIMENTO" };
        String fields[] = { "codigo", "nome", "genero", "cpf", "datanascimento"};         
        TableRender.render(table, cols, fields, db);
        db.closeConnection(); 
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
