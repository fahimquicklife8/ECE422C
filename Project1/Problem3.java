//Name: Fahim Imtiaz
//Section: 17630
package assignment1;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.List;
import java.util.*;
public class Problem3 {
    public static void main(String[] args) {
        // Initialize the POS tagger using instructions from TA
        MaxentTagger nigger = new MaxentTagger("C:\\ECE422C\\Assignment_1\\assignment1\\src\\assignment1\\english-bidirectional-distsim.tagger");

        // Use Scanner for console input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = input.nextLine();

        String[] splitSentence = sentence.split(" ");              //Split sentence into words
        List<HasWord> tokens = SentenceUtils.toWordList(splitSentence);  // Convert the array of words into a list of HasWord objects
        List<TaggedWord> tagged = nigger.tagSentence(tokens);              // Perform POS tagging on the list of HasWord objects

        System.out.println(SentenceUtils.listToString(tagged, false)); // Convert the list of tagged words to a string and print it
    }
}