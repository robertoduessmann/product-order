
package controller;

import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Thiago
 */
public class ProdutoController {

    Produto produto;

    public boolean Gravar(String descricao) throws Exception {

        produto = new Produto(descricao);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Gravar(produto);

    }

    public boolean Alterar(int id, String descricao) throws Exception {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produto = new Produto(id, descricao);

        return produtoDAO.Alterar(produto);

    }

    public boolean Excluir(int id) throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Excluir(id);
    }

    public Produto Buscar(int id) throws Exception {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Buscar(id);

    }
    
    public Produto Buscar(String descricao) throws Exception {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Buscar(descricao);

    }

    public ArrayList<Produto> BuscarTodos() throws Exception {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.BuscarTodos();

    }

}
