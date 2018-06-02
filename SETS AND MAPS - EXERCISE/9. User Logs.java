package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserLogs {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, List<String>>> users = new TreeMap<>();
        String line;
        while (!"end".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String ip = lineInfo[0].split("=")[1];
            String message = lineInfo[1].split("=")[1];
            String username = lineInfo[2].split("=")[1];
            addRecord(users, ip, message, username);
        }

        printRecords(users);
    }

    private static void printRecords(Map<String, Map<String,  List<String>>> users) {
        for (Map.Entry<String, Map<String, List<String>>> user : users.entrySet()) {
            System.out.println(user.getKey() + ":");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<String>> ip : user.getValue().entrySet()) {
                sb.append(String.format("%s => %d, ", ip.getKey(), ip.getValue().size()));
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb+ ".");
        }
    }

    private static void addRecord(Map<String, Map<String,  List<String>>> users, String ip, String message, String username) {
        if (! users.containsKey(username)) {
            users.put(username, new LinkedHashMap<>());
            users.get(username).put(ip, new ArrayList<>());
            users.get(username).get(ip).add(message);
        } else {
            if (! users.get(username).containsKey(ip)) {
                users.get(username).put(ip, new ArrayList<>());
                users.get(username).get(ip).add(message);
            } else {
                users.get(username).get(ip).add(message);
            }
        }
    }
}
