import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfMatrix = Integer.parseInt(input.readLine());
        String[] commands = input.readLine().split(", ");
        char[][] field = new char[sizeOfMatrix][sizeOfMatrix];
        int currentRow = 0;
        int currentCol = 0;
        long countOfTotalFood = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            String[] chars = input.readLine().split(" ");
            for (int j = 0; j < sizeOfMatrix; j++) {
                char c = chars[j].charAt(0);
                field[i][j] = c;
                if (c == 's') {
                    currentRow = i;
                    currentCol = j;
                } else if (c == 'f') {
                    countOfTotalFood++;
                }
            }
        }
        int snakeLength = 1;


        for (String command : commands) {
            switch (command) {
                case "down":
                    currentRow++;
                    if (currentRow >= field.length || currentRow == Integer.MIN_VALUE) {
                        currentRow = 0;
                    }
                    char box = field[currentRow][currentCol];
                    if (box == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (box == 'f') {
                        snakeLength++;
                        field[currentRow][currentCol] = '*';
                        countOfTotalFood--;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol >= field.length || currentCol == Integer.MIN_VALUE) {
                        currentCol = 0;
                    }
                    box = field[currentRow][currentCol];
                    if (box == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (box == 'f') {
                        snakeLength++;
                        field[currentRow][currentCol] = '*';
                        countOfTotalFood--;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0 || currentCol == Integer.MAX_VALUE) {
                        currentCol = field.length - 1;
                    }
                    box = field[currentRow][currentCol];
                    if (box == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (box == 'f') {
                        snakeLength++;
                        field[currentRow][currentCol] = '*';
                        countOfTotalFood--;
                    }
                    break;
                case "up":
                    currentRow--;
                    if (currentRow < 0 || currentRow == Integer.MAX_VALUE) {
                        currentRow = field.length - 1;
                    }
                    box = field[currentRow][currentCol];

                    if (box == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else if (box == 'f') {
                        snakeLength++;
                        field[currentRow][currentCol] = '*';
                        countOfTotalFood--;
                    }
                    break;
            }
            if (countOfTotalFood <= 0) {
                System.out.println(String.format("You win! Final snake length is %d", snakeLength));
                return;
            }
        }

        if (countOfTotalFood == 0) {
            System.out.println(String.format("You win! Final snake length is %d", snakeLength));
        } else {
            System.out.println(String.format("You lose! There is still %d food to be eaten.", countOfTotalFood));
        }
    }


}
