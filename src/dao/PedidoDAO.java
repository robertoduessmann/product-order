package dao;

import com.mysql.jdbc.Statement;
import controller.ClienteController;
import controller.ProdutoController;
import database.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cliente;
import model.ItemDoPedido;
import model.Pedido;

/**
 *
 * @author Thiago
 */
public class PedidoDAO {

    Connection conexao;
    Pedido pedido;
    ItemDoPedido itens;
    ArrayList<Pedido> listaPedidos;
    ArrayList<ItemDoPedido> listaItemDoPedido;
    ClienteController clienteController;
    ProdutoController produtoController;
    ResultSet rs;

    public static int GravarPedido(Pedido pedido) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            int lastId = 0;

            PreparedStatement pst = conexao
                    .prepareStatement("INSERT INTO PEDIDO (DATA, ID_CLIENTE) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pedido.getData());
            pst.setInt(2, pedido.getCliente().getId());

            pst.executeUpdate();
            final ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }

            return lastId;
        } catch (Exception e) {
            return 0;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public static int GravarItemPedido(int idPedido, int idProduto, int quantidade) {

        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            int lastId = 0;

            PreparedStatement pst = conexao
                    .prepareStatement("INSERT INTO ITEM_DO_PEDIDO (ID_PEDIDO, ID_PRODUTO, QUANTIDADE) VALUES (?, ?, ?);");
            pst.setInt(1, idPedido);
            pst.setInt(2, idProduto);
            pst.setInt(3, quantidade);

            pst.executeUpdate();
            final ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }

            return lastId;
        } catch (Exception e) {
            return 0;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }
   
    public ArrayList<Pedido> BuscarTodos(Cliente cliente) throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            listaPedidos = new ArrayList<Pedido>();

            pedido = null;

            java.sql.Statement st = conexao.createStatement();
            rs = st.executeQuery("select i.ID_PEDIDO, i.ID_PRODUTO, p.DATA, i.QUANTIDADE from item_do_pedido i "
                    + " inner join pedido p on p.ID = i.ID_PEDIDO "
                    + " where p.id_cliente = " + cliente.getId());

            while (rs.next()) {
                pedido = (new Pedido(
                        rs.getInt("ID_PEDIDO"),
                        rs.getString("DATA"),
                        cliente,
                        BuscarItens(rs.getInt("ID_PRODUTO"), rs.getInt("QUANTIDADE"))));
                listaPedidos.add(pedido);
            }

            return listaPedidos;
        } catch (Exception e) {

            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public ArrayList<Pedido> BuscarTodos(int idPedido) throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            listaPedidos = new ArrayList<Pedido>();
            clienteController = new ClienteController();

            pedido = null;

            java.sql.Statement st = conexao.createStatement();
            rs = st.executeQuery("select i.ID_PEDIDO, i.ID_PRODUTO, p.DATA, i.QUANTIDADE, cli.cpf from item_do_pedido i "
                    + " inner join pedido p on p.ID = i.ID_PEDIDO "
                    + " INNER JOIN CLIENTE CLI ON "
                    + " CLI.ID = p.ID_CLIENTE "
                    + " where i.ID_PEDIDO = " + idPedido);

            while (rs.next()) {
                pedido = (new Pedido(
                        rs.getInt("ID_PEDIDO"),
                        rs.getString("DATA"),
                        clienteController.Buscar(rs.getString("CPF")),
                        BuscarItens(rs.getInt("ID_PRODUTO"), rs.getInt("QUANTIDADE"))));
                listaPedidos.add(pedido);
            }

            return listaPedidos;
        } catch (Exception e) {

            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public ArrayList<Pedido> BuscarTodos(Cliente cliente, int idPedido) throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            listaPedidos = new ArrayList<Pedido>();
            clienteController = new ClienteController();

            pedido = null;

            java.sql.Statement st = conexao.createStatement();
            rs = st.executeQuery("select i.ID_PEDIDO, i.ID_PRODUTO, p.DATA, i.QUANTIDADE, cli.cpf from item_do_pedido i "
                    + " inner join pedido p on p.ID = i.ID_PEDIDO "
                    + " INNER JOIN CLIENTE CLI ON "
                    + " CLI.ID = p.ID_CLIENTE "
                    + " where i.ID_PEDIDO = " + idPedido + " AND CLI.id = " + cliente.getId());

            while (rs.next()) {
                pedido = (new Pedido(
                        rs.getInt("ID_PEDIDO"),
                        rs.getString("DATA"),
                        clienteController.Buscar(rs.getString("CPF")),
                        BuscarItens(rs.getInt("ID_PRODUTO"), rs.getInt("QUANTIDADE"))));
                listaPedidos.add(pedido);
            }

            return listaPedidos;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    private ArrayList<ItemDoPedido> BuscarItens(int idProduto, int qtd) {
        try {
            produtoController = new ProdutoController();
            listaItemDoPedido = new ArrayList<>();

            itens = new ItemDoPedido(qtd, produtoController.Buscar(idProduto));
            listaItemDoPedido.add(itens);

            return listaItemDoPedido;
        } catch (Exception e) {
            return null;
        }
    }
}
