package database;

import controller.ParametroGeralController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConexaoMySQL {

    public static String status = "Nao conectou...";
    public static ParametroGeralController parametoController;
    private static String _serverName = null;
    private static String _mydatabase = null;
    private static String _username = null;
    private static String _password = null;

    private static Map<String, String> map = new HashMap<String, String>();

    public ConexaoMySQL() {
        RecuperarParametrizacao();
    }

    private static void RecuperarParametrizacao() {
        parametoController = new ParametroGeralController();

        map = parametoController.Ler();
        _serverName = map.get("SERVIDOR");
        _mydatabase = map.get("BANCO");
        _username = map.get("USUARIO");
        _password = map.get("SENHA");
    }

    public static java.sql.Connection getConexaoMySQL() throws Exception {
        try {

            Connection connection = null;

            //Carregando o JDBC Driver padr�o
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);
            RecuperarParametrizacao();

            //Configurando a nossa conex�o com um banco de dados//
            String serverName = _serverName; //"localhost"; //caminho do servidor do BD
            String mydatabase = _mydatabase;//"sistemapedidos"; //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";

            String username = _username; //"PRONIM"; //nome de um usu�rio de seu BD
            String password = _password; //"PRO2010nim"; //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);

//             //Configurando a nossa conex�o com um banco de dados//
//            String serverName = parametoController.Ler(1); //"localhost"; //caminho do servidor do BD
//            String mydatabase = parametoController.Ler(2);//"sistemapedidos"; //nome do seu banco de dados
//            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";
//
//            String username = parametoController.Ler(3); //"PRONIM"; //nome de um usu�rio de seu BD
//            String password = parametoController.Ler(4); //"PRO2010nim"; //sua senha de acesso
//            connection = DriverManager.getConnection(url, username, password);
//            
//            String serverName = "localhost"; //caminho do servidor do BD
//            String mydatabase = "sistemapedidos"; //nome do seu banco de dados
//            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";
//
//            String username = "PRONIM"; //nome de um usu�rio de seu BD
//            String password = "PRO2010nim"; //sua senha de acesso
//            connection = DriverManager.getConnection(url, username, password);
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
            System.out.println("Nao foi possivel conectar ao Banco de Dados." + e.toString());
            throw new Exception("Nao foi possivel conectar ao Banco de Dados." + e.toString());
        }
    }

    //M�todo que retorna o status da sua conex�o//
    public static String statusConection() {
        return status;
    }

    //M�todo que fecha sua conex�o//
    public static boolean FecharConexao() throws Exception {

        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    //M�todo que reinicia sua conex�o//
    public static java.sql.Connection ReiniciarConexao() throws Exception {
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
}
