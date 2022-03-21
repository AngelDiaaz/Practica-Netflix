package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Show;

public class ShowDAO extends AbstractDAO {

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

				Show s = new Show(show_id+"", type, tittle, director, cast, country, date_add, 
						release_year, rating, duration, listed_in, description);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}
	
	public void insert(Show s) {
		final String INSERT = "INSERT INTO netflix(`show_id`, `type`, `tittle`, `director`, `cast`, `country`, `date_add`, `release_year`, `rating`, `duration`, `listed_in`, `description`) " + 
				"VALUES('" + s.getId().substring(1) + "', '" + s.getType() + "', '" + s.getTitle() + "', '" + s.getDirector() + "', '" + s.getCast() + "', '" + s.getCountry() + "', '" + s.getDate() +
				"', '" + s.getYear() + "', '" + s.getRating() + "', '" + s.getDuration() + "', '" + s.getListed() + "', '" + s.getDescription() + "');";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
