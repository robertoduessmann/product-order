package view;

import controller.ClienteController;
import controller.PedidoController;
import controller.ProdutoController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ItemDoPedido;
import model.Produto;

/**
 *
 * @author Thiago
 */
public class JFNovosPedidos extends javax.swing.JFrame {

    ProdutoController produtoController;
    Produto produto;
    ArrayList<Produto> ListaProdutos;
    ArrayList<ItemDoPedido> ListaItemDoPedido;
    Cliente cliente;
    ClienteController clienteController;
    ItemDoPedido itemdoPedido;
    PedidoController pedidoController;
    int contador = 0;

    public JFNovosPedidos() throws Exception {
        initComponents();
        CarregarComboProdutos();
        ListaItemDoPedido = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_Buscar = new javax.swing.JButton();
        lbl_Nome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Cbo_Produtos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_Quantidade = new javax.swing.JTextField();
        btn_Adicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_Produtos = new javax.swing.JTextArea();
        btn_Confirmar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_IDRemocao = new javax.swing.JTextField();
        btn_Remover = new javax.swing.JButton();
        txt_CPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("CPF");

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        lbl_Nome.setText(" ");

        jLabel3.setText("Produto");

        jLabel5.setText("Quantidade");

        btn_Adicionar.setText("Adicionar");
        btn_Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AdicionarMouseClicked(evt);
            }
        });
        btn_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionarActionPerformed(evt);
            }
        });

        txtArea_Produtos.setColumns(20);
        txtArea_Produtos.setRows(5);
        jScrollPane1.setViewportView(txtArea_Produtos);

        btn_Confirmar.setText("Confirmar");
        btn_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfirmarActionPerformed(evt);
            }
        });

        jLabel6.setText("Remover Item");

        txt_IDRemocao.setToolTipText("Favor informe o item (id) do produto que deseja remover");

        btn_Remover.setText("OK");
        btn_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoverActionPerformed(evt);
            }
        });

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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(txt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btn_Buscar)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_Nome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(Cbo_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(txt_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_Adicionar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_IDRemocao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btn_Remover)
                        .addGap(258, 258, 258)
                        .addComponent(btn_Confirmar))
                    .addComponent(jScrollPane1))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Buscar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbl_Nome)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Cbo_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Adicionar))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_IDRemocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(btn_Remover)
                    .addComponent(btn_Confirmar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txt_IDRemocao.getAccessibleContext().setAccessibleDescription("Favor informe o item do produto que deseja remove");

        getAccessibleContext().setAccessibleName("Novo Pedido");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CarregarComboProdutos() throws Exception {
        produtoController = new ProdutoController();
        ListaProdutos = produtoController.BuscarTodos();

        ListaProdutos.forEach((produto) -> {
            Cbo_Produtos.addItem(produto.getDescricao());
        });
    }

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        try {
            clienteController = new ClienteController();
            cliente = clienteController.Buscar(txt_CPF.getText().replace(".", "").replace("-", ""));

            if (cliente != null) {
                lbl_Nome.setText(cliente.getNome() + " " + cliente.getSobreNome());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed

    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_AdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AdicionarMouseClicked
        try {

            if (lbl_Nome.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o CPF do cliente e clique em buscar.", "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (txt_Quantidade.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade desejada.", "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            produtoController = new ProdutoController();
            produto = produtoController.Buscar(Cbo_Produtos.getSelectedItem().toString());

            itemdoPedido = new ItemDoPedido(++contador, Integer.parseInt(txt_Quantidade.getText()), produto);
            ListaItemDoPedido.add(itemdoPedido);

            CarregarItensSelecionados();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_AdicionarMouseClicked

    private void btn_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoverActionPerformed

        ArrayList<ItemDoPedido> ListaNova = new ArrayList<ItemDoPedido>();

        for (ItemDoPedido itemDoPedido : ListaItemDoPedido) {
            if (itemDoPedido.getIdItem() != Integer.parseInt(txt_IDRemocao.getText())) {
                ListaNova.add(itemDoPedido);
            }
        }

        ListaItemDoPedido = new ArrayList<ItemDoPedido>();
        ListaItemDoPedido.addAll(ListaNova);

        CarregarItensSelecionados();
    }//GEN-LAST:event_btn_RemoverActionPerformed

    private void btn_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmarActionPerformed

        try {
            pedidoController = new PedidoController();
            clienteController = new ClienteController();

            int idPedido = pedidoController.GravarPedido(clienteController.Buscar(txt_CPF.getText().replace(".", "").replace("-", "")), ListaItemDoPedido);

            if (idPedido > 0) {
                JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso. \nNúmero do pedido: " + idPedido, "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
                Limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Não foi realiza o pedido", "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
            }

            Limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ConfirmarActionPerformed

    private void CarregarItensSelecionados() {
        try {
            StringBuilder texto = new StringBuilder();
            txtArea_Produtos.setText(texto.toString());

            for (ItemDoPedido itemDoPedido : ListaItemDoPedido) {
                texto.append("Item: ").append(itemDoPedido.getIdItem()).append("\r\n").append(itemDoPedido.getProduto().toString()).append("Quantidade: ").append(itemDoPedido.getQuantidade()).append(" ] \r\n " + "\r\n");
            }

            txtArea_Produtos.setText(texto.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Novo Pedido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void Limpar() {
        txtArea_Produtos.setText("");
        txt_Quantidade.setText("");
        txt_IDRemocao.setText("");
        txt_CPF.setText("");
        lbl_Nome.setText("");
        ListaItemDoPedido = new ArrayList<ItemDoPedido>();
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
            java.util.logging.Logger.getLogger(JFNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFNovosPedidos().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JFNovosPedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbo_Produtos;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Confirmar;
    private javax.swing.JButton btn_Remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JTextArea txtArea_Produtos;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JTextField txt_IDRemocao;
    private javax.swing.JTextField txt_Quantidade;
    // End of variables declaration//GEN-END:variables

}
