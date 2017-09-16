package model;

public class Produto {
	
	private int id;
	private String descricao;
	
	public Produto(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
        
        public Produto(String descricao) {
		super();
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    @Override
    public String toString() {
        return "-- Produto[ " + " Código: " + id + ", Descricao: " + descricao + ", ";
    }
}
