package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String regex = "^[A-Za-z_0-9\\-]{3,16}$";
        Pattern pattern = Pattern.compile(regex);
        List<String> list = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                list.add("valid");
            } else {
                list.add("invalid");
            }
        }
        if (list.contains("valid")) {
            list.forEach(System.out::println);
        }
    }
}
