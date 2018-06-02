package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {

    private static final String INPUT_FILE_NAME = "src\\resources\\input\\input.txt";
    private static final String OUTPUT_FILE_NAME = "src\\resources\\output\\writeFileOutput.txt";
    private static Set<Character> ILLEGAL_SYMBOLS = new HashSet<>();

    public static void main(String[] args) {
        ILLEGAL_SYMBOLS.add(',');
        ILLEGAL_SYMBOLS.add('.');
        ILLEGAL_SYMBOLS.add('!');
        ILLEGAL_SYMBOLS.add('?');

        try (FileInputStream fileInputStream = new FileInputStream(INPUT_FILE_NAME);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_NAME)) {
            int symbol;
            while ((symbol = fileInputStream.read()) >= 0) {
                if (isSymbolValid(symbol)) {
                    fileOutputStream.write(symbol);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File transfer is completed!");
    }

    private static boolean isSymbolValid(int symbol) {
        char charSymbol = (char) symbol;
        return !ILLEGAL_SYMBOLS.contains(charSymbol);
    }
}
