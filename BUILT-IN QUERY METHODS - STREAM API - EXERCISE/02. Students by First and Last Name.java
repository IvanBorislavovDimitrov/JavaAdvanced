package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsByFirstAndLastName {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            names.add(line);
        }

        names.stream().filter(n -> {
            String[] currentNames = n.split("\\s+");
            String firstName = currentNames[0];
            String secondName = currentNames[1];

            return firstName.compareTo(secondName) < 0;
        }).forEach(System.out::println);

    }
}
