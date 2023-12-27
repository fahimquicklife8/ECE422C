package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

// This is Game.java

/* EE422C Assignment #2 submission by
 * Replace <> with your actual data.
 * <Student Name> Fahim Imtiaz
 * <Student EID>  fmi89
 */

public class Game {
    int guesses;
    boolean result, testing;
    ArrayList<String> history;

    public Game(boolean testingMode) {
        this.guesses = GameConfiguration.guessNumber;
        this.result = false;
        this.testing = testingMode;
        this.history = new ArrayList<>();
    }

    public boolean isValid(String user_guess) {
        int length = user_guess.length();
        String upper = user_guess.toUpperCase();
        String validChars = "B" + "G" + "O" + "Y" + "P" + "R";

        if (length != GameConfiguration.pegNumber) {
            return false;
        }

        if (!user_guess.equals(upper)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char ch = user_guess.charAt(i);
            if (validChars.indexOf(ch) == -1) {
                return false;
            }
        }

        return true;
    }

    boolean invalid = false;

    public void resetGame() {
        this.guesses = GameConfiguration.guessNumber;
        this.result = false;
        this.history.clear();
    }

    public void runGame(Scanner sc) {
        System.out.println("Are you ready to play? (Y/N): ");
        String input = sc.nextLine();

        if (input.equals("N")) {
            return;
        } else if (!input.equals("Y")) {
            System.exit(0);
        }

        System.out.print("Generating secret code ...");

        String code = SecretCodeGenerator.getInstance().getNewSecretCode();
        if (testing) {
            System.out.print("...(for this example the secret code is " + code + ")");
        }

        System.out.println();

        while (guesses > 0) {
            if (!invalid) {
                // System.out.println("You have " + guesses + " guesses left.");
            }
            // System.out.println("What is your next guess?\nType in the characters for your guess and press enter.");
            // System.out.print("Enter guess: ");
            String user_guess = sc.nextLine();

            if (user_guess.equals("HISTORY")) {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println(history.get(i));
                }
                System.out.println();
            } else if (!isValid(user_guess)) {
                System.out.println(user_guess + " -> INVALID GUESS");
                invalid = true;
            } else {
                invalid = false;
                Peg peg = new Peg(0, 0);
                String s = peg.implement(user_guess, code);
                history.add(user_guess+ "\t" + s.split(" ")[2]);

                if (peg.black == 4 && peg.white == 0) {
                    result = true;
                    System.out.println(s + " - You win");
                    break;
                } else if (guesses != 1) {
                    System.out.println(s);
                }

                guesses--;
            }
        }

        if (!result) {
            System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
        }

        System.out.print("\nAre you ready for another game (Y/N): ");
        input = sc.nextLine();
        System.out.println();

        if (input.equalsIgnoreCase("Y")) {
            resetGame();
            runGame(sc);
        }

    }
}
