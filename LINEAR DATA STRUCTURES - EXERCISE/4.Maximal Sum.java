package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        int height = Integer.parseInt(numbers[0]);
        int width = Integer.parseInt(numbers[1]);
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            matrix[i] = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] elements = new int[9];

        elements[0] = matrix[0][0];
        elements[1] = matrix[0][1];
        elements[2] = matrix[0][2];
        elements[3] = matrix[1][0];
        elements[4] = matrix[1][1];
        elements[5] = matrix[1][2];
        elements[6] = matrix[2][0];
        elements[7] = matrix[2][1];
        elements[8] = matrix[2][2];

        int bestSum = sum(elements);

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = getCurrentSum(matrix, row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    setElements(matrix, row, col, elements);
                }
            }
        }
        System.out.println(String.format("Sum = %d", bestSum));
        printElements(elements);
    }

    private static void printElements(int[] elements) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(elements[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void setElements(int[][] matrix, int row, int col, int[] arr) {
        arr[0] = matrix[row][col];
        arr[1] = matrix[row][col + 1];
        arr[2] = matrix[row][col + 2];
        arr[3] = matrix[row + 1][col];
        arr[4] = matrix[row + 1][col + 1];
        arr[5] = matrix[row + 1][col + 2];
        arr[6] = matrix[row + 2][col];
        arr[7] = matrix[row + 2][col + 1];
        arr[8] = matrix[row + 2][col + 2];
    }

    private static int getCurrentSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1] +
                matrix[row][col + 2] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}
