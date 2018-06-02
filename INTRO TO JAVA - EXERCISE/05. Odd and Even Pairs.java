package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddAndEvenPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length; i += 2) {
            if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0) {
                System.out.println(String.format("%d, %d -> both are even", numbers[i], numbers[i + 1]));
            } else if (numbers[i] % 2 != 0 && numbers[i + 1] % 2 != 0) {
                System.out.println(String.format("%d, %d -> both are odd", numbers[i], numbers[i + 1]));
            } else {
                System.out.println(String.format("%d, %d -> different", numbers[i], numbers[i + 1]));
            }
        }
    }
}
