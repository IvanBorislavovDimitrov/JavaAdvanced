package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isFirstUpper1 = (x) -> x.charAt(0) == x.toUpperCase().charAt(0);

        List<String> list = Arrays.stream(input.readLine()
                .split("\\s+"))
                .filter(isFirstUpper1)
                .collect(Collectors.toList());

        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
