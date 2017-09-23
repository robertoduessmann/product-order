/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thiago
 */
public class ParametroGeralDAO {

    Connection conexao;
    PreparedStatement pst;
    Statement st;

    public boolean ExisteDataBase(String banco) throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            int resultado = 0;

            st = conexao.createStatement();
            ResultSet rs = st
                    .executeQuery("SELECT count(*) as Resultado FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '" + banco.trim() + "';");
            while (rs.next()) {
                resultado = rs.getInt("Resultado");
            }

            return resultado > 0;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }
    
    public boolean EhCriarTabela(String banco, String tabela) throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            int resultado = 0;

            st = conexao.createStatement();
            ResultSet rs = st
                    .executeQuery("SELECT count(*) as Resultado FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '" + banco.trim() + "' and  table_name = '" + tabela.trim() + "' ;");
            while (rs.next()) {
                resultado = rs.getInt("Resultado");
            }

            return resultado == 0;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public void CriaTabelaCliente() throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            st = conexao.createStatement();
            st.execute(
                    " CREATE TABLE CLIENTE ( "
                    + " ID  	  INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + " CPF 	  VARCHAR(15) NOT NULL,"
                    + " NOME 	  VARCHAR(30) NOT NULL,"
                    + " SOBRENOME VARCHAR(50) NOT NULL);");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public void CriaTabelaProduto() throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            st = conexao.createStatement();
            st.execute(
                    " CREATE TABLE PRODUTO ( "
                    + " ID  	  INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + " DESCRICAO VARCHAR(45) NOT NULL);");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public void CriaTabelaPedido() throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            st = conexao.createStatement();
            st.execute(
                    " CREATE TABLE PEDIDO ( "
                    + " ID  	   INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + " DATA 	   VARCHAR(10) NOT NULL, "
                    + " ID_CLIENTE INT NOT NULL,  "
                    + " CONSTRAINT FK_PEDIDO_CLIENTE FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID) );");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public void CriaTabelaItemPedido() throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            st = conexao.createStatement();
            st.execute(
                    " CREATE TABLE ITEM_DO_PEDIDO ( "
                    + " ID  	   INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + " ID_PEDIDO       INT NOT NULL, "
                    + " ID_PRODUTO      INT NOT NULL,  "
                    + " QUANTIDADE  	INT(11) NOT NULL ,  "
                    + " CONSTRAINT FK_ITEM_DO_PEDIDO_PEDIDO  FOREIGN KEY(ID_PEDIDO) REFERENCES PEDIDO (ID) ,"
                    + "CONSTRAINT FK_ITEM_DO_PEDIDO_PRODUTO  FOREIGN KEY(ID_PRODUTO) REFERENCES PRODUTO(ID) );");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

    public void CriarDataBase(String banco) throws Exception {

        try {
            conexao = ConexaoMySQL.getConexaoMySQL();
            st = conexao.createStatement();
            st.execute("CREATE DATABASE " + banco);

        } catch (Exception e) {
        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }
}
