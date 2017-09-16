package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private int id;
	private String data;
	private Cliente cliente;
	private ArrayList<ItemDoPedido> itens;
	
	public Pedido(int id, String data, Cliente cliente, ArrayList<ItemDoPedido> itens) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemDoPedido> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemDoPedido> itens) {
		this.itens = itens;
	}
	
}
