import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		List<Media> media = readFile();
		Scanner choice = new Scanner(System.in);
		
		
		System.out.println("Welcome, please enter your choice after viewing options!\n");

		System.out.println("1. Print all content in the database\n");

		System.out.println("2. Print only music, only movies, only TV shows, only podcasts, or only photos\n");

		System.out.println("3. Print all content which can be listend to\n");

		System.out.println("4. Print all content which can be viewed\n");
		
		System.out.println("5. Load content onto respective devices\n");

		System.out.println("6. Sort and print photos oldest to youngest\n");

		System.out.println("7. Print songs before 2000\n");

		System.out.println("8. Which year has the most files in the database");

		System.out.println("9. Which year has the most files in the database\n");

		System.out.println("10. What is the oldest Movie file in the database which belongs to the ‘Science Fiction’ genre?");

		System.out.println("11. Recive a shuffled collection of music\n");

		System.out.println("12. Add a new file to the database\n");

		System.out.println("13. Sort and print music by rating\n");

		System.out.println("14. Quit the program\n");

		int decision = Integer.parseInt(choice.nextLine());
		
		switch(decision)
		{
		case 1:
			media.stream().forEach(System.out::println);
			break;
		case 2:
				  Scanner choice2 = new Scanner(System.in);
	         System.out.println("What would you like to print? Enter Music, Movies, TV Shows, Podcasts, or Photos");
	         String decision2 = choice2.nextLine();

	         switch(decision2) {
	         case "Music":
	        	 media.stream().filter(x -> x.getClass().toString().equals("class Music")).forEach(System.out::println);
	                 break;
	         case "Movies":
	        	 media.stream().filter(x -> x.getClass().toString().equals("class Movie")).forEach(System.out::println);
	                 break;
	         case "TV Shows":
	        	 media.stream().filter(x -> x.getClass().toString().equals("class TVShow")).forEach(System.out::println);
	                 break;
	         case "Podcasts":
	        	 media.stream().filter(x -> x.getClass().toString().equals("class Podcast")).forEach(System.out::println);
	                 break;
	         case "Photos":
	        	 media.stream().filter(x -> x.getClass().toString().equals("class Picture")).forEach(System.out::println);
	                 break;
	         }
			break;
		case 3:
				media.stream().filter(x -> x.getClass().toString().equals("class Music")).forEach(System.out::println);
		   		media.stream().filter(x -> x.getClass().toString().equals("class Podcast")).forEach(System.out::println);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
				media.stream().filter(x -> x.getClass().toString().equals("Class Picture"))
		     .sorted((a,b) -> Integer.compare(b.getYear(), b.getYear())).forEach(System.out::println);
			break;
		case 7:
			media.stream().filter(x -> x.getClass().toString().equals("class Music")).filter(x -> (x.getYear() < 2000)).forEach(System.out::println);
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:

			System.out.println("Goodbye.");
			System.exit(1);
		break;
		}
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
