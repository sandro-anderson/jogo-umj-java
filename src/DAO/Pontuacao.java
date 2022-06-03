package DAO;

public class Pontuacao {

	
	private int id_pontuacao;
	private int pontos;
	
	
	
	public int getId_pontuacao() {
		return id_pontuacao;
	}
	public void setId_pontuacao(int id_pontuacao) {
		this.id_pontuacao = id_pontuacao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	public String toString() {
		
		return getId_pontuacao() + " " + getPontos();
	}
	
	
	
}
