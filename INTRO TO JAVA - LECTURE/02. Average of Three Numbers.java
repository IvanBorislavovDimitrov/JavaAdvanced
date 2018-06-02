package introduction_to_java_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AverageOfThreeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double sumOfNumbers = Arrays.stream(input.readLine().split("\\s+")).mapToDouble(Double::parseDouble).average().orElse(0);
        System.out.println(String.format("%.2f", sumOfNumbers));
    }
}
