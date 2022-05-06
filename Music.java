public class Music extends Media implements Audible
{
    private String artist;
    private String genre;
    private int rating;
    
    public Music(String title, String artist, int year, String genre, int rating)
    {
        super(title, year);
        setArtist(artist);
        setYear(year);
        setGenre(genre);
        setRating(rating);
    }

    
    public String getArtist() {return this.artist;}
    public String getGenre() {return this.genre;}
    public int getRating() {return this.rating;}

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
    
    public void setRating(int rating) 
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return String.format("Music: [Title: %s, Artist: %s, Year: %d, Genre: %s, Rating: %d]",
                this.title, this.artist, this.year, this.genre, this.rating);
    }
}
