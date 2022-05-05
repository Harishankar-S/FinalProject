public final class Photo extends Media implements Viewable
{
	public Photo(String title, int year)
	{
		super(title, year);
	}
	
	@Override
	public String toString()
	{
		return String.format("Photo: [Title: %s, Year: %d]",
				this.title, this.year);
	}
}
