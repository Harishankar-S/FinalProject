import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FinalProject{
 public static void main(String[] args){
	 List<Media> newMedia = readMedia("Final Project CSV.csv");
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
     
     int decision = choice.nextInt();
     
     if(decision == 1){
        try {
			BufferedReader reader= new BufferedReader(new FileReader("Final Project CSV.csv"));
			
			String line;
			while((line= reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch(IOException e) {
			System.out.println("Error while reading File");
		}  
     }
     else if(decision == 2){
         
     }
     else if(decision == 3){
         
     }
     else if(decision == 4){
         
     }
     else if(decision == 5){
        
     }
     else if(decision == 6){
        
     }
     else if(decision == 7){
        
     }
     else if(decision == 8){
        
     }
     else if(decision == 9){
        
     }
     else if(decision == 10){
        
     }
     else if(decision == 11){
        
     }
     else if(decision == 12){
        
     }
     else if(decision == 13){
    	 
     }
     else if(decision == 14) {
    	 System.out.println("Goodbye");
	     System.exit(1);
     }
     }
     public static List<Media> readMedia(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			List<media> allMedia = new ArrayList<>();

			String line = reader.readLine();
			while (line != null) {
				
				String[] columns = line.split(",");

				
				String name = columns[0];
				String creator = columns[1];
				int year = Integer.parseInt(columns[2]);
				String genre = columns[3];
				int seasons = Integer.parseInt(columns[4]);
				

			
				Media newMedia = new Sprinter(name, creator, year, genre, seasons);

				
				allMedia.add(newMedia);

				line = reader.readLine();
			}

			reader.close();
			return allMedia;
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found");
		} catch (IOException e) {
			System.out.println("Error while reading from file");
		} catch (NumberFormatException e) {
			System.out.println("File is not formatted properly");
		}

		System.exit(-1);
		return null;
	}
    }
 

