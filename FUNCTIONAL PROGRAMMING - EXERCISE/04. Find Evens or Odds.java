package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FindEvensOrOdds {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] boundaries = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = input.readLine();
        switch (condition) {
            case "odd":
                IntStream.range(boundaries[0], boundaries[1] + 1)
                        .filter(x -> x % 2 != 0)
                        .forEach(x -> System.out.print(x + " "));
                break;
            case "even":
                IntStream.range(boundaries[0], boundaries[1] + 1)
                        .filter(x -> x % 2 == 0)
                        .forEach(x -> System.out.print(x + " "));
                break;
        }
    }
}
