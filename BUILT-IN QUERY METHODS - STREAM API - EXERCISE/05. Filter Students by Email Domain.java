package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByEmailDomain {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            names.add(line);
        }

        names.stream().filter(x -> x.endsWith("@gmail.com")).forEach(x -> {
            String[] info = x.split("\\s+");
            System.out.println(info[0] + " " + info[1]);
        });
    }
}
