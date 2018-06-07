package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MapDistricts {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> districts = new HashMap<>();

        String strDistricts = input.readLine();
        int minPopulation = Integer.parseInt(input.readLine());

        Arrays.stream(strDistricts.split("\\s+"))
                .forEach(x -> {
                    String[] districtAndPopulation = x.split(":");
                    String districtName = districtAndPopulation[0];
                    int populationCount = Integer.parseInt(districtAndPopulation[1]);
                    districts.putIfAbsent(districtName, new ArrayList<>());
                    districts.get(districtName).add(populationCount);
                });

        Map<String, List<Integer>> sortedAndFilteredCities =
                districts.entrySet().stream()
                        .filter(x -> {
                            int totalPopulation = x.getValue().stream().mapToInt(i -> i).sum();
                            return totalPopulation >= minPopulation;
                        })
                        .sorted((p1, p2) -> {
                            int totalPopulationP1 = p1.getValue().stream().mapToInt(i -> i).sum();
                            int totalPopulationP2 = p2.getValue().stream().mapToInt(i -> i).sum();

                            return Integer.compare(totalPopulationP2, totalPopulationP1);
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (v1, v2) -> {
                                    throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));
                                },
                                LinkedHashMap::new));

        sortedAndFilteredCities.forEach((pair, value) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(pair).append(": ");
            value.sort(Comparator.comparing(x -> x, Comparator.reverseOrder()));
            value.stream().limit(5).forEach(p -> sb.append(p).append(" "));
            System.out.println(sb);
        });
    }
}
