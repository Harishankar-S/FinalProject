
import java.time.Year;

public class TVShow extends Media
{
    private String director;
    private short season;
    private short episode;
    private String genre;
    
    public TVShow(String title, String director, int year, short season, short episode, String genre)
    {
        super(title, year);
        setDirector(director);
        setSeason(season);
        setEpisode(episode);
        setGenre(genre);
    }

    public String getTitle() {return this.title;}
    public String getDirector() {return this.director;}
    public int getYear() {return this.year;}
    public short getSeason() {return this.season;}
    public short getEpisode() {return this.episode;}
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
        if(year < 1928) {throw new IllegalArgumentException("Year cannot be before 1928.");}
        if(year > Year.now().getValue() + 1) {throw new IllegalArgumentException("Year cannot be in the future.");}
    }


    public void setSeason(short season) throws IllegalArgumentException
    {
        if(season < 1) {throw new IllegalArgumentException("Season cannot be less than 1.");}
    }


    public void setEpisode(short episode) throws IllegalArgumentException
    {
        if(episode < 1) {throw new IllegalArgumentException("Episode cannot be less than 1.");}
    }


    public void setGenre(String genre) throws IllegalArgumentException
    {
        if(genre.isBlank()) {throw new IllegalArgumentException("Genre cannot be blank.");}
    }

    @Override
    public String toString()
    {
        return String.format("TV Show: [Title: %s, Director: %s, Year: %d, Season: %d, Episode: %d, Genre: %s]",
                this.title, this.director, this.year, this.season, this.episode, this.genre);
    }
    
}
