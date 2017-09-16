package dao;

import database.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDAO {

    Cliente cliente;
    ArrayList<Cliente> listaClientes;
    Connection conexao;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    public Cliente Buscar(String cpf) throws Exception {       
        try {            
            conexao = ConexaoMySQL.getConexaoMySQL();
            cliente = null;

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT C.ID, C.CPF, C.NOME, C.SOBRENOME FROM CLIENTE C"
                            + " WHERE C.CPF = '" + cpf.trim() + "'");

            while (rs.next()) {
                cliente = (new Cliente(
                        rs.getInt("ID"),
                        rs.getString("CPF"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME")
                ));
            }
            return cliente;
        } catch (Exception e) {

            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public Boolean Gravar(Cliente cliente) {
        
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            pst = conexao.prepareStatement("INSERT INTO CLIENTE (CPF, NOME, SOBRENOME) VALUES (?, ?, ?);");
            pst.setString(1, cliente.getCpf());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getSobreNome());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public boolean Excluir(String cpf) {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            pst = conexao.prepareStatement("DELETE FROM CLIENTE WHERE CPF = ?;");
            pst.setString(1, cpf);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            ConexaoMySQL.FecharConexao();
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public boolean Alterar(Cliente cliente) {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();

            pst = conexao.prepareStatement("UPDATE CLIENTE SET CPF = ?, NOME = ?, SOBRENOME = ? WHERE ID = ?;");
            pst.setString(1, cliente.getCpf());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getSobreNome());
            pst.setInt(4, cliente.getId());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            ConexaoMySQL.FecharConexao();
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public ArrayList<Cliente> BuscarTodos() throws Exception {        
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            cliente = null;
            listaClientes = new ArrayList<Cliente>();

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT C.ID, C.CPF, C.NOME, C.SOBRENOME FROM CLIENTE C");

            while (rs.next()) {
                cliente = (new Cliente(
                        rs.getInt("ID"),
                        rs.getString("CPF"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME")
                ));
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public ArrayList<Cliente> BuscarTodos(int idCliente) throws Exception {
         
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            cliente = null;
            listaClientes = new ArrayList<Cliente>();

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT C.ID, C.CPF, C.NOME, C.SOBRENOME FROM CLIENTE C WHERE C.ID =" + idCliente);

            while (rs.next()) {
                cliente = (new Cliente(
                        rs.getInt("ID"),
                        rs.getString("CPF"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME")
                ));

                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public boolean TemPedidoRealizado(String cpf) {         
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();    
            int lastId = 0;

            st = conexao.createStatement();
            rs = st.executeQuery("select p.ID from cliente cli "
                            + " inner join pedido p on "
                            + " cli.id = p.id "
                            + " where cli.CPF = '" + cpf.trim() + "'");

            while (rs.next()) {
                lastId = rs.getInt(1);
            };

            return lastId != 0;
        } catch (Exception e) {
            ConexaoMySQL.FecharConexao();
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }
}
