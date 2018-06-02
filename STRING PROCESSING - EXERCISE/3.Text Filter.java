package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TextFilter {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = Arrays.stream(input.readLine().split(",\\s+")).collect(Collectors.toSet());
        String text = input.readLine();
        for (String word : words) {
            String format = "%" + word.length() + "s";
            String newWord = String.format(format, "*").replaceAll(" ", "*");
            text = text.replaceAll(word, newWord);
        }

        System.out.println(text);
    }
}
