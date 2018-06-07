package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(>>>----->>)|(>>----->)|(>----->)";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(input.readLine()).append(" ");
        }

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(sb);

        int countOfSmall = 0;
        int countOfMedium = 0;
        int countOfLarge = 0;

        while (matcher.find()) {
            if (matcher.group(3) != null) {
                countOfSmall++;
            } else if (matcher.group(2) != null) {
                countOfMedium++;
            } else if (matcher.group(1) != null) {
                countOfLarge++;
            }
        }

        int digit = countOfSmall * 100 + countOfMedium * 10 + countOfLarge;
        String binary = Integer.toBinaryString(digit);
        String reversedBinary = binary + new StringBuilder(binary).reverse().toString();
        long number = Integer.parseInt(reversedBinary, 2);
        System.out.println(number);
    }
}
