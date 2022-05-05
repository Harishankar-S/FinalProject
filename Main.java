import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main
{
	public static void main(String[] args)
	{
		List<Media> media = readFile();
		
		
	}
	
	private static List<Media> readFile()
	{
		final String FILEPATH = "Datasets\\MediaList.csv";
		List<Media> media = new ArrayList<Media>(25);
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] args = line.split(",");
				
				if(args[0].equalsIgnoreCase("Music"))
				{
					media.add(
						new Music
						(
							args[1].trim(),
							args[2].trim(),
							Integer.parseInt(args[3]),
							args[4].trim()
						)
					);
				}
				else if(args[0].equalsIgnoreCase("Movie"))
				{
					media.add(
						new Movie
						(
							args[1].trim(),
							args[2].trim(),
							Integer.parseInt(args[3]),
							args[4].trim()
						)
					);
				}
				else if(args[0].equalsIgnoreCase("TV Show"))
				{
					media.add(
						new TVShow
						(
							args[1].trim(),
							args[2].trim(),
							Integer.parseInt(args[3]),
							Short.parseShort(args[4]),
							Short.parseShort(args[5]),
							args[6].trim()
						)
					);
				}
				else if(args[0].equalsIgnoreCase("Podcast"))
				{
					media.add(
						new Podcast
						(
							args[1].trim(),
							args[2].trim(),
							Integer.parseInt(args[3]),
							Integer.parseInt(args[4]),
							Integer.parseInt(args[5])
						)
					);
				}
				else if(args[0].equalsIgnoreCase("Photo"))
				{
					media.add(
						new Photo
						(
							args[1].trim(),
							Integer.parseInt(args[2])
						)
					);
				}
				
			}
			
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Invalid input.");
			System.exit(1);
		}
		catch (Exception e)
		{
			System.out.println("An unknown error occurred.");
			System.exit(2);
		}
		
		return media;
	}
}
