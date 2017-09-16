package dao;

import database.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Thiago
 */
public class ProdutoDAO {

    Connection conexao;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Produto produto;
    ArrayList<Produto> listaProdutos;

    public boolean Gravar(Produto produto) {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            pst = conexao.prepareStatement("INSERT INTO PRODUTO (DESCRICAO) VALUES (?);");
            pst.setString(1, produto.getDescricao());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public boolean Alterar(Produto produto) {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            pst = conexao.prepareStatement("UPDATE PRODUTO SET DESCRICAO = ? WHERE ID = ?;");
            pst.setString(1, produto.getDescricao());
            pst.setInt(2, produto.getId());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            ConexaoMySQL.FecharConexao();
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public boolean Excluir(Integer id) {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            pst = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?;");
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            ConexaoMySQL.FecharConexao();
            return false;
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public Produto Buscar(int id) throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            produto = null;

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT P.ID, P.DESCRICAO FROM PRODUTO P"
                    + " WHERE P.ID = " + id);

            while (rs.next()) {
                produto = (new Produto(
                        rs.getInt("ID"),
                        rs.getString("DESCRICAO")
                ));
            }
            return produto;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public Produto Buscar(String descricao) throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            produto = null;

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT P.ID, P.DESCRICAO FROM PRODUTO P"
                    + " WHERE P.DESCRICAO LIKE '%" + descricao + "%'");

            while (rs.next()) {
                produto = (new Produto(
                        rs.getInt("ID"),
                        rs.getString("DESCRICAO")
                ));
            }
            return produto;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public ArrayList<Produto> BuscarTodos() throws Exception {
        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            listaProdutos = new ArrayList<Produto>();
            produto = null;

            st = conexao.createStatement();
            rs = st.executeQuery("SELECT P.ID, P.DESCRICAO FROM PRODUTO P");

            while (rs.next()) {
                produto = (new Produto(
                        rs.getInt("ID"),
                        rs.getString("DESCRICAO")
                ));
                listaProdutos.add(produto);
            }

            return listaProdutos;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }
}
