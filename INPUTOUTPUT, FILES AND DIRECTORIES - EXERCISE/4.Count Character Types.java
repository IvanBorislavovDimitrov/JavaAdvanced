package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterType {

    private static final String FILE_INPUT_NAME = "src\\exercises\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_INPUT_NAME))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            printInfo(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printInfo(String info) {
        int countOfVowels = 0;
        int countOfConsonants = 0;
        int countOfPunctuations = 0;

        for (int i = 0; i < info.length(); i++) {
            if (isVowel(info.charAt(i))) {
                countOfVowels++;
            } else if (isPunctuation(info.charAt(i))) {
                countOfPunctuations++;
            } else if (info.charAt(i) != ' ') {
                countOfConsonants++;
            }
        }

        System.out.println("Vowels: " + countOfVowels);
        System.out.println("Consonants: " + countOfConsonants);
        System.out.println("Punctuation: " + countOfPunctuations);
    }

    private static boolean isPunctuation(char letter) {
        Set<Character> punctuations = new HashSet<>();
        punctuations.add('!');
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('?');

        return punctuations.contains(letter);
    }

    private static boolean isVowel(char letter) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        return vowels.contains(letter);
    }
}
