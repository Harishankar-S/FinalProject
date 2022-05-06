public class Podcast extends Media implements Audible
{
    private String creator;
    private int season;
    private int episode;
    private int rating;
    
    public Podcast(String title, String creator, int year, int season, int episode, int rating)
    {
        super(title, year);
        setCreator(creator);
        setEpisode(episode);
        setSeason(season);
        setRating(rating);
    }

    public String getCreator() {return this.creator;}
    public int getSeason() {return this.season;}
    public int getEpisode() {return this.episode;}
    public int getRating() {return this.rating;}
    
    public void setCreator(String creator) throws IllegalArgumentException
    {
        if(creator.isBlank()) {throw new IllegalArgumentException("Creator cannot be blank.");}
        this.creator = creator;
    }
    
    public void setSeason(int season) throws IllegalArgumentException
    {
        if(season <= 0) {throw new IllegalArgumentException("Season cannot be 0 or less.");}
        this.season = season;
    }


    public void setEpisode(int episode) throws IllegalArgumentException
    {
        if(episode <= 0) {throw new IllegalArgumentException("Episode cannot be 0 or less.");}
        this.episode = episode;
    }
    
    public void setRating(int rating) 
    {
        this.rating = rating;
    }
    
    
    @Override
    public String toString()
    {
        return String.format("Podcast: [Creator: %s, Title: %s, Season: %d, Episode: %d, Year: %d, Rating: %d",
                this.creator, this.title, this.season, this.episode, this.year, this.rating);
    }
}
