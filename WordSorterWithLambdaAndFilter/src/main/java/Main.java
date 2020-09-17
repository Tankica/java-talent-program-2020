import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        String stringFile = FileUtils.readFileToString(new File(".\\file.txt"), "UTF-8");
        String[] words = stringFile.split(" ");

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter ASC or DESC (ascending or descending) and enter minimum and maximum number of words that should be printed");
        String sortingOrder = sn.next();
        int min = sn.nextInt();
        int max = sn.nextInt();

        ArrayList<String> wordsList = (ArrayList<String>) Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .filter(word -> !word.equals(""))
                .collect(Collectors.toList());

        Set<String> set = new HashSet<>(wordsList);
        wordsList.clear();
        wordsList.addAll(set);

        if (sortingOrder.equals("DESC")) {
            Collections.sort(wordsList,(String w1, String w2) -> w2.length() - w1.length());
        } else if (sortingOrder.equals("ASC")) {
            Collections.sort(wordsList,Comparator.comparingInt(String::length));
        } else {
            throw new InvalidInputException("Invalid input, available options for input are ASC or DESC");
        }

        if (min == 0 && max == 0) {
            wordsList.forEach(System.out::println);
        } else if (min >= max && max != 0) {
            throw new InvalidInputException("Maximum should be 0 or greater than minimum ");
        } else if (min == 0) {
            wordsList.stream().filter(word -> word.length() <= max).forEach(System.out::println);
        } else if (max == 0) {
            wordsList.stream().filter(word -> word.length() >= min).forEach(System.out::println);
        } else {
            wordsList.stream().filter(word -> word.length() >= min && word.length() <= max).forEach(System.out::println);
        }

    }
}
