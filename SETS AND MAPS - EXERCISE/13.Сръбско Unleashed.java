package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SrpskoUnleashed {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> venues = new LinkedHashMap<>();
        String line;

        while (!"End".equals(line = input.readLine())) {
            if (!valid(line)) {
                continue;
            }
            String[] infoAboutConcert = getInfoAboutConcert(line);
            String singerName = infoAboutConcert[0];
            String venueName = infoAboutConcert[1];
            int ticketPrice = Integer.parseInt(infoAboutConcert[2]);
            int ticketsCount = Integer.parseInt(infoAboutConcert[3]);
            addSinger(venues, singerName, venueName, ticketPrice, ticketsCount);
        }

        printVenues(venues);
    }

    private static void printVenues(Map<String, Map<String, Long>> venues) {
        venues.forEach((venue, singers) -> {
            System.out.println(venue);
            singers.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(singer -> System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue())));
        });
    }

    private static void addSinger(Map<String, Map<String, Long>> venues, String singerName,
                                  String venueName, int ticketPrice, int ticketsCount) {
        if (!venues.containsKey(venueName)) {
            venues.put(venueName, new LinkedHashMap<>());
            long price = ticketPrice * ticketsCount;
            venues.get(venueName).put(singerName, price);
        } else {
            if (!venues.get(venueName).containsKey(singerName)) {
                long price = ticketPrice * ticketsCount;
                venues.get(venueName).put(singerName, price);
            } else {
                long price = venues.get(venueName).get(singerName) + (ticketPrice * ticketsCount);
                venues.get(venueName).put(singerName, price);
            }
        }
    }

    private static String[] getInfoAboutConcert(String line) {
        String[] splitByMonkeyA = line.split("@");
        String singerName = splitByMonkeyA[0].trim();
        int indexOfFirstDigit = indexOfFirstDigit(splitByMonkeyA[1]);
        String venueName = splitByMonkeyA[1].substring(0, indexOfFirstDigit).trim();
        String[] numbers = line.substring(indexOfFirstDigit(line)).split("\\s");
        String ticketPrice = numbers[0];
        String ticketsCount = numbers[1];
        String[] info = new String[4];
        info[0] = singerName;
        info[1] = venueName;
        info[2] = ticketPrice;
        info[3] = ticketsCount;

        return info;
    }

    private static int indexOfFirstDigit(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    private static boolean valid(String line) {
        if (!line.contains("@")) {
            return false;
        }
        int index = line.indexOf('@');
        if (line.charAt(index - 1) != ' ') {
            return false;
        }
        index = line.lastIndexOf(' ');
        index = line.lastIndexOf(' ', index - 1);

        return Character.isDigit(line.charAt(index + 1));
    }
}
