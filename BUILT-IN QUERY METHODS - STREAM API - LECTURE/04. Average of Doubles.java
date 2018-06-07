package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AverageOfDoubles {

    public static void main(String[] args) throws IOException {

        Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split("\\s+"))
                .filter(x -> x.length() > 0)
                .mapToDouble(Double::parseDouble)
                .average()
                .ifPresentOrElse(x -> System.out.printf("%.2f", x), () -> System.out.println("No match"));
    }
}
