package lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String fileName = "src\\resources\\input\\input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int currentByte;
            while ((currentByte = fileInputStream.read()) >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(currentByte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
