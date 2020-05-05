import java.util.Scanner;


public class Main {
    public static void main(String [] args) throws Exception {
        Game game = new Game("movies.txt");

        System.out.println("Guess the Movie Name!");

        while(!game.isEnd()){
            System.out.println("The Movie Title: " + game.hideMovieTitle());
            System.out.println("You guessed (" + game.ifWrongLetters().length()/2+ ") wrong letters" + game.ifWrongLetters());
            game.guessLetter();
        }
        if (game.isWin()){
            System.out.println("You win!");
            System.out.println("You guessed '"+ game.movieTitle()+"' correctly");
        }
        else {
            System.out.println("You have guessed ("+ game.ifWrongLetters().length()/2+ ") wrong letters:" + game.ifWrongLetters());
            System.out.println("You lost!");
            System.out.println("The correct movie title is "+ game.movieTitle() + " .");

        }
    }




}
