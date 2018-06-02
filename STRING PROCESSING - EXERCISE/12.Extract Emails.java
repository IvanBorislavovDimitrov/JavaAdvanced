package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(^| )([a-zA-Z][a-zA-Z.\\-_0-9]+@([A-Za-z\\-]+\\.)+[a-zA-Z\\-]+)";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();
        String line;
        while (!"end".equals(line = input.readLine())) {
            sb.append(line).append(System.lineSeparator());
        }
        String text = sb.toString();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(2).trim());
        }
    }
}
