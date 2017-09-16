package model;

public class ItemDoPedido {
	
    private int idItem;
    private int quantidade;
    private Produto produto;

     public ItemDoPedido(int quantidade, Produto produto) {        
        this.quantidade = quantidade;
        this.produto = produto;
    }
        
    public ItemDoPedido(int idItem, int quantidade, Produto produto) {
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
