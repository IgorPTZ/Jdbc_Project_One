package jdbc_project_one.jdbc_project_one;

import java.util.List;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Usuario;

public class TesteJdbc {
	
	@Test
	public void inserir() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = new Usuario(null, "Maria dos Santos Pereira", "maria.pereira@hotmail.com");
		
		usuarioDao.inserir(usuario);
	}
	
	
	@Test
	public void obter() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.obter(1L);
		
		System.out.println(usuario);
	}
	
	@Test
	public void listar() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		List<Usuario> usuarios = usuarioDao.listar();
		
		for(Usuario usuario : usuarios) {
			
			System.out.println(usuario);
			
			System.out.println("---------------------------------------------------------");
		}
	}
	
	@Test
	public void alterar() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.obter(1L);
		
		usuario.setEmail("igor.ptz@hotmail.com");
		
		usuarioDao.alterar(usuario);
	}
	
	@Test
	public void excluir() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		usuarioDao.excluir(5L);
	}
}
