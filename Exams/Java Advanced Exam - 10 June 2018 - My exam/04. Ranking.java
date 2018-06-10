import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ranking {

    private static class UserInfo {
        private String contest;
        private Integer points;

        public UserInfo() {
        }

        public UserInfo(String contest, Integer points) {
            this.contest = contest;
            this.points = points;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contest = new HashMap<>();
        Map<String, List<UserInfo>> users = new HashMap<>();

        String line;
        while (!"end of contests".equals(line = input.readLine())) {
            String[] contestInfo = line.split(":");
            contest.put(contestInfo[0], contestInfo[1]);
        }

        while (!"end of submissions".equals(line = input.readLine())) {
            String[] submissionInfo = line.split("[=>]+");
            String contestName = submissionInfo[0];
            String password = submissionInfo[1];
            String username = submissionInfo[2];
            int submissionPoints = Integer.parseInt(submissionInfo[3]);

            if (!contest.containsKey(contestName)) {
                continue;
            } else if (!contest.get(contestName).equals(password)) {
                continue;
            }

            users.putIfAbsent(username, new ArrayList<>());
            if (users.get(username).stream().anyMatch(x -> x.getContest().equals(contestName))) {
                for (UserInfo userInfo : users.get(username)) {
                    if (userInfo.getContest().equals(contestName)) {
                        if (userInfo.getPoints() < submissionPoints) {
                            userInfo.setPoints(submissionPoints);
                        }
                    }
                }
            } else {
                users.get(username).add(new UserInfo(contestName, submissionPoints));
            }
        }

        Map.Entry<String, List<UserInfo>> bestCandidate = getBestCandidate(users);
        System.out.println(String.format("Best candidate is %s with total %d points.", bestCandidate.getKey(),
                bestCandidate.getValue().stream().mapToLong(x -> x.getPoints()).sum()));
        System.out.println("Ranking:");
        users.entrySet().stream()
                .sorted((x1, x2) -> x1.getKey().compareTo(x2.getKey()))
                .forEach((x1) -> {
                    System.out.println(x1.getKey());
                    x1.getValue().sort((z1, z2) -> Integer.compare(z2.getPoints(), z1.getPoints()));
                    x1.getValue()
                            .forEach(x -> System.out.println(String.format("#  %s -> %d", x.getContest(), x.getPoints())));
                });
    }

    private static Map.Entry<String, List<UserInfo>> getBestCandidate(Map<String, List<UserInfo>> users) {
       return users.entrySet().stream().min((x1, x2) -> {
           long x1Points = x1.getValue().stream().mapToLong(UserInfo::getPoints).sum();
           long x2Points = x2.getValue().stream().mapToLong(UserInfo::getPoints).sum();

           return Long.compare(x2Points, x1Points);
       }).get();
    }
}
