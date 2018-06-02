package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatingExpressing {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        double a = Double.parseDouble(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Double.parseDouble(numbers[2]);

        double f1 = Math.pow(((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2))),
                (a + b + c) / Math.sqrt(c));

        double f2 = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a - b);

        double diff = Math.abs((a + b + c) / 3 - (f1 + f2) / 2);

        System.out.println(String.format("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff));
        String stop = "";
    }
}
