package exercises.solutions;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

    private static final String FILE_ONE = "src\\exercises\\eTam.zip";
    private static final String FILE_TWO = "src\\exercises\\inputOne.txt";
    private static final String FILE_THREE = "src\\exercises\\inputTwo.txt";

    public static void main(String[] args) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(FILE_ONE))) {

            zipOutputStream.putNextEntry(new ZipEntry("first.txt"));
            String firstFileInfo = readFile(FILE_ONE);
            zipOutputStream.write(firstFileInfo.getBytes());
            zipOutputStream.closeEntry();

            zipOutputStream.putNextEntry(new ZipEntry("second.txt"));
            String secondFileInfo = readFile(FILE_TWO);
            zipOutputStream.write(secondFileInfo.getBytes());
            zipOutputStream.closeEntry();

            zipOutputStream.putNextEntry(new ZipEntry("third.txt"));
            String thirdFileInfo = readFile(FILE_THREE);
            zipOutputStream.write(thirdFileInfo.getBytes());
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileOne) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOne))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
