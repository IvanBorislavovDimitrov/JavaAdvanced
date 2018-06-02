package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?:<a)(?:[\\s\\n_0-9a-zA-Z=\"\"()]*?.*?)(?:href([\\s\\n]*)?=(?:['\"\"\\s\\n]*)?)([a-zA-Z:#\\/._\\-0-9!?=^+]*(\\([\"\"'a-zA-Z\\s.()0-9]*\\))?)(?:[\\s\\na-zA-Z=\"\"()0-9]*.*?)?(?:\\>)";
        StringBuilder sb = new StringBuilder();
        String line;
        while (!"END".equals(line = input.readLine()))
            sb.append(line).append("\n");

        String html = sb.toString();
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
