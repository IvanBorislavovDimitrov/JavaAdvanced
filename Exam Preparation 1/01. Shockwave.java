import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] dimension = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int height = dimension[0];
        int width = dimension[1];
        int[][] matrix = new int[height][width];
        String line;
        while (!"Here We Go".equals(line = input.readLine())) {
            int[] hitPoints = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x1 = hitPoints[0];
            int y1 = hitPoints[1];
            int x2 = hitPoints[2];
            int y2 = hitPoints[3];
            shockwave(matrix, x1, y1, x2, y2);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void shockwave(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                matrix[i][j]++;
            }
        }
    }
}
