package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

    private static final String INPUT_FILE_NAME = "src\\resources\\input\\test.txt";
    private static final String OUTPUT_FILE_NAME = "src\\resources\\output\\extractIntegersOutput.txt";
    private static final char NEW_LINE = '\n';

    public static void main(String[] args) {
        try (Scanner input = new Scanner(new FileInputStream(INPUT_FILE_NAME));
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_NAME)) {
            while (input.hasNext()) {
                if (input.hasNextInt()) {
                    String save = String.valueOf(input.nextInt());
                    for (int i = 0; i < save.length(); i++) {
                        fileOutputStream.write(save.charAt(i));
                    }
                    fileOutputStream.write(NEW_LINE);
                }
                input.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
