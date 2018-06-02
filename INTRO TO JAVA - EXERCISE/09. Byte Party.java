package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteParty {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfNumbers = Integer.parseInt(input.readLine());
        int[] numbers = initNumber(input, countOfNumbers);
        String line;
        while (!"party over".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            int func = Integer.parseInt(lineInfo[0]);
            int pos = Integer.parseInt(lineInfo[1]);

            switch (func) {
                case -1:
                    flipNumber(numbers, pos);
                    break;
                case 0:
                    turnToZeros(numbers, pos);
                    break;
                case 1:
                    turnToOnes(numbers, pos);
                    break;
            }
        }
        printArr(numbers);
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void turnToOnes(int[] numbers, int pos) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] |= (1 << pos);
        }
    }

    private static void turnToZeros(int[] numbers, int pos) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] &= ~(1 << pos);
        }
    }

    private static void flipNumber(int[] numbers, int pos) {
        for (int i = 0; i < numbers.length; i++) {
            int bit = (numbers[i] & (1 << pos)) != 0 ? 1 : 0;
            if (bit == 1) {
                numbers[i] &= ~(1 << pos);
            } else {
                numbers[i] |= (1 << pos);
            }
        }
    }

    private static int[] initNumber(BufferedReader input, int n) throws IOException {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input.readLine());
        }

        return numbers;
    }
}
