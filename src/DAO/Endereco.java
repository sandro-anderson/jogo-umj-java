package DAO;

public class Endereco {

	private int id_endereco;
	private String cep;
	private String num;
	private String end;
	private String bairro;
	private String cidade;
	private String estado;
	

	
	public int getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public String toString() {
		
		return getId_endereco() + " " + getCep() + " " + getNum() + " " + getEnd() + " " + getBairro() + " " + getCidade() + " " + getEstado();
		
		
	}
	
	
	
	
}
