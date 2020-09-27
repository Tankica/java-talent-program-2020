package com.talent.java.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MainTest {

    List<String> wordList;

    @BeforeEach
    void setUp() {
        wordList = Arrays.asList("exercitation", "consectetur", "Lorem", "sit", "sd", "a");
    }

    @Test
    void sortWords_ascending() {
        Main.sortWords("ASC", wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("a", "sd", "sit", "Lorem", "consectetur", "exercitation"));
    }

    @Test
    void sortWords_descending() {
        Main.sortWords("DESC", wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("exercitation", "consectetur", "Lorem", "sit", "sd", "a"));
    }

    @Test
    void sortWords_invalidInput() {
        Assertions.assertThrows(InvalidInputException.class,
                () -> Main.sortWords("ABV", wordList),
                "Invalid input, available options for input are ASC or DESC");
    }

    @Test
    void filterWords_minMaxDifferentFromZero() {
        wordList = Main.filterWords(1, 5, wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("Lorem", "sit", "sd", "a"));
    }

    @Test
    void filterWords_minEqualsToZero() {
        wordList = Main.filterWords(0, 5, wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("Lorem", "sit", "sd", "a"));
    }

    @Test
    void filterWords_maxEqualsToZero() {
        wordList = Main.filterWords(5, 0, wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("exercitation", "consectetur", "Lorem"));
    }

    @Test
    void filterWords_minMaxEqualsToZero() {
        wordList = Main.filterWords(0, 0, wordList);
        Assertions.assertLinesMatch(wordList, Arrays.asList("exercitation", "consectetur", "Lorem", "sit", "sd", "a"));
    }

}
