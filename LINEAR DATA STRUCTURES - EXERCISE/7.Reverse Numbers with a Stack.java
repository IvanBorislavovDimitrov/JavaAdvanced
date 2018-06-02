package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumbersWithAStack {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            stack.push(number);
        }

        while (stack.size() > 0) {
            System.out.printf("%d ", stack.pop());
        }

        System.out.println();
    }
}
