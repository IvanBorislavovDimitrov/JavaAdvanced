package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String[]> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            String[] currentNames = line.split("\\s+");
            names.add(currentNames);
        }

        names.stream().sorted(Comparator.comparing(((String[] x1) -> x1[1]))
                .thenComparing((String[] x2) -> x2[0], Comparator.reverseOrder()))
                .forEach(x -> System.out.println(String.format("%s %s", x[0], x[1])));


    }
}
