package view;

import controller.ClienteController;
import controller.PedidoController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author Thiago
 */
public class JFPedidos extends javax.swing.JFrame {

    Cliente cliente;
    ClienteController clienteController;
    DefaultTableModel model;
    PedidoController pedidoController;
    ArrayList<Pedido> listaPedidos;

    public JFPedidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_Nome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePedidos = new javax.swing.JTable();
        txt_CPF = new javax.swing.JFormattedTextField();
        txt_IdPedido = new javax.swing.JFormattedTextField();
        btn_Limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
        setPreferredSize(new java.awt.Dimension(650, 500));
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("CPF");

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código do Pedido");

        lbl_Nome.setDisplayedMnemonic('L');
        lbl_Nome.setText(" ");
        lbl_Nome.setMaximumSize(null);
        lbl_Nome.setMinimumSize(null);

        TablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablePedidos);

        try {
            txt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_CPF.setToolTipText("");

        txt_IdPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btn_Limpar.setText("Limpar");
        btn_Limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LimparMouseClicked(evt);
            }
        });
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_CPF)
                            .addComponent(txt_IdPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(466, 466, 466)
                                .addComponent(btn_Limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Buscar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_IdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Buscar)
                        .addComponent(btn_Limpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        try {
            txt_CPF.setEnabled(false);
            txt_IdPedido.setEnabled(false);
            String cpf = txt_CPF.getText().replace(".", "").replace("-", "").trim();
            String idPedido = txt_IdPedido.getText().trim();

            if (cpf.isEmpty() && idPedido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o CPF do cliente ou código de um pedido e clique em buscar.", "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
                Limpar();
            } else if (idPedido.trim().isEmpty()) {
                clienteController = new ClienteController();
                cliente = clienteController.Buscar(cpf);

                CarregarTableClientes(cliente);

                if (cliente != null) {
                    lbl_Nome.setText(cliente.getNome() + " " + cliente.getSobreNome());
                }
            } else if (cpf.isEmpty()) {
                CarregarTableClientes(Integer.parseInt(idPedido));
            } else {
                clienteController = new ClienteController();
                cliente = clienteController.Buscar(cpf);

                CarregarTableClientes(cliente, Integer.parseInt(idPedido));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Produto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        Limpar();
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void Limpar() {
        txt_CPF.setText("");
        txt_IdPedido.setText("");
        lbl_Nome.setText("");
        TablePedidos.setModel(new DefaultTableModel());
        txt_CPF.setEnabled(true);
        txt_IdPedido.setEnabled(true);
    }


    private void btn_LimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LimparMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LimparMouseClicked

    private void CarregarTableClientes(Cliente cliente) throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código Pedido");
        model.addColumn("Data Emitida");
        model.addColumn("Produto");
        model.addColumn("Quantidade");

        pedidoController = new PedidoController();
        ArrayList<Pedido> pedidos = pedidoController.BuscarTodos(cliente);

        pedidos.forEach((pedido) -> {
            pedido.getItens().forEach((item) -> {
                model.addRow(new String[]{pedido.getId() + "", pedido.getData(), item.getProduto().getDescricao(), item.getQuantidade() + ""});
            });
        });

        TablePedidos.setModel(model);
    }

    private void CarregarTableClientes(int idPedido) throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código Pedido");
        model.addColumn("Data Emitida");
        model.addColumn("Produto");
        model.addColumn("Quantidade");

        pedidoController = new PedidoController();
        listaPedidos = pedidoController.BuscarTodos(idPedido);

        listaPedidos.stream().map((pedido) -> {
            pedido.getItens().forEach((item) -> {
                model.addRow(new String[]{pedido.getId() + "", pedido.getData(), item.getProduto().getDescricao(), item.getQuantidade() + ""});
            });
            return pedido;
        }).filter((pedido) -> (pedido.getCliente() != null)).map((pedido) -> {
            lbl_Nome.setText(pedido.getCliente().getNome() + " " + pedido.getCliente().getSobreNome());
            return pedido;
        }).forEachOrdered((pedido) -> {
            txt_CPF.setText(pedido.getCliente().getCpf());
            lbl_Nome.setText(pedido.getCliente().getNome() + " " + pedido.getCliente().getSobreNome());
        });
        TablePedidos.setModel(model);
    }

    private void CarregarTableClientes(Cliente cliente, int idPedido) throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código Pedido");
        model.addColumn("Data Emitida");
        model.addColumn("Produto");
        model.addColumn("Quantidade");

        pedidoController = new PedidoController();
        listaPedidos = pedidoController.BuscarTodos(cliente, idPedido);

        listaPedidos.stream().map((pedido) -> {
            pedido.getItens().forEach((item) -> {
                model.addRow(new String[]{pedido.getId() + "", pedido.getData(), item.getProduto().getDescricao(), item.getQuantidade() + ""});
            });
            return pedido;
        }).filter((pedido) -> (pedido.getCliente() != null)).map((pedido) -> {

            return pedido;
        }).forEachOrdered((pedido) -> {
            txt_CPF.setText(pedido.getCliente().getCpf());
            lbl_Nome.setText(pedido.getCliente().getNome() + " " + pedido.getCliente().getSobreNome());
        });
        TablePedidos.setModel(model);

//          for (Pedido listaPedido : listaPedidos) {
//            for (ItemDoPedido item : listaPedido.getItens()) {
//                 model.addRow(new String[]{listaPedido.getId() + "", listaPedido.getData(), item.getProduto().getDescricao(), item.getQuantidade() + ""});
//            }
//            
//            lbl_Nome.setText(listaPedido.getCliente().getNome() + " " + listaPedido.getCliente().getSobreNome());
//            txt_CPF.setText(listaPedido.getCliente().getCpf());
//        }
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
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePedidos;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JFormattedTextField txt_IdPedido;
    // End of variables declaration//GEN-END:variables
}
