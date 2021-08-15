package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/jdbc-project-one";
	
	private static String senha = "postgres";
	
	private static String usuario = "postgres";
	
	private static Connection conexao = null;
	
	static {
		
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(conexao == null) {
				
				Class.forName("org.postgresql.Driver");
				
				conexao = DriverManager.getConnection(url, usuario, senha);
				
				conexao.setAutoCommit(false);
				
				System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection obterConexao() {
		
		return conexao;
	}
}
