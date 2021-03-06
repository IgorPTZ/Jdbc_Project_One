package model;

public class Telefone {
	
	private Long id;
	
	private String numero;
	
	private String tipo;
	
	private Long usuarioId;
	
	public Telefone(String numero, String tipo, Long usuarioId) {
		
		this.numero = numero;
		
		this.tipo = tipo;
		
		this.usuarioId = usuarioId;
	}
	
	public Telefone(Long id, String numero, String tipo, Long usuarioId) {
		
		this.id = id;
		
		this.numero = numero;
		
		this.tipo = tipo;
		
		this.usuarioId = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
