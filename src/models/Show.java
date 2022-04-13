package models;

public class Show {
	//Propiedades
	private String id;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String date;
	private String year;
	private String rating;
	private String duration;
	private String listed;
	private String description;

	//Constructor
	public Show(String id, String type, String title, String director, String cast, String country, String date,
			String year, String rating, String duration, String listed, String description) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date = date;
		this.year = year;
		this.rating = rating;
		this.duration = duration;
		this.listed = listed;
		this.description = description;
	}
	
	//Getters y setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getCast() {
		return cast;
	}


	public void setCast(String cast) {
		this.cast = cast;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getListed() {
		return listed;
	}


	public void setListed(String listed) {
		this.listed = listed;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Show [id=" + id + ", type=" + type + ", title=" + title + ", director=" + director + ", cast=" + cast
				+ ", country=" + country + ", date=" + date + ", year=" + year + ", rating=" + rating + ", duration="
				+ duration + ", listed=" + listed + ", description=" + description + "]";
	}


}
