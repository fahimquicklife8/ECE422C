package assignment2;

/* EE422C Assignment #2 submission by
 * Replace <> with your actual data.
 * <Student Name> Fahim Imtiaz
 * <Student EID>  fmi89
 */

//This is Driver.java
import java.util.*;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
//        System.out.println("Welcome to Mastermind. Here are the rules.\n");
//        System.out.println("This is a text version of the classic board game Mastermind.\n");
//        System.out.println("The computer will think of a secret code. The code consists of 4 "
//                + "colored pegs. The pegs MUST be one of six colors: blue, green, "
//                + "orange, purple, red, or yellow. A color may appear more than once in "
//                + "the code. You try to guess what colored pegs are in the code and "
//                + "what order they are in. After you make a valid guess the result "
//                + "(feedback) will be displayed.\n");
//        System.out.println("The result consists of a black peg for each peg you have guessed "
//                + "exactly correct (color and position) in your guess. For each peg in "
//                + "the guess that is the correct color, but is out of position, you get "
//                + "a white peg. For each peg, which is fully incorrect, you get no "
//                + "feedback.\n");
//        System.out.println("Only the first letter of the color is displayed. B for Blue, R for "
//                + "Red, and so forth. When entering guesses you only need to enter the "
//                + "first character of each color as a capital letter.\n");


        boolean test = false; // Default to false

        if (args.length > 0 && args[0].equals("1")) {
            test = true;
        }

        Game game = new Game(test);
        game.runGame(sc);





    }

}
