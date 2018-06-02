package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Integer number = Integer.parseInt(input.readLine());
        
        Integer[] numbers = Arrays.stream(input.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        
        Predicate<Integer> isDivisible = x -> Arrays.stream(numbers).filter(z -> x % z == 0).count() == numbers.length;

        IntStream.range(1, number + 1)
                .forEach(x -> {
                    if (isDivisible.test(x)) {
                        System.out.printf("%d ", x);
                    }
                });
    }
}
