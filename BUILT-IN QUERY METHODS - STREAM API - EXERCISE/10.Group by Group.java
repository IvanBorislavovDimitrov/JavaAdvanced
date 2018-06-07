package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String[]> names = new ArrayList<>();
        while (!"END".equals(line = input.readLine())) {
            String[] currentNames = line.split("\\s+");
            names.add(currentNames);
        }


        names.stream().collect(
                Collectors.groupingBy(x -> x[2]))
                .forEach((z1, z2) -> {
                    System.out.print(z1 + " - ");
                    StringBuilder sb = new StringBuilder();
                    for (String[] s : z2) {
                        sb.append(s[0]).append(" ").append(s[1]).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                    System.out.println(sb);
                });


    }
}
