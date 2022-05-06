public final class Photo extends Media implements Viewable
{
    
   private String rating;
    
    public Photo(String title, int year, String rating)
    {
        super(title, year);
        setRating(rating);
    }
    
 public String getRating() {return this.rating;}
 
  public void setRating(String rating) 
    {
        this.rating = rating;

    }
    
    @Override
    public String toString()
    {
        return String.format("Photo: [Title: %s, Year: %d, Rating: %s]",
                this.title, this.year, this.rating);
    }
}
