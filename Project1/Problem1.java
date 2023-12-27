//Name: Fahim imtiaz
//Section: 17630
package assignment1;
import java.lang.*;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        String s = input.next();

        if(2> n || n > 20 ){
            System.exit(1);       //constraint for n
        }

        if(s.length() != 1000){
            System.exit(1);       //constraint for String
        }

        int maxProduct = 0;
        for (int i = 0; i < s.length() - n + 1; i++) { //iterate through length of string + 1 for last element
            int currentProduct = 1;
            int nonZeroCount = 0;
            for (int j = 0; j < n; j++) {             //iterate through n elements
                char numberChar = s.charAt(i + j);    // get character at i and j
                int numberInt = Character.getNumericValue(numberChar); //extract numerical value of character
                if (numberInt != 0) {                 //proceed if value is not zero
                    currentProduct = currentProduct * numberInt;
                    nonZeroCount++;
                }
            }
            if (nonZeroCount > 0 && currentProduct > maxProduct) { //excluding 0s
                maxProduct = currentProduct;
            }
        }
        System.out.println(maxProduct);
    }
}
