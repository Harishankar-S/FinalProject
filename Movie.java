public class Movie extends Media implements Audible, Viewable
{
	private String director;
	private String genre;
	
	public Movie(String title, String director, int year, String genre)
	{
		super(title, year);
		setDirector(director);
		setYear(year);
		setGenre(genre);
	}

	
	public String getDirector() {return this.director;}
	public String getGenre() {return this.genre;}


	public void setDirector(String director) throws IllegalArgumentException
	{
		if(director.isBlank()) {throw new IllegalArgumentException("Director cannot be blank.");}
		this.director = director;
	}

	public void setGenre(String genre) throws IllegalArgumentException
	{
		if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
		this.genre = genre;
	}

	@Override
	public String toString()
	{
		return String.format("Movie: [Title: %s, Director: %s, Year: %d, Genre: %s]",
				this.title, this.director, this.year, this.genre);
	}
}
