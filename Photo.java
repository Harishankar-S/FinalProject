public final class Photo extends Media
{
	public Photo(String title, int year)
	{
		super(title, year);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s, [ %d ]",title, year);
	}
}
