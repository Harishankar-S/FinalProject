import java.time.Year;

public final class Photo extends Media{
    
    public Photo(String title, int year) {
        super(title, year);
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }

    public void setTitle(String title) throws IllegalArgumentException
    {
        if(title.isBlank()) {throw new IllegalArgumentException("Title cannot be blank.");}
    }
    
    
    public void setYear(int year) throws IllegalArgumentException
    {
        if(year < 1878) {throw new IllegalArgumentException("Year cannot be before 1878.");}
        if(year > Year.now().getValue() + 1) {throw new IllegalArgumentException("Year cannot be in the future.");}
    }
    
    @Override
    public String toString() {
        
        return String.format("%s, [ %d ]",title, year);
    
}
}
