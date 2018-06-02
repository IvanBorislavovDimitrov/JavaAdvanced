package lab;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class NestedFolders {

    private static final String DIRECTORY = "src\\resources\\input\\Files-and-Streams";

    public static void main(String[] args) {
        depthFirstSearch(new File(DIRECTORY));
        System.out.println("-------------------");
        breadthFirstSearch(new File(DIRECTORY));
    }

    private static void breadthFirstSearch(File rootDir) {
        Queue<File> dirs = new LinkedList<>();
        dirs.offer(rootDir);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");

    }

    private static void depthFirstSearch(File rootDir) {
        System.out.println(rootDir.getName());

        File[] nestedFiles = rootDir.listFiles();

        for (File nestedFile : nestedFiles)
            if (nestedFile.isDirectory())
                depthFirstSearch(nestedFile);
    }
}
