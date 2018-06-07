import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([,_])([a-zA-Z]+)(\\d)";
        Map<String, String> memo = new LinkedHashMap<>();
        String line;
        Pattern pattern = Pattern.compile(regex);
        while (!"Ascend".equals(line = input.readLine())) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                boolean flag = false;
                for (Map.Entry<String, String> mem : memo.entrySet()) {
                    if (line.contains(mem.getKey())) {
                        flag = true;
                    }
                    line = line.replaceAll(mem.getKey(), mem.getValue());
                }
                if (flag) {
                    matcher = pattern.matcher(line);
                    matcher.find();
                }
                String plusOrMinus = matcher.group(1);
                String characters = matcher.group(2);
                int digit = Integer.parseInt(matcher.group(3));
                switch (plusOrMinus) {
                    case "_":
                        String firstPart = line.substring(0, line.indexOf(matcher.group()));
                        String midChars = decreaseCharacters(characters, digit);
                        String lastPart = line.substring(line.indexOf(matcher.group()) + matcher.group().length());
                        line = firstPart + midChars + lastPart;
                        memo.put(matcher.group(), midChars);
                        break;
                    case ",":
                        firstPart = line.substring(0, line.indexOf(matcher.group()));
                        midChars = increaseCharacters(characters, digit);
                        lastPart = line.substring(line.indexOf(matcher.group()) + matcher.group().length());
                        line = firstPart + midChars + lastPart;
                        memo.put(matcher.group(), midChars);
                        break;
                }
            }
            System.out.println(line);
        }

    }

    private static String decreaseCharacters(String characters, int digit) {
        char[] chars1 = characters.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            chars1[i] -= digit;
        }

        return toStringArr(chars1);
    }

    private static String increaseCharacters(String chars, int digit) {
        char[] chars1 = chars.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            chars1[i] += digit;
        }

        return toStringArr(chars1);
    }

    private static String toStringArr(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
