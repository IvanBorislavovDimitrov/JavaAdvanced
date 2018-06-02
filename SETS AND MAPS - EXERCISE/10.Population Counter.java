package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        String line;
        while (!"report".equals(line = input.readLine())) {
            String[] countryInfo = line.split("\\|");
            String town = countryInfo[0];
            String country = countryInfo[1];
            long townPopulation = Long.parseLong(countryInfo[2]);
            addTown(countries, country, town, townPopulation);
        }

        printCountries(countries);
    }

    private static void printCountries(Map<String, Map<String, Long>> countries) {
        countries
                .entrySet()
                .stream()
                .sorted((first, second) -> {
            long firstCountryPop = first.getValue().values().stream().mapToLong(l -> l).sum();
            long secondSumPop = second.getValue().values().stream().mapToLong(l -> l).sum();

            return Long.compare(secondSumPop, firstCountryPop);
        }).forEach(country -> {
            long totalPop = country
                    .getValue()
                    .values()
                    .stream()
                    .mapToLong(l -> l).sum();

            System.out.println(String.format("%s (total population: %d)", country.getKey(), totalPop));

            country.getValue().entrySet().stream().sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue()))
            .forEach(x -> {
                System.out.println(String.format("=>%s: %d", x.getKey(), x.getValue()));
            });
        });
    }

    private static void addTown(Map<String, Map<String, Long>> countries, String countryName, String townName, Long townPop) {
        if (!countries.containsKey(countryName)) {
            countries.put(countryName, new LinkedHashMap<>());
            countries.get(countryName).put(townName, townPop);
        } else {
            if (!countries.get(countryName).containsKey(townName)) {
                countries.get(countryName).put(townName, townPop);
            } else {
                countries.get(countryName).put(townName, townPop);
            }
        }
    }
}
