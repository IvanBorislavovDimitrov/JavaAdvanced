package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterStudentsByPhone {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String[]> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            String[] currentNames = line.split("\\s+");
            names.add(currentNames);
        }


        names.stream().filter(x -> x[0].endsWith("14") || x[0].endsWith("15"))
                .forEach(x -> {
                    StringBuilder sb = new StringBuilder();
                    Arrays.stream(x).skip(1).forEach(z -> sb.append(z).append(" "));
                    System.out.println(sb);
                });
    }
}
