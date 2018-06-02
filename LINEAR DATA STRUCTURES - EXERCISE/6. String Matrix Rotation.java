package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String rotation = input.readLine();
        int degrees = Integer.parseInt(rotation.substring(rotation.indexOf("(") + 1, rotation.length() - 1));
        List<String> inputStrings = new ArrayList<>();
        String line;
        while (!"END".equals(line = input.readLine())) {
            inputStrings.add(line);
        }
        int longestElements = getElementsWithLongestLength(inputStrings);
        char[][] matrix = new char[inputStrings.size()][longestElements];
        fillMatrix(matrix, inputStrings, longestElements);
        for (int i = 0; i < degrees / 90; i++) {
            matrix = rotate(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void fillMatrix(char[][] matrix, List<String> words, int bestLen) {
        int row = 0;
        String formatter = "%" + "-" + bestLen + "s";
        for (String word : words) {
            String formattedWord = String.format(formatter, word);
            matrix[row++] = formattedWord.toCharArray();
        }
    }

    private static char[][] rotate(char[][] matrix) {
        char[][] newMatrix = new char[matrix[0].length][matrix.length];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                newMatrix[col][matrix.length - 1 - row] = matrix[row][col];
            }
        }

        return newMatrix;
    }


    private static int getElementsWithLongestLength(List<String> list) {
        int bestLen = list.get(0).length();
        for (String s : list) {
            if (s.length() > bestLen) {
                bestLen = s.length();
            }
        }

        return bestLen;
    }

}
