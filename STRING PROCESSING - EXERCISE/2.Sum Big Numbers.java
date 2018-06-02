package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String firstNumber = input.readLine();
        String secondNumber = input.readLine();

        System.out.println(sumNumbers(firstNumber, secondNumber));
    }

    private static String sumNumbers(String firstNumber, String secondNumber) {
        StringBuilder result = new StringBuilder();
        int maxLength = firstNumber.length() > secondNumber.length() ? firstNumber.length() : secondNumber.length();
        String format = "%" + maxLength + "s";
        firstNumber = String.format(format, firstNumber).replaceAll(" ", "0");
        secondNumber = String.format(format, secondNumber).replaceAll(" ", "0");

        int reminder = 0;
        for (int i = firstNumber.length() - 1; i >= 0; i--) {
            int firstDigit = firstNumber.charAt(i) - '0';
            int secondDigit = secondNumber.charAt(i) - '0';

            int newDigit = firstDigit + secondDigit + reminder;
            if (newDigit >= 10) {
                reminder = 1;
                newDigit -= 10;
            } else {
                reminder = 0;
            }

            result.insert(0, newDigit);
        }

        System.out.println();
        if (reminder == 1) {
            result.insert(0, reminder);
        }
        while (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
