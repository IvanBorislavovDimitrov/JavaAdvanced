package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsByGroup {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new HashMap<>();
        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] studentInfo = line.split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);

            students.putIfAbsent(firstName + " " + lastName, age);
        }

        students.entrySet().stream()
                .filter(x -> x.getValue() == 2)
                .sorted((x1, x2) -> {
                    String firstNameX1 = x1.getKey().split(" ")[0];
                    String firstNameX2 = x2.getKey().split(" ")[0];

                    return firstNameX1.compareTo(firstNameX2);
                }).forEach(x -> System.out.println(x.getKey()));
    }
}
