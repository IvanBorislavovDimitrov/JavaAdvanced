package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TakeTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(input.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}
