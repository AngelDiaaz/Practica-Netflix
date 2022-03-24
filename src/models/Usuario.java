package models;

public class Usuario {
	
	//Propiedades
	protected String usuario;
	protected String password;
	protected String email;
	
	//Constructor
	public Usuario(String usuario, String password, String email) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
	}
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", email=" + email + "]";
	}

}
