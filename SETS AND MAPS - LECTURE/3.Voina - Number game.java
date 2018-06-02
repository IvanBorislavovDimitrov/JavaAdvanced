package sets_and_maps_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class VoinaNumberGame {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> firstPlayerCards = new ArrayDeque<>();
        ArrayDeque<Integer> secondPlayerCards = new ArrayDeque<>();

        int[] firstPlayerCardsArray = Arrays
                .stream(input.readLine().split("\\s"))
                .distinct()
                .limit(20)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondPlayerCardsArray = Arrays
                .stream(input.readLine()
                .split("\\s"))
                .distinct()
                .limit(20)
                .mapToInt(Integer::parseInt)
                .toArray();

        fillPlayerCards(firstPlayerCards, firstPlayerCardsArray);
        fillPlayerCards(secondPlayerCards, secondPlayerCardsArray);

        game(firstPlayerCards, secondPlayerCards);

        printWinner(firstPlayerCards, secondPlayerCards);
    }

    private static void game(ArrayDeque<Integer> firstPlayerCards, ArrayDeque<Integer> secondPlayerCards) {
        int iteration = 0;
        while (iteration < 50 && ! firstPlayerCards.isEmpty() && ! secondPlayerCards.isEmpty()) {
            int firstPlayerCard = firstPlayerCards.pop();
            int secondPlayerCard = secondPlayerCards.pop();
            if (firstPlayerCard > secondPlayerCard) {
                if (! isUnique(firstPlayerCards, firstPlayerCard)) {
                    firstPlayerCards.offer(firstPlayerCard);
                }
                if (! isUnique(firstPlayerCards, secondPlayerCard)) {
                    firstPlayerCards.offer(secondPlayerCard);
                }

            } else if (firstPlayerCard < secondPlayerCard) {
                if (! isUnique(secondPlayerCards, firstPlayerCard)) {
                    secondPlayerCards.offer(firstPlayerCard);
                }
                if (! isUnique(secondPlayerCards, secondPlayerCard)) {
                    secondPlayerCards.offer(secondPlayerCard);
                }

            }
            iteration++;
        }
    }

    private static void printWinner(ArrayDeque<Integer> firstPlayer, ArrayDeque<Integer> secondPlayer) {
        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }

    private static void fillPlayerCards(ArrayDeque<Integer> playerCards, int[] cards) {
        for (int card : cards) {
            playerCards.offer(card);
        }
    }

    private static boolean isUnique(ArrayDeque<Integer> cards, int card) {
        return cards.contains(card);
    }
}
