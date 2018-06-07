package last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DHARMAInitiative {

    private static String[] stations = {"Hydra", "Arrow", "Orchid", "Flame", "Pearl"};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, String>> stations = new HashMap<>();
        initMap(stations);
        String line;
        while (!"Recruit".equals(line = input.readLine())) {
            String[] personInfo = line.split("\\s*:\\s*");
            String personName = personInfo[0];
            String facilityNumber = personInfo[1];
            String station = personInfo[2];
            addPerson(stations, personName, facilityNumber, station);
        }

        String command = input.readLine();
        if ("DHARMA Initiative".equals(command)) {
            printStations(stations);
        } else {
            printStation(stations, command);
        }
    }

    private static void printStation(Map<String, Map<String, String>> stations, String station) {
        if (!isStationValid(station)) {
            System.out.println("DHARMA Initiative does not have such a station!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        stations.entrySet()
                .stream()
                .filter(x -> x.getKey().equals(station))
                .forEach(s -> {
                    System.out.println(String.format("The %s station: %s", s.getKey(), getFullNameOfStation(s.getKey())));
                    s.getValue().entrySet()
                            .stream()
                            .sorted((x1, x2) -> {
                                Long fac1 = Long.parseLong(x1.getKey());
                                Long fac2 = Long.parseLong(x2.getKey());

                                return fac2.compareTo(fac1);
                            }).forEach(p -> {
                        sb.append(String.format("###%s - %s", p.getValue(), p.getKey())).append(System.lineSeparator());
                    });
                });
        System.out.println(sb.length() == 0 ? "No recruits." : sb);
    }

    private static void printStations(Map<String, Map<String, String>> stations) {
        stations.entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    if (s1.getValue().size() == s2.getValue().size()) {
                        return s1.getKey().compareTo(s2.getKey());
                    }

                    return Integer.compare(s2.getValue().size(), s1.getValue().size());
                }).forEach(x -> {
            System.out.println(String.format("The %s has %d DHARMA recruits in it.", x.getKey(), x.getValue().size()));
        });
    }

    private static void initMap(Map<String, Map<String, String>> stations) {
        for (String station : DHARMAInitiative.stations) {
            stations.put(station, new HashMap<>());
        }
    }

    private static void addPerson(Map<String, Map<String, String>> stations, String personName,
                                  String facilityNumber, String station) {
        if (!isStationValid(station)) {
            return;
        }

        if (stations.get(station).containsKey(facilityNumber)) {
            return;
        }
        stations.get(station).put(facilityNumber, personName);

    }

    private static boolean isStationValid(String station) {
        for (String s : stations) {
            if (station.equals(s)) {
                return true;
            }
        }

        return false;
    }

    private static String getFullNameOfStation(String station) {
        Map<String, String> stations = new HashMap<>();
        stations.put("Hydra", "Zoological Research.");
        stations.put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
        stations.put("Flame", "Communication.");
        stations.put("Pearl", "Psychological Research and/or Observation.");
        stations.put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");

        return stations.get(station);
    }
}
