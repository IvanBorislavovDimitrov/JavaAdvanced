package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]{1,}+ [A-Z][a-z]{1,}+$";
        String name;
        Pattern pattern = Pattern.compile(regex);
        while (!"end".equals(name = input.readLine())) {
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.println(name);
            }
        }
    }
}
