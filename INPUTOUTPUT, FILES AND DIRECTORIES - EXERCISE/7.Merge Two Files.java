package exercises.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {

    private static final String FILE_ONE = "src\\exercises\\inputOne.txt";
    private static final String FILE_TWO = "src\\exercises\\inputTwo.txt";
    private static final String OUTPUT = "src\\exercises\\output.txt";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        readFile(sb, FILE_ONE);

        readFile(sb, FILE_TWO);

        merge(sb.toString());
    }

    private static void merge(String string) {
        try (PrintWriter printWriter = new PrintWriter(OUTPUT)) {
            printWriter.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(StringBuilder sb, String fileOne) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOne))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
