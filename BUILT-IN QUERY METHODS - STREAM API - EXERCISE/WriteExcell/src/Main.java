import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String[]> file = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/StudentData.txt"))) {
            String line;
            while (null != (line = bufferedReader.readLine())) {
                file.add(line.split("\t"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Students Data");

        int rowNum = 0;
        for (String[] key : file) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String obj : key) {
                Cell cell = row.createCell(cellNum++);

                cell.setCellValue(obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("students.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("students.xlsx is written successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
