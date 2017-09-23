package controller;

import dao.ParametroGeralDAO;
import java.util.HashMap;
import java.util.Map;
import model.ParametroGeral;

/**
 *
 * @author Thiago
 */
public class ParametroGeralController {

    Map<String, String> map = new HashMap<String, String>();

    public boolean CriarArquivoConexao(String servidorBanco, String nomeBanco, String usuarioBanco, String senhaBanco) throws Exception {

        try {
            ParametroGeral pg = new ParametroGeral();
            return pg.CriarArquivo(servidorBanco, nomeBanco, usuarioBanco, senhaBanco);
        } catch (Exception e) {
            return false;
        }
    }

    public Map<String, String> Ler() {
        try {
            ParametroGeral pg = new ParametroGeral();
            return pg.Ler();
        } catch (Exception e) {
            return null;
        }
    }

    public void CriarTabelas(String banco) throws Exception {

        try {
            ParametroGeralDAO pgDAO = new ParametroGeralDAO();

            if (pgDAO.EhCriarTabela(banco, "CLIENTE")) {
                pgDAO.CriaTabelaCliente();
            }

            if (pgDAO.EhCriarTabela(banco, "PRODUTO")) {
                pgDAO.CriaTabelaProduto();
            }

            if (pgDAO.EhCriarTabela(banco, "PEDIDO")) {
                pgDAO.CriaTabelaPedido();
            }

            if (pgDAO.EhCriarTabela(banco, "ITEM_DO_PEDIDO")) {
                pgDAO.CriaTabelaItemPedido();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void CriarDataBase(String banco) throws Exception {
        ParametroGeralDAO pgDAO = new ParametroGeralDAO();

        if (!pgDAO.ExisteDataBase(banco)) {
            pgDAO.CriarDataBase(banco);
        }
    }
}
