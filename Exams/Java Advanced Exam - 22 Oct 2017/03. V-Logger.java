import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class VLogger {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> vloggers = new HashMap<>();
        String line;
        while (!"Statistics".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String vloggerName = lineInfo[0];
            String command = lineInfo[1];

            switch (command) {
                case "joined":
                    addVlogger(vloggers, vloggerName);
                    break;
                case "followed":
                    String followVloggerName = lineInfo[2];
                    followVlogger(vloggers, vloggerName, followVloggerName);
                    break;
            }
        }

        printVloggers(vloggers);
    }

    private static void printVloggers(Map<String, Set<String>> vloggers) {
        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", vloggers.size()));
        Map.Entry<String, Set<String>> bestVlogger = getMostPopularVlogger(vloggers);
        int count = 1;
        System.out.println(String.format("%d. %s : %d followers, %d following", count++, bestVlogger.getKey(),
                getCountOfVloggerFollowers(vloggers, bestVlogger.getKey()), vloggers.get(bestVlogger.getKey()).size()));
        Set<String> followers = new TreeSet<>();
        for (Map.Entry<String, Set<String>> vlogger : vloggers.entrySet()) {
            if (vlogger.getValue().contains(bestVlogger.getKey())) {
                followers.add("*  " + vlogger.getKey());
            }
        }

        for (String follower : followers) {
            System.out.println(follower);
        }
        
        for (Map.Entry<String, Set<String>> vlogger : vloggers.entrySet().stream().sorted((v1, v2) -> {
            int v1Followers = getCountOfVloggerFollowers(vloggers, v1.getKey());
            int v2Followers = getCountOfVloggerFollowers(vloggers, v2.getKey());

            if (v1Followers == v2Followers) {
                return Integer.compare(v1.getValue().size(), v2.getValue().size());
            }

            return Integer.compare(v2Followers, v1Followers);
        }).collect(Collectors.toList())) {
            if (!vlogger.getKey().equals(bestVlogger.getKey())) {
                System.out.println(String.format("%d. %s : %d followers, %d following",
                        count++, vlogger.getKey(), getCountOfVloggerFollowers(vloggers, vlogger.getKey()),
                        vlogger.getValue().size()));
            }
        }
    }

    private static int getCountOfVloggerFollowers(Map<String, Set<String>> vloggers, String vloggerName) {
        int count = 0;
        for (Map.Entry<String, Set<String>> stringSetEntry : vloggers.entrySet()) {
            if (stringSetEntry.getValue().contains(vloggerName)) {
                count++;
            }
        }

        return count;
    }

    private static Map.Entry<String, Set<String>> getMostPopularVlogger(Map<String, Set<String>> vloggers) {

        return vloggers.entrySet().stream().sorted((f1, f2) -> {
            int countOfFirstVloggerFollowers = 0;
            for (Map.Entry<String, Set<String>> totVloggers : vloggers.entrySet()) {
                if (totVloggers.getValue().contains(f1.getKey())) {
                    countOfFirstVloggerFollowers++;
                }
            }

            int countOfSecondVloggerFollowers = 0;
            for (Map.Entry<String, Set<String>> totVloggers : vloggers.entrySet()) {
                if (totVloggers.getValue().contains(f2.getKey())) {
                    countOfSecondVloggerFollowers++;
                }
            }

            if (countOfFirstVloggerFollowers == countOfSecondVloggerFollowers) {
                return Integer.compare(f1.getValue().size(), f2.getValue().size());
            }

            return Integer.compare(countOfSecondVloggerFollowers, countOfFirstVloggerFollowers);
        }).findFirst().get();
    }

    private static void followVlogger(Map<String, Set<String>> vloggers, String vloggerName, String followVloggerName) {
        if (!vloggers.containsKey(vloggerName) || !vloggers.containsKey(followVloggerName)) {
            return;
        }

        if (vloggerName.equals(followVloggerName)) {
            return;
        }

        vloggers.get(vloggerName).add(followVloggerName);
    }

    private static void addVlogger(Map<String, Set<String>> vloggers, String vloggerName) {
        if (!vloggers.containsKey(vloggerName)) {
            vloggers.put(vloggerName, new TreeSet<>());
        }
    }
}
