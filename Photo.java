public final class Photo extends Media implements Viewable
{
    
   private int rating;
    
    public Photo(String title, int year, int rating)
    {
        super(title, year);
        setRating(rating);
    }
    
 public int getRating() {return this.rating;}
 
  public void setRating(int rating) 
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
