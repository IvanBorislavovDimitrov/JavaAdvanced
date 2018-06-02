package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterMode {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> participants = Arrays.stream(input.readLine().split("\\s+")).collect(Collectors.toList());

        List<String> startsWithFilter = new ArrayList<>();
        List<String> endsWithFilter = new ArrayList<>();
        List<Integer> lengthFilter = new ArrayList<>();
        List<String> containsFilter = new ArrayList<>();

        // True for arr, False for remove
        Predicate<String> addOrRemove = x -> x.equals("Add filter");

        String line;
        while (!"Print".equals(line = input.readLine())) {
            String[] filterInfo = line.split(";");
            String addRemoveFilter = filterInfo[0];
            String condition = filterInfo[1];
            String symbol = filterInfo[2];

            if (addOrRemove.test(addRemoveFilter)) {
                switch (condition) {
                    case "Starts with":
                        startsWithFilter.add(symbol);
                        break;
                    case "Ends with":
                        endsWithFilter.add(symbol);
                        break;
                    case "Length":
                        lengthFilter.add(Integer.parseInt(symbol));
                        break;
                    case "Contains":
                        containsFilter.add(symbol);
                        break;
                }
            } else {
                switch (condition) {
                    case "Starts with":
                        startsWithFilter.remove(symbol);
                        break;
                    case "Ends with":
                        endsWithFilter.remove(symbol);
                        break;
                    case "Length":
                        lengthFilter.remove(Integer.parseInt(symbol));
                        break;
                    case "Contains":
                        containsFilter.remove(symbol);
                        break;
                }
            }
        }
        Predicate<String> areConditionsGood = x -> {
            for (String s : startsWithFilter) {
                if (x.startsWith(s)) {
                    return true;
                }
            }
            for (String s : endsWithFilter) {
                if (x.endsWith(s)) {
                    return true;
                }
            }
            for (Integer len : lengthFilter) {
                if (x.length() == len) {
                    return true;
                }
            }
            for (String s : containsFilter) {
                if (x.contains(s)) {
                    return true;
                }
            }

            return false;
        };

        participants.forEach(x -> {
            if (areConditionsGood.negate().test(x)) {
                System.out.printf("%s ", x);
            }
        });

        System.out.println();
    }
}
