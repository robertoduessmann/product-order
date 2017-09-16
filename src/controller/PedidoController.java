
package controller;

import dao.PedidoDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.Cliente;
import model.ItemDoPedido;
import model.Pedido;

/**
 *
 * @author Thiago
 */
public class PedidoController {

    public int GravarPedido(Cliente cliente, ArrayList<ItemDoPedido> itens) {

        Date data = new Date(System.currentTimeMillis());
        Pedido pedido = new Pedido(0, data.toString(), cliente, itens);

        //PedidoDAO.Transaction(); 
        
        int idPedido = PedidoDAO.GravarPedido(pedido);

        if (idPedido > 0) {
            itens.forEach((itemDoPedido) -> {
                PedidoDAO.GravarItemPedido(idPedido, itemDoPedido.getProduto().getId(),itemDoPedido.getQuantidade());
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
