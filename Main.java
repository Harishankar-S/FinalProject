import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FinalProject
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
        System.out.println("8. Are there more even years, or odd years?\n");
        System.out.println("9. Print out oldest Rock song\n");
        System.out.println("10. What is the oldest Movie file in the database which belongs to the ‘Science Fiction’ genre?\n");
        System.out.println("11. Recive a shuffled collection of music\n");
        System.out.println("12. Add a new file to the database\n");
        System.out.println("13. Sort and print music by rating\n");
        System.out.println("14. Quit the program\n");

        try
        {
            int decision = Integer.parseInt(choice.nextLine());
            switch(decision)
            {
                case 1:
                    media.stream().forEach(System.out::println);
                    break;
                case 2:
                    Scanner fileChoice = new Scanner(System.in);
                    String fileDecision = "";
                    FileTypes fileType;

                    for(;;)
                    {
                        System.out.print("What would you like to print? Enter Music, Movie, TVShow, Podcast, or Photo: ");
                        fileDecision = fileChoice.nextLine().trim();

                        try
                        {
                            fileType = FileTypes.valueOf(fileDecision.toUpperCase());
                            fileChoice.close();
                            break;
                        }
                        catch(IllegalArgumentException e) {System.out.println("That is not a valid file type.");}
                    }

                    switch(fileType)
                    {
                        case MUSIC:
                            media.stream().filter(x -> x instanceof Music).forEach(System.out::println);
                            break;
                        case MOVIE:
                            media.stream().filter(x -> x instanceof Movie).forEach(System.out::println);
                            break;
                        case TVSHOW:
                            media.stream().filter(x -> x instanceof TVShow).forEach(System.out::println);
                            break;
                        case PODCAST:
                            media.stream().filter(x -> x instanceof Podcast).forEach(System.out::println);
                            break;
                        case PHOTO:
                            media.stream().filter(x -> x instanceof Photo).forEach(System.out::println);
                            break;
                        default:
                            System.out.println("That media type is unavailable.");
                            break;
                    }
                    break;
                case 3:
                    media.stream().filter(x -> (x instanceof Viewable)).forEach(System.out::println);
                    break;
                case 4:
                    media.stream().filter(x -> (x instanceof Audible)).forEach(System.out::println);
                    break;
                case 5:
                    
                    break;
                case 6:
                    media.stream().filter(x -> x instanceof Photo)
                    .sorted((a,b) -> Integer.compare(a.getYear(), b.getYear())).forEach(System.out::println);
                    break;
                case 7:
                    media.stream().filter(x -> x instanceof Music).filter(x -> (x.getYear() < 2000)).forEach(System.out::println);
                    break;
                case 8:
                    long evenSize = media.stream().filter(x -> (x.getYear() % 2 == 0)).count();
                    long oddSize = media.stream().filter(x -> (x.getYear() % 2 == 1)).count();

                    if (evenSize > oddSize) {System.out.printf("There are more even years than odd (%d > %d).%n", evenSize, oddSize);}
                    else {System.out.printf("There are more odd years than even (%d > %d).%n", oddSize, evenSize);}
                    break;
                case 9:
                    
                    break;
                case 10:
                    media.stream().filter(x -> x instanceof Movie)
                    .map(x -> (Movie)x)
                    .filter(x -> x.getGenre().equals("Science Fiction"))
                    .sorted((a,b) -> Integer.compare(a.getYear(), b.getYear()))
                    .limit(1)
                    .forEach(System.out::println);
                    break;
                case 11:
                    List<Media> m = media.stream().filter(x -> x instanceof Music).collect(Collectors.toList());
                    Collections.shuffle(m);
                    System.out.println(m);
                    break;
                case 12:
                    
                    break;
                case 13:   
                media.stream().filter(x -> x instanceof Music)
                .map(x -> (Music)x) 
                .sorted((a,b) -> Integer.compare(a.getRating(), b.getRating()))
                .forEach(System.out::println);

                    break;
                case 14:
                    System.out.println("Goodbye.");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        catch (IllegalArgumentException e) {System.out.println("Invalid input.");}
        catch (Exception e) {System.out.println("An unknown error occurred.");}

        choice.close();
    }

    private static List<Media> readFile()
    {
        final String FILEPATH = "C:\\Users\\Alex\\Java\\MediaList.csv";
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
                            args[4].trim(),
                            Integer.parseInt(args[5])
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
                            args[4].trim(),
                            Integer.parseInt(args[5])
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
                            args[6].trim(),
                            Integer.parseInt(args[7])
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
                            Integer.parseInt(args[5]),
                            Integer.parseInt(args[6])
                        )
                    );
                }
                else if(args[0].equalsIgnoreCase("Photo"))
                {
                    media.add(
                        new Photo
                        (
                            args[1].trim(),
                            Integer.parseInt(args[2]),
                            Integer.parseInt(args[3])
                        )
                    );
                }

            }

            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        catch (IllegalArgumentException e)
        {
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
