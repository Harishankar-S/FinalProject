public class Movie extends Media implements Audible, Viewable
{
    private String director;
    private String genre;
    private int rating;
    
    public Movie(String title, String director, int year, String genre, int rating)
    {
        super(title, year);
        setDirector(director);
        setYear(year);
        setGenre(genre);
        setRating(rating);
    }

    
    public String getDirector() {return this.director;}
    public String getGenre() {return this.genre;}
    public int getRating() {return this.rating;}

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
    
    public void setRating(int rating) throws IllegalArgumentException
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return String.format("Movie: [Title: %s, Director: %s, Year: %d, Genre: %s, Rating: %f]",
                this.title, this.director, this.year, this.genre, this.rating);
    }
}
