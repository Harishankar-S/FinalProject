public class Music extends Media
{
	private String artist;
	private String genre;
	
	public Music(String title, String artist, int year, String genre)
	{
		super(title, year);
		setArtist(artist);
		setYear(year);
		setGenre(genre);
	}

	
	public String getArtist() {return this.artist;}
	public String getGenre() {return this.genre;}


	public void setArtist(String artist) throws IllegalArgumentException
	{
		if(artist.isBlank()) {throw new IllegalArgumentException("Artist cannot be blank.");}
		this.artist = artist;
	}

	public void setGenre(String genre) throws IllegalArgumentException
	{
		if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
		this.genre = genre;
	}

	@Override
	public String toString()
	{
		return String.format("Music: [Title: %s, Artist: %s, Year: %d, Genre: %s]",
				this.title, this.artist, this.year, this.genre);
	}
}
