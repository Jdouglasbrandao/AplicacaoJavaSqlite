package projetoa3;

public class TelaClientes extends javax.swing.JFrame {
    private final Clientes janelaClientes;
    private final int codigo;
    
    public TelaClientes(Clientes janelacliente, int codigo) {
        
        initComponents();
        setLocationRelativeTo(null);
        this.janelaClientes = janelacliente;
        this.codigo = codigo;
        
        txtDatanascimento.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if ("dd/mm/aaaa".equals(txtDatanascimento.getText())) {
                    txtDatanascimento.setText("");
                }
            }
        });
        
        txtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if ("xxx.xxx.xxx-xx".equals(txtCpf.getText())) {
                    txtCpf.setText("");
                }
            }
        });
        
        if(codigo != -1) {
            this.setTitle("EDITAR CADASTRO DE CLIENTES");
            DB db = new DB("bancodados.db");
            db.query("SELECT * FROM CadastroClientes WHERE codigo="+codigo);
            if(db.next()) {
                String cpf = db.getString("cpf");
                String nome = db.getString("nome");
                String genero = db.getString("genero");
                String datanascimento = db.getString("datanascimento");
                txtCpf.setText(cpf);
                EscolhaGenero.getSelectedItem().toString();

                txtNome.setText(nome);
                txtDatanascimento.setText(datanascimento);
            }
            db.closeConnection();        
        } else {
            this.setTitle("Novo Cliente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtDatanascimento = new javax.swing.JFormattedTextField();
        EscolhaGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(448, 359));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 77, 50, 19);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPF");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 126, 50, 19);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gênero");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 167, 60, 19);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data de Nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 208, 150, 19);
        getContentPane().add(txtNome);
        txtNome.setBounds(116, 74, 250, 23);

        txtCpf.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        txtCpf.setText("xxx.xxx.xxx-xx");
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpf);
        txtCpf.setBounds(116, 123, 249, 25);

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 266, 96, 25);

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jButton2.setText("Enviar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 266, 80, 25);

        txtDatanascimento.setText("dd/mm/aaaa");
        txtDatanascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatanascimentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDatanascimento);
        txtDatanascimento.setBounds(187, 205, 180, 23);

        EscolhaGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        EscolhaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscolhaGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(EscolhaGenero);
        EscolhaGenero.setBounds(116, 164, 140, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoa3/JavaJ.JPG"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-6, 3, 460, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String genero = EscolhaGenero.getSelectedItem().toString();
        String datanascimento = txtDatanascimento.getText();
        DB db = new DB("bancodados.db");
        String query = "";
        if(codigo == -1) {
            query = "INSERT INTO CadastroClientes (nome, genero, cpf, datanascimento) ";
            query = query + "VALUES (";
            query = query + "'" + nome + "',";
            query = query + "'" + genero + "',";
            query = query + "'" + cpf + "',";
            query = query + "'" + datanascimento + "'";
            query = query + ");";            
        } else {
            query = "UPDATE CadastroClientes SET ";
            query = query + "nome='" + nome + "', ";
            query = query + "genero='" + genero + "', ";
            query = query + "cpf='" + cpf+ "', ";
            query = query + "datanascimento='" + datanascimento + "'";
            query = query + " WHERE codigo="+this.codigo; 
        }
        db.execQuery(query);
        janelaClientes.refreshTable();
        this.dispose();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EscolhaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscolhaGeneroActionPerformed
       
    }//GEN-LAST:event_EscolhaGeneroActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
            if ("xxx.xxx.xxx-xx".equals(txtCpf.getText())) {
        txtCpf.setText("");
    }
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtDatanascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatanascimentoActionPerformed
          if ("dd/mm/aaaa".equals(txtDatanascimento.getText())) {
        txtDatanascimento.setText("");
    }

    }//GEN-LAST:event_txtDatanascimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EscolhaGenero;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtDatanascimento;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
