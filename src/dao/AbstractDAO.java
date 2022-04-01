package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.CredentialsHelper;

public abstract class AbstractDAO {
	private final String DB_URL = "jdbc:mysql://localhost/netflix";
	private final String USER = "user_netflix";
	private final String PASS = "P@ssw0rd";
	protected Connection conn;
	protected Statement stmt;
	
	public AbstractDAO() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
