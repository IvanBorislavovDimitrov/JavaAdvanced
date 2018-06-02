package lab;

import java.io.*;

public class WriteEveryThirdLine {

    private static final String INPUT_FILE_NAME = "src\\resources\\input\\write-every-third-line-input.txt";
    private static final String OUTPUT_FILE_NAME = "src\\resources\\output\\write-every-third-line-output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME));
             PrintWriter printWriter = new PrintWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            String line;
            int cnt = 1;
            while ((line = reader.readLine()) != null) {
                if (cnt++ % 3 == 0) {
                    System.out.println(line);
                    printWriter.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
