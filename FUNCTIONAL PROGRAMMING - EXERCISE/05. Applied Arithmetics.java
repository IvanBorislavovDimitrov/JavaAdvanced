package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Consumer<int[]> add = x -> {
            for (int i = 0; i < x.length; x[i++]++);
        };
        Consumer<int[]> subtract = x -> {
            for (int i = 0; i < x.length; x[i++]--);
        };
        Consumer<int[]> multiply = x -> {
            for (int i = 0; i < x.length; x[i++] *= 2);
        };
        Consumer<int[]> print = x -> {
            for (int i : x) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        };
        Consumer<Integer> perform = x -> {
            try {
                String line;
                while (!"end".equals(line = input.readLine().toLowerCase())) {
                    switch (line) {
                        case "add":
                            add.accept(numbers);
                            break;
                        case "subtract":
                            subtract.accept(numbers);
                            break;
                        case "multiply":
                            multiply.accept(numbers);
                            break;
                        case "print":
                            print.accept(numbers);
                            break;

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        perform.accept(null);
        
    }
}
