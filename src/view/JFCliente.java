package view;

import controller.ClienteController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author Thiago
 */
public class JFCliente extends javax.swing.JFrame {

    ClienteController clienteController;
    Cliente cliente;
    ArrayList<Cliente> listaClientes;
    DefaultTableModel model;

    public JFCliente() throws Exception {
        initComponents();
        Limpar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Nome = new javax.swing.JTextField();
        txt_SobreNome = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        btn_Gravar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        btn_Limpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txt_CPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
        setPreferredSize(new java.awt.Dimension(650, 500));
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("CPF");

        jLabel2.setText("Nome");

        jLabel3.setText("Sobrenome");

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        btn_Gravar.setText("Gravar");
        btn_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GravarActionPerformed(evt);
            }
        });

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });

        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableCliente.setGridColor(new java.awt.Color(51, 51, 255));
        jScrollPane1.setViewportView(TableCliente);

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        jLabel4.setText("Código");

        txt_ID.setEditable(false);
        txt_ID.setBackground(new java.awt.Color(204, 204, 204));

        try {
            txt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_CPF.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Excluir)
                                .addGap(4, 4, 4)
                                .addComponent(btn_Gravar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Nome)
                                    .addComponent(txt_SobreNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(txt_CPF))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_Buscar)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_Buscar)
                    .addComponent(txt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_SobreNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Gravar)
                    .addComponent(btn_Excluir)
                    .addComponent(btn_Limpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GravarActionPerformed
        try {
            boolean sucesso;
            clienteController = new ClienteController();
            String cpf = txt_CPF.getText().trim().replace(".", "").replace("-", "").replace(" ", "");

            if (Integer.parseInt(txt_ID.getText()) == 0) {

                if (cpf.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Informe o CPF do cliente.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (txt_Nome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Informe o Nome do cliente.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    return;                  
                }
                 else if (txt_SobreNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Informe o Sobrenome do cliente.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                                
                sucesso = clienteController.Gravar(cpf, txt_Nome.getText(), txt_SobreNome.getText());

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    Limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível gravar novo cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } else {
                sucesso = clienteController.Alterar(Integer.parseInt(txt_ID.getText()), cpf, txt_Nome.getText(), txt_SobreNome.getText());

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    Limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar novo cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_GravarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        try {
            clienteController = new ClienteController();
            cliente = clienteController.Buscar(txt_CPF.getText().replace(".", "").replace("-", ""));

            if (cliente != null) {
                txt_Nome.setText(cliente.getNome());
                txt_SobreNome.setText(cliente.getSobreNome());
                txt_ID.setText(cliente.getId() + "");
                CarregarTableClientes(cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed

        try {
            clienteController = new ClienteController();

            if (clienteController.Excluir(txt_CPF.getText().replace(".", "").replace("-", ""))) {
                JOptionPane.showMessageDialog(null, "Excluido com sucesso", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }

            Limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        try {
            Limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void Limpar() throws Exception {
        txt_CPF.setText("");
        txt_Nome.setText("");
        txt_SobreNome.setText("");
        txt_ID.setText("0");

        CarregarTableClientes();
    }

    private void CarregarTableClientes() throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("CPF");
        model.addColumn("Nome");
        model.addColumn("Sobrenome");

        clienteController = new ClienteController();
        listaClientes = clienteController.BuscarTodos();

        listaClientes.forEach((cli) -> {
            model.addRow(new String[]{cli.getId() + "", clienteController.cpfFormatado(cli.getCpf()), cli.getNome(), cli.getSobreNome()});
        });

        TableCliente.setModel(model);
    }

    private void CarregarTableClientes(Cliente cliente) throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("CPF");
        model.addColumn("Nome");
        model.addColumn("Sobrenome");

        clienteController = new ClienteController();
        listaClientes = clienteController.BuscarTodos(cliente.getId());

        listaClientes.forEach((cli) -> {
            model.addRow(new String[]{cli.getId() + "", cli.getCpf(), cli.getNome(), cli.getSobreNome()});
        });

        TableCliente.setModel(model);
    }

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
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFCliente().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JFCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCliente;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Gravar;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Nome;
    private javax.swing.JTextField txt_SobreNome;
    // End of variables declaration//GEN-END:variables

}
