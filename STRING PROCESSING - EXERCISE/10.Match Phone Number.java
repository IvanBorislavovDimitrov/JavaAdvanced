package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^\\+359([ -])2(\\1)\\d{3}(\\1)\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        String phone;
        while (!"end".equals(phone = input.readLine())) {
            Matcher matcher = pattern.matcher(phone);
            if (matcher.find()) {
                System.out.println(phone);
            }
        }
    }
}
