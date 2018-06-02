package sets_and_maps_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountSameValuesInArray {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        Map<String, Integer> occurrences = new HashMap<>();
        fillOccurrence(numbers, occurrences);
        printNumbers(occurrences);
    }

    private static void printNumbers(Map<String, Integer> occurrences) {
        for (Map.Entry<String, Integer> pair : occurrences.entrySet()) {
            System.out.println(String.format("%s - %d times", pair.getKey(), pair.getValue()));
        }
    }

    private static void fillOccurrence(String[] numbers, Map<String, Integer> occurrences) {
        for (String number : numbers) {
            if (occurrences.containsKey(number)) {
                occurrences.put(number, occurrences.get(number) + 1);
            } else {
                occurrences.put(number, 1);
            }
        }
    }
}
