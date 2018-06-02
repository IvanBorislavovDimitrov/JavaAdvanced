package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        int countOfLines = Integer.parseInt(input.readLine());
        for (int i = 0; i < countOfLines; i++) {
            String[] infoUsers = input.readLine().split("\\s+");
            String ip = infoUsers[0];
            String username = infoUsers[1];
            int duration = Integer.parseInt(infoUsers[2]);
            addLog(users, ip, username, duration);
        }

        printUsers(users);
    }

    private static void printUsers(Map<String, Map<String, Integer>> users) {
        users.entrySet().forEach(user -> {
            int totalDuration = user.getValue().values().stream().mapToInt(i -> i).sum();
            System.out.println(String.format("%s: %d %s", user.getKey(), totalDuration,
                    getIPs(user.getValue().entrySet())));
        });
    }

    private static String getIPs(Set<Map.Entry<String,Integer>> entries) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }


    private static void addLog(Map<String, Map<String, Integer>> users, String ip, String username, int duration) {
        if (!users.containsKey(username)) {
            users.put(username, new TreeMap<>());
            users.get(username).put(ip, duration);
        } else {
            if (!users.get(username).containsKey(ip)) {
                users.get(username).put(ip, duration);
            } else {
                users.get(username).put(ip, users.get(username).get(ip) + duration);
            }
        }
    }
}
