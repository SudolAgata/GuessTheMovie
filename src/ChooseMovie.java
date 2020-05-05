import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


// choosing random movie title from txt file
public class ChooseMovie {
    private ArrayList<String> movies;
    public ChooseMovie (String pathname) throws FileNotFoundException {
            movies = new ArrayList();
            File file = new File(pathname);

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    movies.add(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                    System.out.println("File does not exist.");
                }
            }
            public String selectRandomMovie() {
                int movieTitle = (int) (Math.random()*movies.size());
                return movies.get(movieTitle);

            }
    }







