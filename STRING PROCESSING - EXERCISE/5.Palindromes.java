package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = input.readLine().split(",| |\\.|\\?|!");

        Set<String> palindromes = new TreeSet<>();
        getPalindromes(palindromes, words);
        System.out.println(palindromes);
    }

    private static void getPalindromes(Set<String> palindromes, String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
    }

    private static boolean isPalindrome(String word) {
        if (word.equals("")) {
            return false;
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
