package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BoundedNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] boundaries = Arrays.stream(input.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int leftBound = boundaries[0];
        int rightBound = boundaries[1];

        Arrays.stream(input.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(x -> x >= leftBound && x <= rightBound)
                .forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}
