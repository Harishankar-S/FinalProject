
import java.time.Year;

public class Music extends Media
{
   
    private String artist;
    private String genre;
    
    public Music(String title, String artist, int year, String genre)
    {
        super(title, year);
        setArtist(artist);
        setGenre(genre);
    }

    public String getTitle() {return this.title;}
    public String getArtist() {return this.artist;}
    public int getYear() {return this.year;}
    public String getGenre() {return this.genre;}

    public void setTitle(String title) throws IllegalArgumentException
    {
        if(title.isBlank()) {throw new IllegalArgumentException("Title cannot be blank.");}
    }

    public void setArtist(String artist) throws IllegalArgumentException
    {
        if(artist.isBlank()) {throw new IllegalArgumentException("Artist cannot be blank.");}
    }

    public void setYear(int year) throws IllegalArgumentException
    {
        if(year < -1400) {throw new IllegalArgumentException("Year cannot be before 1400 BCE.");}
        if(year > Year.now().getValue() + 1) {throw new IllegalArgumentException("Year cannot be in the future.");}
    }

    public void setGenre(String genre) throws IllegalArgumentException
    {
        if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
    }

    @Override
    public String toString()
    {
        return String.format("Music: [Title: %s, Artist: %s, Year: %d, Genre: %s]",
                this.title, this.artist, this.year, this.genre);
    }
}
