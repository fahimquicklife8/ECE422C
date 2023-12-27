package assignment4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class GraphPoet {
    private Map<String, Map<String, Integer>> graph = new HashMap<>();
    private Map<String, String> caseMap = new HashMap<>();

    /**
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(corpus));
        String previousWord = null;

        /* Read in the File and place into graph here */
        //try (BufferedReader br = new BufferedReader(new FileReader(corpus)))
        try {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");



                for (int i = 0; i < words.length; i++) {


                    String wordCleaned = words[i].replaceAll("[^a-zA-Z']", "");
                    caseMap.putIfAbsent(wordCleaned.toLowerCase(), wordCleaned);
                    words[i] = wordCleaned.toLowerCase();
                }


                for (int i = 0; i < words.length - 1; i++) {


                    addEdge(words[i], words[i + 1]);
                }


                if (previousWord != null) {
                    addEdge(previousWord, words[0]);
                }
                previousWord = words[words.length - 1];

//            }
//                    else
//            {
//                edges.put(words[i+1], 1);
            }
        } finally {
            br.close();
        }
    }


    private void addEdge(String word1, String word2) {
        graph.putIfAbsent(word1, new HashMap<>());

        Map<String, Integer> edges = graph.get(word1);

        edges.put(word2, edges.getOrDefault(word2, 0) + 1);
    }


    /**
     * Generate a poem.
     *
     * @param input File from which to create the poem
     * @return poem (as described above)
     */

    public String poem(File input) throws IOException {
        StringBuilder poemBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(input));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length - 1; i++) {


                    poemBuilder.append(words[i].replaceAll("[^a-zA-Z]", "")).append(" ");
                    String bridgeWord = findHighestWeightBridgeWord(words[i].toLowerCase(), words[i + 1].toLowerCase());



                    if (bridgeWord != null) {
                        poemBuilder.append(caseMap.getOrDefault(bridgeWord, bridgeWord)).append(" ");
                    }


                }
                poemBuilder.append(words[words.length - 1].replaceAll("[^a-zA-Z]", "")).append(" ");
            }
        } finally {
            br.close();
        }

        return poemBuilder.toString();    //.trim();
    }


    private String findHighestWeightBridgeWord(String word, String nextWord) {
        Map<String, Integer> bridges = graph.get(word);

        if (bridges == null) {
            return null;
        }

        String bridgeWord = null;
        int maxWeight = -1;

        Iterator<Map.Entry<String, Integer>> iterator = bridges.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String currentBridge = entry.getKey();
            int currentWeight = entry.getValue();

            if (graph.containsKey(currentBridge) && graph.get(currentBridge).containsKey(nextWord) && currentWeight > maxWeight) {
                maxWeight = currentWeight;
                bridgeWord = currentBridge;
            }
        }
        return bridgeWord;
    }
}


