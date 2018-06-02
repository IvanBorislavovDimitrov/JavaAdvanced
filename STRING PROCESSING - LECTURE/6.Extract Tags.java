package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while (!"END".equals(line = input.readLine()))
            sb.append(line).append(System.lineSeparator());

        String regex = "<.*?>";
        Pattern pattern = Pattern.compile(regex);
        String text = sb.toString();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find())
            System.out.println(matcher.group());
    }
}
