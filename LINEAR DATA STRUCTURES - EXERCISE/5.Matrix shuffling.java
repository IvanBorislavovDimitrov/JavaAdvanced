package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        int height = Integer.parseInt(numbers[0]);
        int width = Integer.parseInt(numbers[1]);
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            matrix[i] = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            if (lineInfo.length != 5) {
                System.out.println("Invalid input!");
            } else if (!lineInfo[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                int c1Row = Integer.parseInt(lineInfo[1]);
                int c1Col = Integer.parseInt(lineInfo[2]);
                int c2Row = Integer.parseInt(lineInfo[3]);
                int c2Col = Integer.parseInt(lineInfo[4]);
                if (c1Row < 0 || c1Row >= matrix.length) {
                    System.out.println("Invalid input!");
                } else if (c1Col < 0 || c1Col >= matrix[0].length) {
                    System.out.println("Invalid input!");
                } else if (c2Row < 0 || c2Row >= matrix.length) {
                    System.out.println("Invalid input!");
                } else if (c2Col < 0 || c2Col >= matrix[0].length) {
                    System.out.println("Invalid input!");
                } else {
                    swapElements(matrix, c1Row, c1Col, c2Row, c2Col);
                    printMatrix(matrix);
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                sb.append(anAMatrix).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb);
    }

    private static void swapElements(int[][] matrix, int c1Row, int c1Col, int c2Row, int c2Col) {
         matrix[c1Row][c1Col] ^= matrix[c2Row][c2Col];
         matrix[c2Row][c2Col] ^= matrix[c1Row][c1Col];
         matrix[c1Row][c1Col] ^= matrix[c2Row][c2Col];
    }
}
