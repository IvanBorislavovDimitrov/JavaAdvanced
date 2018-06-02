package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    private static final String INPUT_FILE_NAME = "src\\resources\\input\\input.txt";
    private static final String OUTPUT_FILE_NAME = "src\\resources\\output\\copyBytesOutput.txt";
    private static final int WHITESPACE = ' ';
    private static final int NEW_LINE = '\n';

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_NAME);
             FileInputStream fileInputStream = new FileInputStream(INPUT_FILE_NAME)) {
            int value;
            while ((value = fileInputStream.read()) >= 0) {
                if (value == WHITESPACE || value == NEW_LINE) {
                    fileOutputStream.write(value);
                } else {
                    String digits = String.valueOf(value);
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
