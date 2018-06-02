package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine());
        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            String[] currentElements = input.readLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(currentElements));
        }

        System.out.println(chemicalElements.toString().replaceAll("[\\[\\]]", "").replaceAll(",", ""));
    }
}
