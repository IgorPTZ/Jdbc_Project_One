package jdbc_project_one.jdbc_project_one;

import java.util.List;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Telefone;
import model.Usuario;
import model.UsuarioTelefone;

public class TesteJdbc {
	
	@Test
	public void inserir() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = new Usuario(null, "Reinaldo dos Santos Pereira", "reinaldo.pereira@hotmail.com");
		
		usuarioDao.inserir(usuario);
	}
	
	@Test
	public void inserirTelefone() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Telefone telefone = new Telefone("71996998989", "Fixo", 6L);
		
		usuarioDao.inserirTelefone(telefone);
	}
	
	
	@Test
	public void obter() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.obter(1L);
		
		System.out.println(usuario);
	}
	
	@Test
	public void listarUsuarios() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		List<Usuario> usuarios = usuarioDao.listar();
		
		for(Usuario usuario : usuarios) {
			
			System.out.println(usuario);
			
			System.out.println("---------------------------------------------------------");
		}
	}
	
	@Test
	public void listarDados() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		List<UsuarioTelefone> dados = usuarioDao.listar(1L);
		
		for(UsuarioTelefone dado : dados) {
			
			System.out.println(dado);
			
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
	
	@Test
	public void excluirTelefones() {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		usuarioDao.excluirTelefones(6L);
	}
}
