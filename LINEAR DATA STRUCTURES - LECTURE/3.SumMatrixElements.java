package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensionsInStringArray = input.readLine().split(", +");
        int height = Integer.parseInt(dimensionsInStringArray[0]);
        int width = Integer.parseInt(dimensionsInStringArray[1]);
        int[][] matrix = new int[height][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.readLine().split(", +")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int[] mat : matrix) {
            for (int element : mat) {
                sum += element;
            }
        }

        System.out.println(height);
        System.out.println(width);
        System.out.println(sum);
    }
}
