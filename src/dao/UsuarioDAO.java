package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO{
	
	/**
	 * Saca todo los usuarios y contraseñas de la base de datos
	 */

	public void consulta() {
		final String QUERY = "SELECT usuario, password FROM usuarios";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				System.out.print("Usuario: " + rs.getString("usuario"));
				System.out.println(", Password: " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Busca en la base de datos el usuario y la contraseña si pertenece a ese usuario
	 * @param usuario Que queremos buscar en la base de datos
	 * @return True si lo ha encontrado y false si no lo ha hecho
	 */

	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT usuario, password FROM usuarios " + "where usuario = '" + usuario.getUsuario()
				+ "' and " + "password = '" + usuario.getPassword() + "'";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Añade y registra un usuario y su contraseña en la base de datos
	 * @param usuario Usuario que queremos añadir a la base de datos
	 * @return True si el nombre del usuario no estra registrado y false si lo esta
	 */

	public boolean registrar(Usuario usuario) {

		final String INSERT = "INSERT INTO usuarios (usuario,password)" + " VALUES ('" + usuario.getUsuario() + "','"
				+ usuario.getPassword() + "');";
		try {
			stmt.executeUpdate(INSERT);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"El usuario " + usuario.getUsuario() + " ya esta registrado, prueba con otro usuario");
			return false;
		}
	}

}
