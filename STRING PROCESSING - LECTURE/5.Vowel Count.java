package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String text = input.readLine();
        String regex = "[AEIOUaYeioyu]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int cnt = 0;

        while (matcher.find())
            cnt++;

        System.out.println(String.format("Vowels: %d", cnt));
    }
}
