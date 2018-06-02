import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class HandScore {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = input.readLine().split("\\s+");
        System.out.println(getSum(cards));
    }

    private static int getSum(String[] cards) {
        int startCard = 0;
        int totalSum = 0;
        while (startCard < cards.length) {
            int cardValue = getCardValue(cards[startCard]);
            char cardSuit = cards[startCard].charAt(cards[startCard].length() - 1);
            if (startCard == cards.length - 1) {
                totalSum += cardValue;
                break;
            }
            int count = 1;
            char nextCardSuit = cards[startCard + 1].charAt(cards[startCard + 1].length() - 1);
            int currentSum = cardValue;
            int currentStart = startCard + 1;
            while (cardSuit == nextCardSuit) {
                if (currentStart == cards.length) {
                    currentStart++;
                    break;
                }
                currentSum += getCardValue(cards[currentStart]);
                count++;
                if (currentStart + 1 >= cards.length) {
                    currentStart++;
                    break;
                }
                nextCardSuit = cards[currentStart + 1].charAt(cards[currentStart + 1].length() - 1);
                currentStart++;
            }
            startCard = currentStart - 1;
            totalSum += count * currentSum;
            startCard++;
        }

        return totalSum;
    }

    private static int getCardValue(String card) {
        String cardPower = card.substring(0, card.length() - 1);
        switch (cardPower) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                return Integer.parseInt(cardPower);
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
        }

        return 0;
    }
}
