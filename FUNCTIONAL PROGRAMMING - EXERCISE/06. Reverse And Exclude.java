package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(input.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(input.readLine());
        Consumer<List<Integer>> reverse = numbs -> {
            for (int i = 0; i < numbers.size() / 2; i++) {
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(numbers.size() - 1 - i));
                numbers.set(numbers.size() - 1 - i, temp);
            }
        };

        reverse.accept(numbers);

        BiConsumer<List<Integer>, Integer> printDivisible = (numbs, x) -> {
            numbs.stream().filter(d -> d % x != 0).forEach(d -> System.out.printf("%d ", d));
            System.out.println();
        };

        printDivisible.accept(numbers, n);
    }
}
