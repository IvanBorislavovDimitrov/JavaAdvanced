package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstName {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String names = input.readLine();
        String firstLetters = input.readLine();

        Set<String> firstLettersSet = Arrays.stream(firstLetters.split("\\s+"))
                .map(x -> x.toLowerCase())
                .collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        Arrays.stream(names.split("\\s+"))
                .filter(n -> firstLettersSet.contains(String.valueOf(n.charAt(0)).toLowerCase()))
                .sorted(String::compareTo)
                .limit(1)
                .forEach(x -> sb.append(x));
        System.out.println(sb.length() == 0 ? "No match" : sb);
    }
}
