package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MagicExchangeableWords {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = input.readLine().split("\\s+");
        String firstWord = words[0];
        String secondWord = words[1];


        System.out.println(areExchangeable(firstWord, secondWord));

    }

    private static boolean areExchangeable(String firstWord, String secondWord) {
        Map<Character, Character> firstToSecond = new HashMap<>();
        Map<Character, Character> secondToFirst = new HashMap<>();

        int shorterWordLength = firstWord.length() > secondWord.length() ? secondWord.length() : firstWord.length();
        for (int i = 0; i < shorterWordLength; i++) {
            char c1 = firstWord.charAt(i);
            char c2 = secondWord.charAt(i);
            if (!firstToSecond.containsKey(c1) && !secondToFirst.containsKey(c2)) {
                firstToSecond.put(c1, c2);
                secondToFirst.put(c2, c1);
            } else {
                if (!firstToSecond.containsKey(c1) || !secondToFirst.containsKey(c2)) {
                    return false;
                }
                if (c1 != secondToFirst.get(c2) && c2 != firstToSecond.get(c1)) {
                    return false;
                }
            }
        }

        String longerWord = firstWord.length() > secondWord.length() ? firstWord : secondWord;
        String shorterWord = firstWord.length() < secondWord.length() ? firstWord : secondWord;
        for (int i = shorterWord.length(); i < longerWord.length(); i++) {
            if (!firstToSecond.containsKey(longerWord.charAt(i)) && !secondToFirst.containsKey(longerWord.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
