package controller;

import dao.ClienteDAO;
import java.util.ArrayList;
import model.Cliente;

public class ClienteController {

    ClienteDAO clienteDao;
    Cliente cliente;

    public Cliente Buscar(String cpf) throws Exception {
        clienteDao = new ClienteDAO();
        return clienteDao.Buscar(cpf);
    }

    public boolean Gravar(String cpf, String nome, String sobrenome) throws Exception {        
        cliente = new Cliente(cpf, nome, sobrenome);        
        clienteDao = new ClienteDAO();
        return clienteDao.Gravar(cliente);
    }

    public boolean Excluir(String cpf) throws Exception {
        
        if(TemPedidoRealizado(cpf))
            throw new Exception("Não é possivel excluir o cliente devido o mesmo já possui um pedido efetuado.");
        
        clienteDao = new ClienteDAO();
        return clienteDao.Excluir(cpf);
    }

    public boolean Alterar(int id, String cpf, String nome, String sobrenome) throws Exception {
        clienteDao = new ClienteDAO();        
        cliente = new Cliente(id, cpf, nome, sobrenome);
        return clienteDao.Alterar(cliente);
    }

    public ArrayList<Cliente> BuscarTodos() throws Exception {
        clienteDao = new ClienteDAO();
        return clienteDao.BuscarTodos();        
    }

    public ArrayList<Cliente> BuscarTodos(int idCliente) throws Exception {
        clienteDao = new ClienteDAO();
        return clienteDao.BuscarTodos(idCliente);        
    }
    
    private boolean TemPedidoRealizado(String cpf) throws Exception
    {
        clienteDao = new ClienteDAO();
        return clienteDao.TemPedidoRealizado(cpf); 
    }
    
    public static String cpfFormatado(String cpf)
    {
        return cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
    }
}
