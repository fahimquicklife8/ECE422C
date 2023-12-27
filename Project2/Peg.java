package assignment2;
import java.util.ArrayList;
import java.util.Scanner;
/* EE422C Assignment #2 submission by
 * Replace <> with your actual data.
 * <Student Name> Fahim Imtiaz
 * <Student EID>  fmi89
 */
//This is Peg.java file
public class Peg {
    int white, black;

    public Peg(int white, int black) {
        this.white = white;
        this.black = black;
    }

    public String implement(String guess, String secretcode) {
        black = 0;  // Initialize black pegs to 0
        white = 0;  // Initialize white pegs to 0


        StringBuilder secretBuilder = new StringBuilder(secretcode);

        // System.out.println(secretcode);
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secretBuilder.charAt(i)) {
                black++;

                secretBuilder.setCharAt(i, '*');
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int index = secretBuilder.indexOf(String.valueOf(guess.charAt(i)));
            if (index != -1 && guess.charAt(i) != secretcode.charAt(i)) {
                white++;

                secretBuilder.setCharAt(index, '*');
            }
        }

            String guess_result = guess + " -> " + black + "B_" + white + "W";
            return guess_result;

        //  System.out.println(guess_result);

    }


}

