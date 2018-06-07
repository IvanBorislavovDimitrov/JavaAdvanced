package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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


        names.stream().filter(x -> x[2].startsWith("02") || x[2].startsWith("+3592"))
                .forEach(x -> {
                    System.out.println(x[0] + " " + x[1]);
                });
    }
}
