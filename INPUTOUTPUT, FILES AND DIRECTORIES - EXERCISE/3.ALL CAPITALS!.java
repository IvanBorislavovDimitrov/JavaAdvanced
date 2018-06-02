package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {

    private static final String FILE_INPUT_NAME = "src\\exercises\\input.txt";
    private static final String FILE_OUTPUT_NAME = "src\\exercises\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_INPUT_NAME));
             PrintWriter printWriter = new PrintWriter(FILE_OUTPUT_NAME)) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line.toUpperCase());
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
            printWriter.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
