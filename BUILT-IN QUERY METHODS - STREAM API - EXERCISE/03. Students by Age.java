package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            names.add(line);
        }

        names.stream().filter(x -> {
            String[] studentInfo = x.split("\\s+");
            int age = Integer.parseInt(studentInfo[2]);

            return age <= 24 && age >= 18;
        }).forEach(System.out::println);
    }
}
