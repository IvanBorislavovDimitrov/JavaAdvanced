package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAndSumIntegers {

    public static void main(String[] args) throws IOException {
        Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split("\\s+"))
                .filter(x -> {
                    try {
                        Integer.parseInt(x);
                    } catch (NumberFormatException e) {
                        return false;
                    }

                    return true;
                })
                .filter(x -> x.length() > 0)
                .mapToInt(Integer::parseInt)
                .reduce((x1, x2) -> x1 + x2).ifPresentOrElse(System.out::println, () -> System.out.println("No match"));
    }
}
