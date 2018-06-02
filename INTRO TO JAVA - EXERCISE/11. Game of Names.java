package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameOfNames {

    private static class Player {
        private String name;
        private int points;

        public Player() {
        }

        public Player(String name, int points) {
            this.name = name;
            this.points = points;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfPeople = Integer.parseInt(input.readLine());
        List<Player> players = new ArrayList<>(countOfPeople);
        for (int i = 0; i < countOfPeople; i++) {
            String playerName = input.readLine();
            int initialPoints = Integer.parseInt(input.readLine());
            Player player = createPlayer(playerName, initialPoints);
            players.add(player);
        }

        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o2.getPoints(), o1.getPoints());
            }
        });

        System.out.println(String.format("The winner is %s - %d points", players.get(0).getName(), players.get(0).getPoints()));
    }

    private static Player createPlayer(String playerName, int initialPoints) {
        Player player = new Player(playerName, initialPoints);
        for (int i = 0; i < playerName.length(); i++) {
            char letter = playerName.charAt(i);
            if (letter % 2 == 0) {
                player.setPoints(player.getPoints() + letter);
            } else {
                player.setPoints(player.getPoints() - letter);
            }
        }

        return player;
    }
}
