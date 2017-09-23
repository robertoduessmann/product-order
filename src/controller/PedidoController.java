
package controller;

import dao.PedidoDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ItemDoPedido;
import model.Pedido;

/**
 *
 * @author Thiago
 */
public class PedidoController {

    public int GravarPedido(Cliente cliente, ArrayList<ItemDoPedido> itens) throws Exception {

        Date data = new Date(System.currentTimeMillis());
        Pedido pedido = new Pedido(0, data.toString(), cliente, itens);

        //PedidoDAO.Transaction(); 
        
        int idPedido = PedidoDAO.GravarPedido(pedido);

        if (idPedido > 0) {
            itens.forEach((itemDoPedido) -> {
                try {
                    PedidoDAO.GravarItemPedido(idPedido, itemDoPedido.getProduto().getId(),itemDoPedido.getQuantidade());
                } catch (Exception ex) {
                    Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        
        //PedidoDAO.Commit(); 
        
        return idPedido;
    }

    public ArrayList<Pedido> BuscarTodos(Cliente cliente) throws Exception {
        
        PedidoDAO p = new PedidoDAO();
        return p.BuscarTodos(cliente);
    }
    
    public ArrayList<Pedido> BuscarTodos(int idPedido) throws Exception {
        
        PedidoDAO p = new PedidoDAO();
        return p.BuscarTodos(idPedido);
    }
    
    public ArrayList<Pedido> BuscarTodos(Cliente cliente, int idPedido) throws Exception {
        
        PedidoDAO p = new PedidoDAO();
        return p.BuscarTodos(cliente, idPedido);
    }


}
