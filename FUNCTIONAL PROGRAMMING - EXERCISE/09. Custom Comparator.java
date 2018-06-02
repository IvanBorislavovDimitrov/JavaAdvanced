package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(input.readLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Comparator<Integer> myCompare = (x1, x2) -> {
            if (x1 % 2 == 0 && x2 % 2 != 0) {
                return -1;
            } else if (x1 % 2 != 0 && x2 % 2 != 0) {
                return x1 - x2;
            } else if (x1 % 2 == 0 && x2 % 2 == 0) {
                return x1 - x2;
            }
            return 1;
        };

        Arrays.sort(numbers, myCompare);

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }

        System.out.println();
    }
}
