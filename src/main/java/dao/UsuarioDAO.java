package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.Usuario;
import model.UsuarioTelefone;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
		
		conexao = SingleConnection.obterConexao();
	}
	
	public void inserir(Usuario usuario) {
		
		try {
			
			String sql = "insert into usuario (nome, email) values (?, ?)";
			
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
	
	public void inserirTelefone(Telefone telefone) {
		
		try {
			
			String sql = "insert into telefone(numero, tipo, usuario_id) values (?, ?, ?)";
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setString(1, telefone.getNumero());
			
			preparedStatement.setString(2, telefone.getTipo());
			
			preparedStatement.setLong(3, telefone.getUsuarioId());
			
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
	
	public List<UsuarioTelefone> listar(Long usuarioId) {
		
		try {
			
			List<UsuarioTelefone> dados = new ArrayList<UsuarioTelefone>();
			
			String sql = " select nome, email, numero from telefone as t inner join usuario as u on t.usuario_id = u.id where u.id = " + usuarioId;
		
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				UsuarioTelefone usuarioTelefone = new UsuarioTelefone(resultSet.getString("nome"),
						                                              resultSet.getString("email"),
						                                              resultSet.getString("numero"));
				
				dados.add(usuarioTelefone);
			}
			
			return dados;
		}
		catch (Exception e) {
			
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
	
	public void excluir(Long id) {
		
		try {
			
			String sql = "delete from usuario where id = " + id;
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
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
	
	public void excluirTelefones(Long usuarioId) {
		
		try {
			
			String sql = "delete from telefone where usuario_id = " + usuarioId;
			
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.executeUpdate();
			
			conexao.commit();
			
			this.excluir(usuarioId);
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
