package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = input.readLine().split("\\s+");
        double sum = 0;
        for (String word : words) {
            double currNumber = Double.parseDouble(word.substring(1, word.length() - 1));
            char firstLet = word.charAt(0);
            char lastLet = word.charAt(word.length() - 1);
            sum += getCurrentSum(currNumber, firstLet, lastLet);
        }

        System.out.println(String.format("%.2f", sum));
    }

    private static double getCurrentSum(double number, char firstLetter, char lastLetter) {
        double numberToCalculate = number;
        if (Character.isUpperCase(firstLetter)) {
            numberToCalculate /= (firstLetter - 'A' + 1);
        } else {
            numberToCalculate *= (firstLetter - 'a' + 1);
        }

        if (Character.isUpperCase(lastLetter)) {
            numberToCalculate -= (lastLetter - 'A' + 1);
        } else {
            numberToCalculate += (lastLetter - 'a' + 1);
        }

        return numberToCalculate;
    }
}
