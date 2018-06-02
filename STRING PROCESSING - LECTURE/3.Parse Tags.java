package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTags {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(.*)(<upcase>)(.*)(<\\/upcase>)(.*)";
        String textToFormat = input.readLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textToFormat);
        while (matcher.find()) {
            textToFormat = matcher.group(1) + matcher.group(3).toUpperCase() + matcher.group(5);
            matcher = pattern.matcher(textToFormat);
        }

        System.out.println(textToFormat);
    }
}
