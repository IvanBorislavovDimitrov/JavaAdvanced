package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            int number = Integer.parseInt(input.readLine());
            String formattedBinaryString = String.format("%32s", Integer.toBinaryString(number))
                    .replaceAll(" ", "0");
            matrix[i] = formattedBinaryString.toCharArray();
        }

        System.out.println(getCountOfX(matrix));
    }

    private static int getCountOfX(char[][] matrix) {
        int countOfX = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                boolean isX = isX(matrix, row, col);
                if (isX) {
                    countOfX++;
                }
            }
        }

        return countOfX;
    }

    private static boolean isX(char[][] matrix, int row, int col) {
        boolean b1 = matrix[row][col] == '1';
        boolean b2 = matrix[row + 1][col + 1] == '1';
        boolean b3 = matrix[row + 2][col + 2] == '1';
        boolean b4 = matrix[row + 2][col] == '1';
        boolean b5 = matrix[row][col + 2] == '1';
        boolean b6 = matrix[row][col + 1] == '0';
        boolean b7 = matrix[row + 1][col] == '0';
        boolean b8 = matrix[row + 2][col + 1] == '0';
        boolean b9 = matrix[row + 1][col + 2] == '0';

        return  b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8 && b9;
    }
}
