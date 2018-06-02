package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = input.readLine().split("\\s+");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(input.readLine()));
        }

        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(input.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                sb.append(integer).append(" ");
            }
        }

        System.out.println(sb);
    }
}
