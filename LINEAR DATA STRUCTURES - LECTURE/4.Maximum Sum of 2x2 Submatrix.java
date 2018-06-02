package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumOfTwoByTwoSubmatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensionsInStringArray = input.readLine().split(", +");
        int height = Integer.parseInt(dimensionsInStringArray[0]);
        int width = Integer.parseInt(dimensionsInStringArray[1]);
        int[][] matrix = new int[height][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.readLine().split(", +")).mapToInt(Integer::parseInt).toArray();
        }

        biggestTwoByTwoSubmatrix(matrix);
    }

    private static void biggestTwoByTwoSubmatrix(int[][] matrix) {
        int p1 = matrix[0][0];
        int p2 = matrix[0][1];
        int p3 = matrix[1][0];
        int p4 = matrix[1][1];
        int bestMax = matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > bestMax) {
                    bestMax = currentSum;
                    p1 = matrix[row][col];
                    p2 = matrix[row][col + 1];
                    p3 = matrix[row + 1][col];
                    p4 = matrix[row + 1][col + 1];
                }
            }
        }

        System.out.printf("%d %d%n", p1, p2);
        System.out.printf("%d %d%n", p3, p4);
        System.out.println(bestMax);
    }
}
