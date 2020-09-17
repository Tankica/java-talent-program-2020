import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileText = FileUtils.readFileToString(new File(".\\file.txt"), "UTF-8");
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String[] words = fileText.split(" ");

        for (String s : words) {
            String word = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!word.equals("")) {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1);
                } else {
                    wordsMap.put(word, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
