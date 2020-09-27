package com.talent.java.main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> wordsList = loadFromFile();

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter ASC or DESC (ascending or descending) and enter minimum and maximum number of words that should be printed");
        String sortingOrder = sn.next();
        int min = sn.nextInt();
        int max = sn.nextInt();

        sortWords(sortingOrder, wordsList);
        wordsList = filterWords(min, max, wordsList);

        wordsList.forEach(System.out::println);
    }

    private static List<String> loadFromFile() throws IOException {
        String stringFile = FileUtils.readFileToString(new File(".\\file.txt"), "UTF-8");

        String[] words = stringFile.split(" ");

        ArrayList<String> wordsList = (ArrayList<String>) Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .filter(word -> !word.equals(""))
                .collect(Collectors.toList());

        Set<String> setToDeleteDuplicate = new HashSet<>(wordsList);
        wordsList.clear();
        wordsList.addAll(setToDeleteDuplicate);

        return wordsList;
    }

    static void sortWords(String sortingOrder, List<String> wordsList) {
        if (sortingOrder.equals("DESC")) {
            Collections.sort(wordsList, (String w1, String w2) -> w2.length() - w1.length());
        } else if (sortingOrder.equals("ASC")) {
            Collections.sort(wordsList, (String w1, String w2) -> w1.length() - w2.length());
        } else {
            throw new InvalidInputException("Invalid input, available options for input are ASC or DESC");
        }
    }

    static List<String> filterWords(int min, int max, List<String> wordsList) {

        return wordsList.stream()
                .filter(word -> {
                    if (min == 0)
                        return true;
                    return word.length() >= min;
                }).filter(word -> {
                    if (max == 0)
                        return true;
                    return word.length() <= max;
                }).collect(Collectors.toList());
    }
}

