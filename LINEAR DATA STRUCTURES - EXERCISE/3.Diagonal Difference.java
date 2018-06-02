package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(diagonalDifference(matrix));
    }

    private static int diagonalDifference(int[][] matrix) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            leftDiagonalSum += matrix[row][row];
            rightDiagonalSum += matrix[row][matrix.length - 1 - row];
        }

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }
}
