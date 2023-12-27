package assignment4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bonus {
    /**
     * Generate example poetry.
     *
     * @param args unused
     * @throws IOException if a poet corpus file cannot be found or read
     */
    public static void main(String[] args) throws IOException {
        String url = "http://www.ece.utexas.edu/people/faculty/edison-thomaz";
        Document document = Jsoup.connect(url).get();

        String biographyText = document.select("#block-ece-content > article > div > div.field.field--name-body.field--type-text-with-summary.field--label-hidden.field__item > p:nth-child(1)").text();

        String corpus = biographyText.replaceAll("[^a-zA-Z\\s]", "");

        File corpusFile = new File("corpus.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(corpusFile))) {
            writer.write(corpus);
        }

        final GraphPoet nimoy = new GraphPoet(corpusFile);

        // Generate the poem using the input from "bonus_input.txt"
        System.out.println(nimoy.poem(new File("bonus_input.txt")));
    }
}
