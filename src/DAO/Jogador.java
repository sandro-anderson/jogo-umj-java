package DAO;


public class Jogador {
	private int id_jogador;
	private String nome;
	private String cpf;
	private String nasc;
	private String sexo;
	private String email;
	private String cell;
	private String nick_name;
	private int senha;
	
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
	
	public int getId_jogador() {
		return id_jogador;
	}
	public void setId_jogador(int id_jogador) {
		this.id_jogador = id_jogador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNasc() {
		return nasc;
	}
	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	
	
	
	
	public String toString() {
		return getId_jogador() + " " + getNome() + " " + getCpf() + " " + getNasc() + " " + getSexo() + " " + getEmail() + " " + getCell() + " " + getNick_name() + " " + getSenha();
		
	}
	
	
	
}
