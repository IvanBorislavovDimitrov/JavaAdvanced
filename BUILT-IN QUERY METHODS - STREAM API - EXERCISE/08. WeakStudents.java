package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcellentStudents {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String[]> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            String[] currentNames = line.split("\\s+");
            names.add(currentNames);
        }

        names.stream()
                .filter(x -> Arrays.stream(Arrays.stream(x).skip(2)
                        .mapToInt(Integer::parseInt).toArray()).filter(z -> z <= 3).count() >= 2)
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
