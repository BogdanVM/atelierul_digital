package Classes;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Poem {

    private int noWords;
    private HashMap<String, Integer> wordCount;

    /*  CONSTRUCTOR  */
    public Poem() {

        noWords = 0;
        wordCount = new HashMap<String, Integer>();
    }

    /*  UTILITY METHODS  */

    public void readPoem(String fileName) throws IOException {

        try (Scanner scanner = new Scanner( new BufferedReader( new FileReader(fileName)))) {

            while (scanner.hasNext()) {

                String line = scanner.nextLine();

                if (!line.isEmpty()) {
                    String[] words = line.split("[.,;!?\\s']+");

                    for (String word : words) {
                        if (!word.isEmpty()) {
                            Integer wordOccurences = wordCount.get(word);

                            if (wordOccurences != null) {
                                wordCount.put(word, wordOccurences + 1);
                            } else {
                                wordCount.put(word, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public LinkedHashMap<String, Integer> sortHashMap(HashMap<String, Integer> hashMap){

        /* First we create two lists for both the keys and the values */
        List<Integer> mapValues = new ArrayList<>(hashMap.values());
        List<String> mapKeys = new ArrayList<>(hashMap.keySet());

        /* Now we sort the values list ( which holds the number of word occurences ) */
        Collections.sort(mapValues, new myComparator());

        /* We create a LinkedHashMap where we shall hold the sorted map */
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        /* Now we shall iterate through the values list */
        Iterator<Integer> valueIterator = mapValues.iterator();
        while (valueIterator.hasNext()) {

            Integer currentValue = valueIterator.next();
            Iterator<String> keyIterator = mapKeys.iterator();

            /* After extracting the current value, we shall iterate through the keys */
            while (keyIterator.hasNext()) {

                /* We extract the key and the value corresponding to it */
                String currentKey = keyIterator.next();
                Integer keyValue = hashMap.get(currentKey);

                /* Now we compare the value based of the key with our current value */
                if (currentValue.equals(keyValue)) {

                    /* We add the new pair to the sorted map and remove it from the original one */
                    keyIterator.remove();
                    linkedHashMap.put(currentKey, currentValue);
                    break;
                }
            }
        }

        return linkedHashMap;
    }

    public void displayCommonWords() {

        LinkedHashMap<String, Integer> linkedHashMap = sortHashMap(wordCount);

        int count = 0;
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {

            String word = entry.getKey();
            Integer occurences = entry.getValue();

            System.out.println(word + " => " + occurences);
            count++;

            if (count == 10)
                break;
        }
    }
}
