package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(", +");
        int n = Integer.parseInt(info[0]);
        String pattern = info[1];

        switch (pattern) {
            case "A":
                printPatternA(n);
                break;
            case "B":
                printPatternB(n);
                break;
        }
    }

    private static void printPatternB(int size) {
        int counter = 1;
        int[][] matrix = new int[size][size];
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = counter++;
                } else {
                    matrix[matrix.length - 1 - row][col] = counter++;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printPatternA(int size) {
        int counter = 1;
        int[][] matrix = new int[size][size];
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter++;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
