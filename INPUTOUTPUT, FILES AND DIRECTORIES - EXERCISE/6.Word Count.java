package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    private static final String FILE_WORDS = "src\\exercises\\words.txt";
    private static final String FILE_TEXT = "src\\exercises\\text.txt";
    private static final String FILE_RESULT = "src\\exercises\\result.txt";

    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        readWords(words);
        countWords(words);
        List<Map.Entry<String, Integer>> sortedWords = sortedWords(words);
        saveWords(sortedWords);
    }

    private static List<Map.Entry<String, Integer>> sortedWords(Map<String, Integer> words) {
        return words
                .entrySet()
                .stream()
                .sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                .collect(Collectors.toList());
    }

    private static void saveWords(List<Map.Entry<String, Integer>> words) {
        try (PrintWriter printWriter = new PrintWriter(FILE_RESULT)) {
            for (Map.Entry<String, Integer> word : words) {
                printWriter.println(String.format("%s - %d", word.getKey(), word.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countWords(Map<String, Integer> words) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_TEXT))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String[] totalWords = sb.toString().split("\\s+");
            for (String totalWord : totalWords) {
                if (words.containsKey(totalWord)) {
                    words.put(totalWord, words.get(totalWord) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readWords(Map<String, Integer> words) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_WORDS))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String[] totalWords = sb.toString().split("\\s+");
            for (String totalWord : totalWords) {
                words.put(totalWord, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
