package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(input.readLine().split("\\s+"))
                .map(x -> x.toUpperCase())
                .forEach(x -> System.out.printf("%s ", x));
        System.out.println();
    }
}
