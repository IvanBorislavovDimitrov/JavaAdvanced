import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {

    private static class Opponent {
        private String name;
        private String result;

        public Opponent(String name, String result) {
            this.name = name;
            this.result = result;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Opponent>> teamsWithOpponents = new HashMap<>();

        String line;
        while (!"Season End".equals(line = input.readLine())) {
            String[] teamsWithResults = line.split(" result ");
            String[] teams = teamsWithResults[0].split(" - ");
            int[] results = Arrays.stream(teamsWithResults[1].split(":")).mapToInt(Integer::parseInt).toArray();

            String homeTeam = teams[0];
            String awayTeam = teams[1];
            int homeTeamResult = results[0];
            int awayTeamResult = results[1];

            addMatch(teamsWithOpponents, homeTeam, awayTeam, homeTeamResult, awayTeamResult);
        }

        String[] teamsToPrint = input.readLine().split(",\\s+");
        printTeams(teamsWithOpponents, teamsToPrint);
    }

    private static void printTeams(Map<String, List<Opponent>> teamsWithOpponents, String[] teamsToPrint) {
        for (String team : teamsToPrint) {
            teamsWithOpponents.get(team).stream()
                    .sorted(Comparator.comparing(Opponent::getName))
                    .forEach(x -> {
                        System.out.println(String.format("%s - %s -> %s", team, x.getName(), x.getResult()));
                    });
        }
    }

    private static void addMatch(Map<String, List<Opponent>> teamsWithOpponents, String homeTeam, String awayTeam,
                                 int homeTeamResult, int awayTeamResult) {
        teamsWithOpponents.putIfAbsent(homeTeam, new ArrayList<>());
        teamsWithOpponents.putIfAbsent(awayTeam, new ArrayList<>());

        String homeTeamScore = homeTeamResult + ":" + awayTeamResult;
        teamsWithOpponents.get(homeTeam).add(new Opponent(awayTeam, homeTeamScore));

        String awayTeamScore = awayTeamResult + ":" + homeTeamResult;
        teamsWithOpponents.get(awayTeam).add(new Opponent(homeTeam, awayTeamScore));
    }
}
