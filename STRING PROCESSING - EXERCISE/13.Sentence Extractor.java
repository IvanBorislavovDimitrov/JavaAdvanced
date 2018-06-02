package exercise;

import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceExtractor {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String word = input.readLine();
        String text = input.readLine();
        Pattern pattern = Pattern.compile("(.*?)(!|\\.|\\?)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            List<String> sentenceWords = Arrays.stream(matcher.group(1).split("\\s+")).collect(Collectors.toList());
            if (sentenceWords.contains(word)) {
                System.out.println(matcher.group(0).trim());
            }
        }
    }
}
