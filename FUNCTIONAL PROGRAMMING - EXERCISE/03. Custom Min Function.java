package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Integer[] number = Arrays.stream(input.readLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> findMinElement = x -> {
            int min = x[0];
            for (Integer integer : x) {
                if (min > integer) {
                    min = integer;
                }
            }

            return min;
        };

        int min = findMinElement.apply(number);
        System.out.println(min);
    }
}
