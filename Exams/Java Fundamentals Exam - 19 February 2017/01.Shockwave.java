import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] heightAndWidth = input.readLine().split("\\s+");
        int height = Integer.parseInt(heightAndWidth[0]);
        int width = Integer.parseInt(heightAndWidth[1]);
        int[][] matrix = new int[height][width];
        String line;
        while (!"Here We Go".equals(line = input.readLine())) {
            String[] number = line.split("\\s+");
            int x1 = Integer.parseInt(number[0]);
            int y1 = Integer.parseInt(number[1]);
            int x2 = Integer.parseInt(number[2]);
            int y2 = Integer.parseInt(number[3]);
            increaseMatrix(matrix, x1, y1, x2, y2);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    private static void increaseMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                matrix[row][col]++;
            }
        }
    }
}
