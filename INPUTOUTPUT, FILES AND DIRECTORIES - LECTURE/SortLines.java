package lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SortLines {

    private static final String INPUT_FILE_NAME = "src\\resources\\input\\input.txt";

    public static void main(String[] args) {
        Path path = Paths.get(INPUT_FILE_NAME);
        try {
            List<String> lines = Files.readAllLines(path);
            lines.sort(String::compareTo);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
