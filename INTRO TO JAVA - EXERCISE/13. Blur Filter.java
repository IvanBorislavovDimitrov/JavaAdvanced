package introduction_to_java_exercise;

import java.util.Scanner;

public class BlurFilter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int blurFilter = Integer.parseInt(input.nextLine());
        int rows = input.nextInt();
        int cols = input.nextInt();

        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input.nextInt();
            }
        }

        int blurRow = input.nextInt();
        int blurCol = input.nextInt();

        matrix[blurRow][blurCol] += blurFilter;

        try {
            matrix[blurRow - 1][blurCol - 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow - 1][blurCol] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow - 1][blurCol + 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow][blurCol - 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow][blurCol + 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow + 1][blurCol - 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow + 1][blurCol] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            matrix[blurRow + 1][blurCol + 1] += blurFilter;
        } catch (IndexOutOfBoundsException ignored) {}

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
