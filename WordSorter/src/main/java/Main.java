import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String stringFile = FileUtils.readFileToString(new File(".\\file.txt"), "UTF-8");
        ArrayList<String> wordsList = new ArrayList<>();
        String[] words = stringFile.split(" ");

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter ASC for ascending or DESC for descending");
        String sortingOrder = sn.next();

        for (String s : words) {
            String word = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!word.equals("") && !wordsList.contains(word)) {
                wordsList.add(word);
            }
        }

        if (sortingOrder.equals("DESC")) {
            Collections.sort(wordsList, new DescendingLengthStringComparator());
        } else if (sortingOrder.equals("ASC")) {
            Collections.sort(wordsList, new AscendingLengthStringComparator());
        } else {
            throw new InvalidInputException("Invalid input, your available options for input are ASC or DESC");
        }

        for (String s : wordsList)
            System.out.println(s);
    }

}
