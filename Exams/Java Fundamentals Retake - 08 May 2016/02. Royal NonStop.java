import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

public class NonStop {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String matrixDimensions = input.readLine();
        String[] rakijaAndLukanka = input.readLine().split(" ");

        double rakijaPrice = Double.parseDouble(rakijaAndLukanka[0]);
        double lukankaPrice = Double.parseDouble(rakijaAndLukanka[1]);

        BigDecimal royalsEarn = BigDecimal.ZERO;

        int cnt = 0;
        String line;
        while (!"Royal Close".equals(line = input.readLine())) {
            String[] indexes = line.split(" ");
            int row = Integer.parseInt(indexes[0]);
            int col = Integer.parseInt(indexes[1]);
            cnt++;

            if (row >= col) {
                if (row % 2 == 0) {
                    for (int i = col; i >= 0; i--) {
                        royalsEarn = royalsEarn.add(new BigDecimal((row + 1) * (i + 1) * rakijaPrice));
                    }
                } else {
                    for (int i = col; i >= 0; i--) {
                        royalsEarn = royalsEarn.add(new BigDecimal((row + 1) * (i + 1) * lukankaPrice));
                    }
                }
                for (int i = row - 1; i >= 1; i--) {
                    if (i % 2 == 0) {
                        royalsEarn = royalsEarn.add(new BigDecimal((i + 1) * rakijaPrice));
                    } else {
                        royalsEarn = royalsEarn.add(new BigDecimal((i + 1) * lukankaPrice));

                    }
                }
            } else {
                for (int i = row; i >= 0; i--) {
                    if (i % 2 == 0) {
                        royalsEarn = royalsEarn.add(new BigDecimal((col + 1) * (i + 1) * rakijaPrice));
                    } else {
                        royalsEarn = royalsEarn.add(new BigDecimal((col + 1) * (i + 1) * lukankaPrice));
                    }
                }
                for (int i = col - 1; i >= 1; i--) {
                    royalsEarn = royalsEarn.add(new BigDecimal((i + 1) * rakijaPrice));
                }
            }
        }

        System.out.println(String.format("%.6f", royalsEarn));
        System.out.println(cnt);
    }
}
