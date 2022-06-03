package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.Pontuacao;
import connection.ConnectionDB;

public class Pontuacao_DB {

	
	public void inserir( Pontuacao pontuacao) {
		
		try {
			
			Connection connection = ConnectionDB.getInstance().getConnection();	
			
			String sql = "INSERT INTO tb_pontuacao( pontos_pontuacao) VALUES(?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, pontuacao.getPontos());
			
			
			statement.execute();
			connection.close();
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
	public void remover ( int idpontuacao) {
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "DELETE FROM tb_pontuacao WHERE id_pontuacao = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idpontuacao);
			
			statement.execute();
			statement.close();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<Pontuacao> listarTodos() {
		List<Pontuacao> listaPontuacao = new ArrayList<Pontuacao>();
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM tb_pontuacao";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				Pontuacao pontuacao = new Pontuacao();
				pontuacao.setId_pontuacao(resultset.getInt("id_pontuacao"));
				pontuacao.setPontos(resultset.getInt("pontos_pontuacao"));
				
				listaPontuacao.add(pontuacao);
				
			}
			connection.close();
			
			
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
		return listaPontuacao;
				
	}
	
	
	public void atualizar(Pontuacao pontuacao) {
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			                       //tabela   coloca a coluna ( novo valor)      especifica id
			String sql = "UPDATE tb_pontuacao SET pontos = ? WHERE id_pontuacao = ?";
			
			//criamos o statement para fazer a ponte 
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//setamos o nome que vai ser alterado e id
			statement.setInt(1, pontuacao.getPontos());
			statement.setInt(2, pontuacao.getId_pontuacao());
			
			statement.execute();
			statement.close();
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}//fim
