public class TVShow extends Media implements Audible, Viewable
{
	private String director;
	private short season;
	private short episode;
	private String genre;
	
	public TVShow(String title, String director, int year, short season, short episode, String genre)
	{
		super(title, year);
		setDirector(director);
		setYear(year);
		setSeason(season);
		setEpisode(episode);
		setGenre(genre);
	}

	
	public String getDirector() {return this.director;}
	public short getSeason() {return this.season;}
	public short getEpisode() {return this.episode;}
	public String getGenre() {return this.genre;}
	

	public void setDirector(String director) throws IllegalArgumentException
	{
		if(director.isBlank()) {throw new IllegalArgumentException("Director cannot be blank.");}
		this.director = director;
	}

	public void setSeason(short season) throws IllegalArgumentException
	{
		if(season < 1) {throw new IllegalArgumentException("Season cannot be less than 1.");}
		this.season = season;
	}

	public void setEpisode(short episode) throws IllegalArgumentException
	{
		if(episode < 1) {throw new IllegalArgumentException("Episode cannot be less than 1.");}
		this.episode = episode;
	}

	public void setGenre(String genre) throws IllegalArgumentException
	{
		if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
		this.genre = genre;
	}

	@Override
	public String toString()
	{
		return String.format("TV Show: [Title: %s, Director: %s, Year: %d, Season: %d, Episode: %d, Genre: %s]",
				this.title, this.director, this.year, this.season, this.episode, this.genre);
	}
}
