package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static ConnectionDB conexao;
	
	
	//metodo para instanciar / restringe o obj a instanciar somente uma vez
	public static ConnectionDB getInstance() {
		if (conexao == null) {
			conexao = new ConnectionDB();
		}
		return conexao;
	}
	
	// retorna uim obj conection é o obj que vai fazer a conexão com o banco 
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jogo","root", "");
	}
	
	
	/*   public static void main (String[]args) {
		
		try {
			System.out.println(getInstance().getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	*/
	
}
