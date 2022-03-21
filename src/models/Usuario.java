package models;

public class Usuario {
	
	//Propiedades
	protected String usuario;
	protected String password;
	
	//Constructor
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	
	//Getters y setters
	public String getUsuario() {
		return usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	
}
