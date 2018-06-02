import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int height = dimensions[0];
        int width = dimensions[1];
        int[][] field = new int[height][width];
        String line;
        while (!"Bloom Bloom Plow".equals(line = input.readLine())) {
            String[] sizes = line.split("\\s+");
            int row = Integer.parseInt(sizes[0]);
            int col = Integer.parseInt(sizes[1]);

            bloom(field, row, col);
        }

        printField(field);
    }

    private static void printField(int[][] field) {
        StringBuilder sb = new StringBuilder();
        for (int[] f : field) {
            for (int i : f) {
                sb.append(i).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void bloom(int[][] field, int row, int col) {
        field[row][col]++;
        for (int i = row + 1; i < field.length; i++) { // down
            field[i][col]++;
        }
        for (int i = row - 1; i >= 0; i--) { // up
            field[i][col]++;
        }
        for (int i = col + 1; i < field[row].length; i++) { // right
            field[row][i]++;
        }
        for (int i = col - 1; i >= 0; i--) { // left
            field[row][i]++;
        }
    }
}
