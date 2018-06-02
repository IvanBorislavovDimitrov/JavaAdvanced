package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> mining = new LinkedHashMap<>();
        String line;
        while (!"stop".equals(line = input.readLine())) {
            Integer size = Integer.parseInt(input.readLine());
            if (mining.containsKey(line)) {
                mining.put(line, mining.get(line) + size);
            } else {
                mining.put(line, size);
            }
        }

        mining.forEach((x1, x2) -> System.out.println(String.format("%s -> %d", x1, x2)));
    }
}
