import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        System.out.println(
                Arrays.stream(line
                        .split("\\s*,\\s*"))
                        .map(Integer::parseInt)
                        .filter(x -> x % 2 == 0)
                        .collect(Collectors.toList())
                        .toString()
                        .replaceAll("[\\[\\]]", "")
        );

        System.out.println(
                Arrays.stream(line
                        .split("\\s*,\\s*"))
                        .map(Integer::parseInt)
                        .filter(x -> x % 2 == 0)
                        .sorted(Integer::compare)
                        .collect(Collectors.toList())
                        .toString()
                        .replaceAll("[\\[\\]]", "")
        );
    }
}
