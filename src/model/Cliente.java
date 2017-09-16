package model;

public class Cliente {
	
	private int id;
	private String cpf;
	private String nome;
	private String sobreNome;
	
	public Cliente(int id, String cpf, String nome, String sobreNome) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}
        
        public Cliente(String cpf, String nome, String sobreNome) {
		super();		
		this.cpf = cpf;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}	

}
