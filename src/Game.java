import java.util.Scanner;
import java.io.FileNotFoundException;

//logic of the Guess the Movie Game

public class Game {
    private String chosenMovie; // movie title that has been randomly chosen
    private int moves; // integer of incorrect typing
    private String wrongLetters; // incorrect letters that has been typed
    private String rightLetters; // correct letters that has been typed
    private boolean win; // true if guessed the movie title


    public Game(String pathname) throws FileNotFoundException {

        // goes to the ChooseMovie class and set chosenMovie
        ChooseMovie chooseMovie = new ChooseMovie(pathname);
        chosenMovie = chooseMovie.selectRandomMovie();
        moves = 0; // starting from 0 incorrect types
        rightLetters = ""; // empty brackets will be filled in the user answers from scanner
        wrongLetters = "";
        win = false;
    }

    public String movieTitle(){
        return chosenMovie;
    }

    // Method that changing the letters into "_" in the title if the typing is correct
    public String hideMovieTitle(){
        if (rightLetters.equals("")){
            return chosenMovie.replaceAll("[a-zA-Z]", "_"); // every a through z or A through Z in chosenMovie replaced by "_"
        }
        else{
            return chosenMovie.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_"); // every a through z or A through Z in chosenMovie replaced by "_" EXCEPT already typed correct letters
        }
    }

    // Method that returns incorrect letters
    public String ifWrongLetters(){

        return wrongLetters;
    }

    // Method that returns true if the game was won
    public boolean isWin(){

        return win;
    }

    // Method that returns when the game is over when the player did more or equal 10 incorrect moves
    public boolean isEnd(){
        if (moves >= 10){
            return true;
        }
        if(!hideMovieTitle().contains("_")){ // if this is true (there are no more underscopes) and the 1st if is false (less than 1o moves) the player won
            win = true;
            return true;
        }
        return false;
    }

    //  Method that type in a letter by player
    private String inputLetter(){
        System.out.println("Guess the letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();
        // if the input is not a letter
        if (!letter.matches("[a-z]")){
            System.out.println("This is not a letter. Please enter a letter.");
            return inputLetter();
        }
        // print out message when letter has been already typed
        else if (wrongLetters.contains(letter) || rightLetters.contains(letter)){
            System.out.println("That letter has been already used.");
            return inputLetter();
        }
        else return letter;
    }
    // Method that add guessed letter to right or wrong letters
    public void guessLetter(){
        String guessedLetter = inputLetter().toLowerCase();

        if (chosenMovie.contains(guessedLetter)){
            rightLetters += guessedLetter + guessedLetter;
        }
        else {
            moves++;
            wrongLetters += " "+guessedLetter;
        }
    }
}







