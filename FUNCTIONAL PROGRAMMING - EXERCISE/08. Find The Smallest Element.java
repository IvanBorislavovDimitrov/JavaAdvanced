package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> findSmallest = arr -> {
            int min = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[min] >= arr[i]) {
                    min = i;
                }
            }

            return min;
        };

        System.out.println(findSmallest.apply(numbers));
    }
}
