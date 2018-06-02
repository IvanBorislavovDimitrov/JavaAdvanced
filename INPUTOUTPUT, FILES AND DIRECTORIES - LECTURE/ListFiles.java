package lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {

    private static final String DIRECTORY = "src\\resources\\input\\Files-and-Streams";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);

        for (File currentFile : file.listFiles()) {
            if (currentFile.isFile()) {
                System.out.println(String.format("%s: [%d in bytes]", currentFile.getName(), currentFile.length()));
            }
        }
    }
}
