package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.Endereco;

import connection.ConnectionDB;

public class Endereco_DB {
	
	public void inserir (Endereco endereco ) {
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			                     //                  1            2             3           4              5                6               
			String sql = "INSERT INTO tb_endereco (cep_endereco, nu_endereco, end_endereco, bairro_endereco, cidade_endereco, estado_endereco)  VALUES ( ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, endereco.getCep());
			statement.setString(2, endereco.getNum());
			statement.setString(3, endereco.getEnd());
			statement.setString(4, endereco.getBairro());
			statement.setString(5, endereco.getCidade());
			statement.setString(6, endereco.getEstado());
			
			
			statement.execute();
			statement.close();
			
			
			
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
	} //acaba o inserir
	
	
	
	public void remover(int idendereco) {
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "DELETE FROM tb_endereco WHERE id_endereco = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idendereco);
			
			statement.execute();
			statement.close();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
		
	} // acaba o remover
	
	public List<Endereco> listarTodos() {
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		try {
			
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM tb_endereco";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setId_endereco(resultset.getInt("id_endereco"));
				endereco.setCep(resultset.getString("cep_endereco"));
				endereco.setNum(resultset.getString("nu_endereco"));
				endereco.setEnd(resultset.getString("end_endereco"));
				endereco.setBairro(resultset.getString("bairro_endereco"));
				endereco.setCidade(resultset.getString("cidade_endereco"));
				endereco.setEstado(resultset.getString("estado_endereco"));
				
				listaEndereco.add(endereco);
			}
			connection.close();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaEndereco;
		
		
		
	} // acaba o listar
	
	
	public void atualizar(Endereco endereco) {
		
		try {
			Connection connection = ConnectionDB.getInstance().getConnection();
			
			                       //tabela   coloca a coluna ( novo valor)      especifica id
			String sql = "UPDATE tb_endereco SET end_endereco = ? WHERE id_endereco = ?";
			
			//criamos o statement para fazer a ponte 
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//setamos o nome que vai ser alterado e id
			statement.setString(1, endereco.getEnd());
			statement.setInt(2, endereco.getId_endereco());
			
			statement.execute();
			statement.close();
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		/*
		Jogador jogador = new Jogador();
		jogador.setNome("Alisson");
		jogador.setCpf("12345678978");
		jogador.setNasc("12121212");
		jogador.setSexo("M");
		jogador.setEmail("sandor@sandor.com");
		jogador.setCell("(82)9585854578");
		jogador.setNick_name("nick");
		jogador.setSenha(1234); */
		
		//Jogador_DB jogadorD = new Jogador_DB();
		Endereco_DB enderecoD = new Endereco_DB();
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		//jogadorD.inserir(jogador);
		
		
		//List<Endereco> listaJogador = new ArrayList<Endereco>();
		
		listaEndereco = enderecoD.listarTodos();
		
		System.out.println("ok");
		System.out.println(listaEndereco.size());
		
		for( int i = 0; i < listaEndereco.size() ; i++) {
			System.out.println(listaEndereco.get(i));
			System.out.println(listaEndereco.get(i).getBairro());
			System.out.println(listaEndereco.get(i).getCep());
			System.out.println(listaEndereco.get(i).getCidade()      );
			System.out.println(listaEndereco.get(i).getEstado()      );
			System.out.println(listaEndereco.get(i).getEnd()      );
			System.out.println(listaEndereco.get(i).getNum()      );

		}
		
	}//fim main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
