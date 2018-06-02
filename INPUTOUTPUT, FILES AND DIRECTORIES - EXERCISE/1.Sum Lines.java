package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    private static final String FILE_NAME = "src\\exercises\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(getSumOfSymbols(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getSumOfSymbols(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            sum += line.charAt(i);
        }

        return sum;
    }
}
