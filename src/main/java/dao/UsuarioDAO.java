package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
		
		conexao = SingleConnection.obterConexao();
	}
	
	public void inserir(Usuario usuario) {
		
		try {
			
			String sql = "insert into usuario (id, nome, email) values (?, ?, ?)";
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setLong(1, usuario.getId());
			
			preparedStatement.setString(2, usuario.getNome());
			
			preparedStatement.setString(3, usuario.getEmail());
			
			preparedStatement.execute();
			
			conexao.commit();
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			try {
				
				conexao.rollback();
			}
			catch(SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	public Usuario obter(Long id) {
		
		try {
			Usuario usuario = null;
			
			String sql = "select * from usuario where id =" + id;
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				usuario = new Usuario(resultSet.getLong("id"),
						              resultSet.getString("nome"),
						              resultSet.getString("email")); 
			}
			
			return usuario;
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Usuario> listar() {
		
		try {
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			String sql = "select * from usuario";
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Usuario usuario = new Usuario(resultSet.getLong("id"),
						                      resultSet.getString("nome"),
						                      resultSet.getString("email"));
				
				usuarios.add(usuario);
			}
			
			return usuarios;
		} 
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Usuario usuario) {
		
		try {
			
			String sql = "update usuario set nome = ?, email = ? where id = " + usuario.getId();
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getNome());
			
			preparedStatement.setString(2, usuario.getEmail());
			
			preparedStatement.execute();
			
			conexao.commit();	 
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			try {
				
				conexao.rollback();
			}
			catch(SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
}
