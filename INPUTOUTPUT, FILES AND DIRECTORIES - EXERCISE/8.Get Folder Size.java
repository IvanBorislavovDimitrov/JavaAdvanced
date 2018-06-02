package exercises.solutions;

import java.io.File;

public class GetFolderSize {

    private static final String DIRECTORY = "src\\exercises\\Exercises_Resources";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);
        long size = findSize(file);
        System.out.println("Folder size: " + size);
    }

    private static long findSize(File startDir) {
        File[] files = startDir.listFiles();
        long size = 0;

        for (File file : files) {
            if (file.isDirectory()) {
                size += findSize(file);
            }
            size += file.length();
        }

        return size;
    }
}
