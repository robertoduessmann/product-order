package view;

import controller.ProdutoController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author Thiago
 */
public class JFProduto extends javax.swing.JFrame {

    DefaultTableModel model;
    ProdutoController produtoController;
    ArrayList<Produto> listaProdutos;
    Produto produto;

    public JFProduto() throws Exception {
        initComponents();
        CarregarTableProdutos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Descricao = new javax.swing.JTextField();
        btn_Gravar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProdutos = new javax.swing.JTable();
        txt_ID = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
        setPreferredSize(new java.awt.Dimension(650, 500));
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

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

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        TableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableProdutos);

        txt_ID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE))
                            .addComponent(txt_Descricao)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Gravar)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_Buscar)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Gravar)
                    .addComponent(btn_Excluir)
                    .addComponent(btn_Limpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        getAccessibleContext().setAccessibleName("Produtos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void CarregarTableProdutos(int id) throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Descrição");

        produtoController = new ProdutoController();
        produto = produtoController.Buscar(id);        
        model.addRow(new String[]{produto.getId() + "", produto.getDescricao()});
        TableProdutos.setModel(model);
    }
    
    
    private void CarregarTableProdutos() throws Exception {
        model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Descrição");

        produtoController = new ProdutoController();
        listaProdutos = produtoController.BuscarTodos();

        listaProdutos.forEach((produto) -> {
            model.addRow(new String[]{produto.getId() + "", produto.getDescricao()});
        });

        TableProdutos.setModel(model);
    }

    private void btn_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GravarActionPerformed
        try {
            boolean sucesso;
            produtoController = new ProdutoController();

            if (txt_ID.getText().trim().isEmpty()) {
                
                if (txt_Descricao.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Informe a descrição do produto e clique em gravar.", "Produto", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                sucesso = produtoController.Gravar(txt_Descricao.getText());

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso", "Produto", JOptionPane.INFORMATION_MESSAGE);
                    Limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível gravar novo produto", "Produto", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                sucesso = produtoController.Alterar(Integer.parseInt(txt_ID.getText().trim()), txt_Descricao.getText());

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso", "Produto", JOptionPane.INFORMATION_MESSAGE);
                    Limpar();
                } else {
                    produtoController.Gravar(txt_Descricao.getText());
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso", "Produto", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            CarregarTableProdutos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Produto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_GravarActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed

        try {
            if (!txt_ID.getText().trim().isEmpty()) {
                produtoController = new ProdutoController();

                if (produtoController.Excluir(Integer.parseInt(txt_ID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso", "Produto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto", "Produto", JOptionPane.INFORMATION_MESSAGE);
                }

                Limpar();
                CarregarTableProdutos();
            } else {
                 JOptionPane.showMessageDialog(null, "Informe o código do produto", "Produto", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Produto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        try {
            Limpar();
        } catch (Exception ex) {
            Logger.getLogger(JFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void Limpar() throws Exception {
        txt_Descricao.setText("");
        txt_ID.setText("");
        CarregarTableProdutos();
    }

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        try {
            if (!txt_ID.getText().trim().isEmpty()) {
                produtoController = new ProdutoController();
                produto = produtoController.Buscar(Integer.parseInt(txt_ID.getText()));
                                
                if (produto != null) {
                    txt_Descricao.setText(produto.getDescricao());
                    CarregarTableProdutos(produto.getId());  
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.", "Produto", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe o código do produto", "Produto", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação. Descrição: " + e.getMessage(), "Produto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFProduto().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(JFProduto.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProdutos;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Gravar;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Descricao;
    private javax.swing.JFormattedTextField txt_ID;
    // End of variables declaration//GEN-END:variables
}
