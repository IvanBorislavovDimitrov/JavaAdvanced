package exercises.solutions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {

    private static final String FILE_INPUT_NAME = "src\\exercises\\Exercises_Resources\\SANDRA-AFRIKA.jpg";
    private static final String FILE_OUTPUT_NAME = "src\\exercises\\Exercises_Resources\\SANDRA-AFRIKA-COPY.jpg";


    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_INPUT_NAME);
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_OUTPUT_NAME)) {
            int symbol;
            while ((symbol = fileInputStream.read()) >= 0) {
                fileOutputStream.write(symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
