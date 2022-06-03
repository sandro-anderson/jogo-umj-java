package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.Jogador;
import DAO.Pontuacao;
import connection.ConnectionDB;

//pacote e classe para inserir , modificar etc. faz a comunicacao com o banco de dadsos
public class Jogador_DB {

	public void inserir(Jogador jogador) {

		try {
			
		Connection connection = ConnectionDB.getInstance().getConnection();

		                  //                     1             2           3           4           5          6              7             8                    9
		String sql = "INSERT INTO tb_jogador (nome_jogador,cpf_jogador,nasc_jogador,sexo_jogador,email_jogador,cell_jogador, nick_name_jogador, senha_jogador)  VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		//eçe faz a ponte de ir la e buscar algum resultado
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, jogador.getNome());
		statement.setString(2, jogador.getCpf());
		statement.setString(3, jogador.getNasc());
		statement.setString(4, jogador.getSexo());
		statement.setString(5, jogador.getEmail());
		statement.setString(6, jogador.getCell());
		statement.setString(7, jogador.getNick_name());
		statement.setInt(8, jogador.getSenha());
		
		statement.execute();
		//System.out.println("inserido com sucesso");
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public void remover(int idjogador ) {
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "DELETE FROM tb_jogador WHERE id_jogador = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idjogador);
			
			statement.execute();
			statement.close();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//guarda em um arrayList tudo que esta nas tabelas para ser exibido 
	public List<Jogador> listarTodos() {
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM tb_jogador";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				Jogador jogador = new Jogador();
				jogador.setId_jogador(resultset.getInt("id_jogador"));
				jogador.setNome(resultset.getString("nome_jogador"));
				jogador.setCpf(resultset.getString("cpf_jogador"));
				jogador.setNasc(resultset.getString("nasc_jogador"));
				jogador.setSexo(resultset.getString("sexo_jogador"));
				jogador.setEmail(resultset.getString("email_jogador"));
				jogador.setCell(resultset.getString("cell_jogador"));
				jogador.setNick_name(resultset.getString("nick_name_jogador"));
				jogador.setSenha(resultset.getInt("senha_jogador"));
							
				listaJogador.add(jogador);
			}
			connection.close();
			
			
		}catch ( Exception e) {
			
		}
		
		return listaJogador;
		
		
	}//fim listar
	
	public void atualizar(Jogador jogador ) {
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			                       //tabela   coloca a coluna ( novo valor)      especifica id
			String sql = "UPDATE tb_jogador SET nome_jogador = ? WHERE id_jogador = ?";
			
			//criamos o statement para fazer a ponte 
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//setamos o nome que vai ser alterado e id
			statement.setString(1, jogador.getNome());
			statement.setInt(2, jogador.getId_jogador());
			
			statement.execute();
			statement.close();
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public List<Jogador> listarLogin() {
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "SELECT id_jogador, cpf_jogador,  nick_name_jogador, senha_jogador FROM tb_jogador";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				Jogador jogador = new Jogador();
				jogador.setId_jogador(resultset.getInt("id_jogador"));
				jogador.setCpf(resultset.getString("cpf_jogador"));
				jogador.setNick_name(resultset.getString("nick_name_jogador"));
				jogador.setSenha(resultset.getInt("senha_jogador"));
							
				listaJogador.add(jogador);
			}
			connection.close();
			
			
		}catch ( Exception e) {
			
		}
		
		return listaJogador;
		
		
	}//fim listar
	
	
	public void inserirAtual(int id, int pontos) {

		try {
			
		Connection connection = ConnectionDB.getInstance().getConnection();

		                  //                     1             2           
		String sql = "INSERT INTO atual_jogador VALUES(?, ?)";
		//eçe faz a ponte de ir la e buscar algum resultado
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, id );
		statement.setInt(2, pontos );
		
		statement.execute();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	
	
	public void deleteAtual() {
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "TRUNCATE TABLE atual_jogador";
			
			PreparedStatement statement = connection.prepareStatement(sql);
						
			statement.execute();
			statement.close();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Integer> listarAtual() {
		List<Integer> listaPontuacao = new ArrayList<Integer>();
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM atual_jogador";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery(sql);
			int x, y;
			while(resultset.next()) {
				Pontuacao pontuacao = new Pontuacao();
				pontuacao.setId_pontuacao(resultset.getInt("id_atual"));
				pontuacao.setPontos(resultset.getInt("pontos_atual"));
				x = resultset.getInt("id_atual");
				y = resultset.getInt("pontos_atual");
				
				listaPontuacao.add(x);
				listaPontuacao.add(y);
				
			}
			connection.close();
			
			
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
		return listaPontuacao;
				
	}
	
	
	
	public void AtualizarPontos(int pontos, int id) {

		try {
			
		Connection connection = ConnectionDB.getInstance().getConnection();

		                  //                     1             2           
		String sql = "UPDATE tb_pontuacao set pontos_pontuacao = ? where id_pontuacao = ?";
		//eçe faz a ponte de ir la e buscar algum resultado
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, pontos );
		statement.setInt(2, id );
		
		statement.execute();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Jogador jogador = new Jogador();
		jogador.setNome("Alisson");
		jogador.setCpf("12345678978");
		jogador.setNasc("12121212");
		jogador.setSexo("M");
		jogador.setEmail("sandor@sandor.com");
		jogador.setCell("(82)9585854578");
		jogador.setNick_name("nick");
		jogador.setSenha(1234); 
		
		Jogador_DB jogadorD = new Jogador_DB();
		
		//jogadorD.inserir(jogador);
		
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		
		listaJogador = jogadorD.listarTodos();
		
		
		System.out.println("ok");
		System.out.println(listaJogador.size());
		for( int i = 0; i < listaJogador.size() ; i++) {
			System.out.println(listaJogador.get(i));
			System.out.println(listaJogador.get(i).getId_jogador());
			System.out.println(listaJogador.get(i).getCpf());
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}







/*
 * 
 * `id_jogador` INT(3) NOT NULL, 
 * `nome_jogador` VARCHAR(45) NOT NULL,
 * `cpf_jogador` VARCHAR(11) NOT NULL, 
 * `nasc_jogador` DATE NOT NULL,
 * `sexo_jogador` VARCHAR(1) NOT NULL, 
 * `email_jogador` VARCHAR(50) NOT NULL,
 * `cell_jogador` VARCHAR(15) NOT NULL, 
 * `id_endereco` INT(3) NOT NULL,
 * `id_pontuacao`
 * nick_name_jogador
 * senha_jogador
 * 
 */