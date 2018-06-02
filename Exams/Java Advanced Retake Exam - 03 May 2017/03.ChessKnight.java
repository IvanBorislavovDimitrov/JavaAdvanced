import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChessKnight {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[][] chessTable = new String[8][8];
        for (int i = 0; i < 8; i++) {
            chessTable[i] = input.readLine().split("\\|");
        }

        List<String> piecesTake = new ArrayList<>();
        int invalidMoves = 0;
        int outOfBoardMoves = 0;
        String line;

        String strPos = input.readLine();
        int startRow = strPos.charAt(0) - '0';
        int startCol = strPos.charAt(1) - '0';
        while (!"END".equals(line = input.readLine())) {
            String[] newPosArr = line.split(" -> ");
            int currentRow = newPosArr[1].charAt(0) - '0';
            int currentCol = newPosArr[1].charAt(1) - '0';

            if (canGo(startRow, startCol, currentRow, currentCol)) {
                if (isValidPos(chessTable, currentRow, currentCol)) {

                    if (!chessTable[currentRow][currentCol].equals(" ")) {
                        piecesTake.add(chessTable[currentRow][currentCol]);
                    }
                    startRow = currentRow;
                    startCol = currentCol;
                } else {
                    outOfBoardMoves++;
                }
            } else {
                invalidMoves++;
            }

        }

        System.out.println("Pieces take: " + String.join(", ", piecesTake));
        System.out.println("Invalid moves: " + invalidMoves);
        System.out.println("Board out moves: " + outOfBoardMoves);
    }

    private static boolean isValidPos(String[][] matrix, int row, int col) {
        try {
            String s = matrix[row][col];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    private static boolean canGo(int currentRow, int currentCol, int nextRow, int nextCol) {
        if (currentRow + 2 == nextRow && currentCol + 1 == nextCol) {
            return true;
        }

        if (currentRow + 1 == nextRow && currentCol + 2 == nextCol) {
            return true;
        }

        if (currentRow - 2 == nextRow && currentCol - 1 == nextCol) {
            return true;
        }

        if (currentRow - 1 == nextRow && currentCol - 2 == nextCol) {
            return true;
        }

        if (currentRow - 2 == nextRow && currentCol + 1 == nextCol) {
            return true;
        }

        if (currentRow + 2 == nextRow && currentCol - 1 == nextCol) {
            return true;
        }

        if (currentRow + 1 == nextRow && currentCol - 2 == nextCol) {
            return true;
        }

        if (currentRow - 1 == nextRow && currentCol + 2 == nextCol) {
            return true;
        }

        return false;
    }
}
