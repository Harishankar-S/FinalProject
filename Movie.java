import java.time.Year;

public class Movie extends Media
{
    private String director;
    private String genre;
    
    public Movie(String title, String director, int year, String genre)
    {
        super(title, year);
        setDirector(director);
        setGenre(genre);
    }

    public String getTitle() {return this.title;}
    public String getDirector() {return this.director;}
    public int getYear() {return this.year;}
    public String getGenre() {return this.genre;}

    public void setTitle(String title) throws IllegalArgumentException
    {
        if(title.isBlank()) {throw new IllegalArgumentException("Title cannot be blank.");}
    }

    public void setDirector(String director) throws IllegalArgumentException
    {
        if(director.isBlank()) {throw new IllegalArgumentException("Director cannot be blank.");}
    }

    public void setYear(int year) throws IllegalArgumentException
    {
        if(year < 1878) {throw new IllegalArgumentException("Year cannot be before 1878.");}
        if(year > Year.now().getValue() + 1) {throw new IllegalArgumentException("Year cannot be in the future.");}
    }

    public void setGenre(String genre) throws IllegalArgumentException
    {
        if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
    }

    @Override
    public String toString()
    {
        return String.format("Movie: [Title: %s, Director: %s, Year: %d, Genre: %s]",
                this.title, this.director, this.year, this.genre);
    }
}
