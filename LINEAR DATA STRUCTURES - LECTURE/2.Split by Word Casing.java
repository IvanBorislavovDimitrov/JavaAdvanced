package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplitWordsByCasing {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = input.readLine().split("[.!,/()'\\\\\";:\\[\\] ]");
        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();
        addWords(lowerCaseWords, upperCaseWords, mixedCaseWords, words);
        System.out.println(String.format("Lower-case: %s", String.join(", ", lowerCaseWords)));
        System.out.println(String.format("Mixed-case: %s", String.join(", ", mixedCaseWords)));
        System.out.println(String.format("Upper-case: %s", String.join(", ", upperCaseWords)));
    }

    private static void addWords(List<String> lowerCaseWords, List<String> upperCaseWords, List<String> mixedCaseWords, String[] words) {
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            switch (whatIsWord(word)) {
                case 1:
                    lowerCaseWords.add(word);
                    break;
                case 2:
                    upperCaseWords.add(word);
                    break;
                case 3:
                    mixedCaseWords.add(word);
                    break;
            }
        }
    }

    private static int whatIsWord(String word) {
        int countOfLower = 0;
        int countOfUpper = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                countOfLower++;
            } else if (Character.isUpperCase(word.charAt(i))) {
                countOfUpper++;
            }
        }

        if (countOfLower == word.length()) {
            return 1;
        }
        if (countOfUpper == word.length()) {
            return 2;
        }

        return 3;
    }
}
