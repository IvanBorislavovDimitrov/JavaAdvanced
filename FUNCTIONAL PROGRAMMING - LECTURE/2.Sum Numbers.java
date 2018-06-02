package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SortEvenNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Void> countAndSum = (x) -> {
          int[] numbers = Arrays.stream(x.split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
            System.out.println(String.format("Count = %d", numbers.length));
            System.out.println(String.format("Sum = %d", Arrays.stream(numbers).sum()));
            return null;
        };

        Void a = countAndSum.apply(input.readLine());
    }
}
