package jdbc_project_one.jdbc_project_one;

import java.util.List;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Usuario;

public class TesteJdbc {
	
	@Test
	public void initInserir() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = new Usuario(3L, "Maria dos Santos Pereira", "maria.pereira@hotmail.com");
		
		usuarioDao.inserir(usuario);
	}
	
	
	@Test
	public void initObter() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.obter(1L);
		
		System.out.println(usuario);
	}
	
	@Test
	public void initListar() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		List<Usuario> usuarios = usuarioDao.listar();
		
		for(Usuario usuario : usuarios) {
			
			System.out.println(usuario);
			
			System.out.println("---------------------------------------------------------");
		}
	}
	
	@Test
	public void initiAlterar() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.obter(1L);
		
		usuario.setEmail("igor.ptz@hotmail.com");
		
		usuarioDao.alterar(usuario);
	}
}
