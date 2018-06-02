package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetFirstOddOrEvenElements {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] infoAboutNumbers = input.readLine().split("\\s+");
        int countOfNumbersToTake = Integer.parseInt(infoAboutNumbers[1]);
        String oddOrEven = infoAboutNumbers[2];

        switch (oddOrEven) {
            case "odd":
                printOdd(arr, countOfNumbersToTake);
                break;
            case "even":
                printEven(arr, countOfNumbersToTake);
                break;
        }
    }

    private static void printEven(int[] numbers, int countOfNumbersToTake) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number % 2 == 0) {
                sb.append(number).append(" ");
                count++;
            }
            if (count == countOfNumbersToTake) {
                break;
            }
        }

        System.out.println(sb);
    }

    private static void printOdd(int[] numbers, int countOfNumbersToTake) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number % 2 != 0) {
                sb.append(number).append(" ");
                count++;
            }
            if (count == countOfNumbersToTake) {
                break;
            }
        }

        System.out.println(sb);
    }
}
