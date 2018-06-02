package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String line;
        while (!"JOKER".equals(line = input.readLine())) {
            String playerName = line.substring(0, line.indexOf(":"));
            line = line.substring(line.indexOf(":") + 2);
            String[] cards = line.split(",\\s+");

            if (! players.containsKey(playerName)) {
                Set<String> playerCards = new HashSet<>();
                Collections.addAll(playerCards, cards);
                players.put(playerName, playerCards);
            } else {
                for (String card : cards) {
                    players.get(playerName).add(card);
                }
            }
        }

        printPlayers(players);
    }

    private static void printPlayers(Map<String, Set<String>> players) {
        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            System.out.println(String.format("%s: %d", player.getKey(), getPoints(player.getValue())));
        }
    }

    private static int getPoints(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            char cardPaint = card.charAt(card.length() - 1);
            int cardPaintValue = colorPoints(cardPaint);
            int cardPointsValue = cardPoints(card.substring(0, card.length() - 1));
            int cardValue = cardPaintValue * cardPointsValue;
            sum += cardValue;
        }

        return sum;
    }

    private static int colorPoints(char color) {
        switch (color) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
        }

        return 0;
    }

    private static int cardPoints(String card) {
        switch (card) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }

        return 0;
    }
}
