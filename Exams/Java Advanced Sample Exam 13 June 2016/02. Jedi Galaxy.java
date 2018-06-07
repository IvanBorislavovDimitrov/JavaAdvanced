import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JediGalaxy {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int ivoPower = 0;
        String[] numbers = input.readLine().split(" ");
        int height = Integer.parseInt(numbers[0]);
        int width = Integer.parseInt(numbers[1]);
        long[][] matrix = new long[height][width];

        long cnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = cnt++;
            }
        }

        String line;
        while (!"Let the Force be with you".equals(line = input.readLine())) {
            int[] ivoCords = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCords = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int ivoStartRow = ivoCords[0];
            int ivoStartCol = ivoCords[1];

            int evilStartRow = evilCords[0];
            int evilStartCol = evilCords[1];

            while (evilStartRow >= matrix.length || evilStartCol >= matrix[0].length) {
                evilStartRow--;
                evilStartCol--;
            }

            while (ivoStartRow >= matrix.length || ivoStartCol < 0) {
                ivoStartRow--;
                ivoStartCol++;
            }

            while (evilStartRow >= 0 && evilStartCol >= 0) {
                matrix[evilStartRow--][evilStartCol--] = 0;
            }

            while (ivoStartRow >= 0 && ivoStartCol < matrix[0].length) {
                ivoPower += matrix[ivoStartRow][ivoStartCol];
                ivoStartRow--;
                ivoStartCol++;
            }
        }

        System.out.println(ivoPower);
    }
}
