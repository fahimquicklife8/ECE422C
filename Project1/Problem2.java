package assignment1;
import java.util.*;
import java.lang.*;
//Name: Fahim Imtiaz
//Section: 17630

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);                            //input will be put by grader
        String s = input.nextLine();                                       // String will be stored in s

        if (s.length() <= 0 || s.length() >= 1000000) {                       // Constraints
            System.exit(1);                                          // Abnormal exit for violating rule
        }

        String[] words = s.split(" ");                                //split words from " " using
        int i, j;
        for(i=0; i < words.length ;i++) {                                     //outer loop iterates through words
            int counter = 0;
            for (j = 0; j < words[i].length();j++) {                        //inner loop iterates through characters in words
                char getChar = words[i].charAt(j);                            //get characters from words and starting index 0
                char lowerCase = Character.toLowerCase(getChar);               //convert character to lowercase
                int pennyValue;
                if (Character.isLetter(getChar)) {                            //only calculate value for letter
                    pennyValue = lowerCase - 'a' + 1;                         //based on character ASCII value calculate value
                } else {
                    pennyValue = 0;                                           //else their value is 0
                }
                counter = counter + pennyValue;                               //keep adding values for character as we iterate through words
            }
            if (counter == 100) {                                             //if a counter value for a word is 100
                System.out.println(words[i]);                                 //just print each letter out its easier
            }
        }

    }
}
