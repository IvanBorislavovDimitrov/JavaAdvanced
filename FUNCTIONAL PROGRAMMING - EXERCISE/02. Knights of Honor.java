package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] names = input.readLine().split("\\s+");
        Consumer<String[]> printFormattedNames = (x) -> {
            Arrays.stream(x).forEach(n -> System.out.println(String.format("Sir %s", n)));
        };

        printFormattedNames.accept(names);
    }
}
