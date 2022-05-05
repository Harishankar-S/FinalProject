import java.time.Year;

public abstract class Media
{
	protected String title;
	protected int year;
	
	public Media(String title, int year)
	{
		setTitle(title);
		setYear(year);
	}

	public String getTitle() {return this.title;}
	public int getYear() {return this.year;}

	public void setTitle(String title)
	{
		if(title.isBlank()) {throw new IllegalArgumentException("Title must not be blank.");}
		this.title = title;
	}
	
	public void setYear(int year)
	{
		if(year < -1400) {throw new IllegalArgumentException("Year cannot be before 1400 BCE.");}
		if(year > Year.now().getValue() + 1) {throw new IllegalArgumentException("Year cannot be in the future.");}
		this.year = year;
	}
	
	
}
