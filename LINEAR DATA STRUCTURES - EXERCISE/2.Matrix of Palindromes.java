package linear_data_structures_exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();
        int width = input.nextInt();
        String[][] matrixOfPalindromes = new String[height][width];
        fillMatrix(matrixOfPalindromes);
        printMatrix(matrixOfPalindromes);
    }

    private static void printMatrix(String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void fillMatrix(String[][] matrix) {
        char startChar = 'a';
        for (int row = 0; row < matrix.length; row++) {
            char currentChar = startChar;
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = String.valueOf(startChar) + String.valueOf(currentChar) + String.valueOf(startChar);
                currentChar += 1;
            }
            startChar += 1;
        }
    }
}
