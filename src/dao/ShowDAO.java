package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Show;

public class ShowDAO extends AbstractDAO {

	/**
	 * Saca todos los shows de la base de datos y lo almacena en un array list
	 * 
	 * @return Devuelve un array list con todos los shows de la base de datos
	 */

	public ArrayList<Show> getAll() {
		final String QUERY = "SELECT show_id, type, tittle, director, cast, country, date_add, release_year, rating, duration, listed_in, description "
				+ "FROM netflix";
		var shows = new ArrayList<Show>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var show_id = rs.getInt("show_id");
				var type = rs.getString("type");
				var tittle = rs.getString("tittle");
				var director = rs.getString("director");
				var cast = rs.getString("cast");
				var country = rs.getString("country");
				var date_add = rs.getString("date_add");
				var release_year = rs.getString("release_year");
				var rating = rs.getString("rating");
				var duration = rs.getString("duration");
				var listed_in = rs.getString("listed_in");
				var description = rs.getString("description");

				Show s = new Show(show_id + "", type, tittle, director, cast, country, date_add, release_year, rating,
						duration, listed_in, description);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	/**
	 * Inserta un show en la base de datos
	 * 
	 * @param s Show que quieres insertar
	 */

	public void insert(Show s) {
		final String INSERT = "INSERT INTO netflix(`show_id`, `type`, `tittle`, `director`, `cast`, `country`, `date_add`, `release_year`, `rating`, `duration`, `listed_in`, `description`) "
				+ "VALUES('" + s.getId().substring(1) + "', '" + s.getType() + "', '" + s.getTitle() + "', '"
				+ s.getDirector() + "', '" + s.getCast() + "', '" + s.getCountry() + "', '" + s.getDate() + "', '"
				+ s.getYear() + "', '" + s.getRating() + "', '" + s.getDuration() + "', '" + s.getListed() + "', '"
				+ s.getDescription() + "');";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene los shows de la base de datos a traves de la consulta
	 * 
	 * @param consultar Consulta por la que queremos buscar el show en la base de
	 *                  datos
	 * @param text      Texto de la consulta que queremos hacer
	 * @return Array list con todos los shows de la consulta
	 */

	public ArrayList<Show> search(String consultar, String text) {
		final String SELECT = "SELECT * FROM netflix where " + consultar + " LIKE '%" + text + "%';";

		var shows = new ArrayList<Show>();

		try {
			ResultSet rs = stmt.executeQuery(SELECT);
			while (rs.next()) {
				var show_id = rs.getInt("show_id");
				var type = rs.getString("type");
				var tittle = rs.getString("tittle");
				var director = rs.getString("director");
				var cast = rs.getString("cast");
				var country = rs.getString("country");
				var date_add = rs.getString("date_add");
				var release_year = rs.getString("release_year");
				var rating = rs.getString("rating");
				var duration = rs.getString("duration");
				var listed_in = rs.getString("listed_in");
				var description = rs.getString("description");

				Show s = new Show(show_id + "", type, tittle, director, cast, country, date_add, release_year, rating,
						duration, listed_in, description);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}
	
	/**
	 * Busca un show a traves de la id en la base de datos
	 * @param id Id del show al que queremos buscar
	 * @return Show que tiene el id que hemos buscado
	 */

	public Show consulta(String id) {
		final String SELECT = "SELECT * FROM netflix where show_id = '" + id + "';";

		try {
			ResultSet rs = stmt.executeQuery(SELECT);
			while (rs.next()) {
				var show_id = rs.getInt("show_id");
				var type = rs.getString("type");
				var tittle = rs.getString("tittle");
				var director = rs.getString("director");
				var cast = rs.getString("cast");
				var country = rs.getString("country");
				var date_add = rs.getString("date_add");
				var release_year = rs.getString("release_year");
				var rating = rs.getString("rating");
				var duration = rs.getString("duration");
				var listed_in = rs.getString("listed_in");
				var description = rs.getString("description");

				Show s = new Show(show_id + "", type, tittle, director, cast, country, date_add, release_year, rating,
						duration, listed_in, description);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
