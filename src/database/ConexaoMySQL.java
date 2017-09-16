package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    public static String status = "Nao conectou...";

    public ConexaoMySQL() {

    }

    public static java.sql.Connection getConexaoMySQL() {
        try {

            Connection connection = null;

            //Carregando o JDBC Driver padr�o
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            //Configurando a nossa conex�o com um banco de dados//
            String serverName = "localhost"; //caminho do servidor do BD
            String mydatabase = "sistemapedidos"; //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";

            String username = "PRONIM"; //nome de um usu�rio de seu BD
            String password = "PRO2010nim"; //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conex�o//
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->N�o foi possivel realizar conex�o");
            }

            System.out.println(status);

            return connection;

        } catch (ClassNotFoundException e) { //Driver n�o encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //N�o conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //M�todo que retorna o status da sua conex�o//
    public static String statusConection() {
        return status;
    }

    //M�todo que fecha sua conex�o//
    public static boolean FecharConexao() {

        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    //M�todo que reinicia sua conex�o//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
}
