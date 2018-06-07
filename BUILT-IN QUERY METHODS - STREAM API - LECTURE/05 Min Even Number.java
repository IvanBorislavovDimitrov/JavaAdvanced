package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class MinEvenNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String numbers = input.readLine();

        OptionalDouble num = Arrays.stream(numbers.split("\\s+"))
                .filter(x -> x.length() > 0)
                .mapToDouble(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .min();

        String number = num.isPresent() ? String.format("%.2f", num.getAsDouble()) : "No match";

        System.out.println(number);
    }
}
