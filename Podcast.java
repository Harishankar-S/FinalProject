public class Podcast extends Media
{
	private String creator;
	private int season;
	private int episode;
	
	public Podcast(String creator, String title, int season, int episode, int year)
	{
		super(title, year);
		setCreator(creator);
		setEpisode(episode);
		setSeason(season);
	}

	public String getCreator() {return this.creator;}
	public int getSeason() {return this.season;}
	public int getEpisode() {return this.episode;}

	
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
	
	
}
