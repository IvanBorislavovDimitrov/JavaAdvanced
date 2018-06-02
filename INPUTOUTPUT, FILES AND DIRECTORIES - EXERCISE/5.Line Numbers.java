package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {

    private static final String FILE_INPUT_NAME = "src\\exercises\\inputLineNumbers.txt";
    private static final String FILE_OUTPUT_NAME = "src\\exercises\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_INPUT_NAME));
             PrintWriter printWriter = new PrintWriter(FILE_OUTPUT_NAME)) {
            String line;
            int counter = 1;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(String.format("%d. %s", counter++, line)).append(System.lineSeparator());
            }

            printWriter.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
