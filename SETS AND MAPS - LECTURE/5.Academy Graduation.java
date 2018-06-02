package sets_and_maps_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class AcademyGraduation {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfPeople = Integer.parseInt(input.readLine());
        Map<String, BigDecimal> students = new TreeMap<>();
        for (int i = 0; i < countOfPeople; i++) {
            String studentName = input.readLine();
            String[] gradesArr = input.readLine().split("\\s+");
            BigDecimal grade = calcSum(gradesArr);
            students.put(studentName, grade);
        }

        printStudents(students);
    }

    private static BigDecimal calcSum(String[] gradesArr) {
        BigDecimal grade = BigDecimal.ZERO;
        for (String s : gradesArr) {
            grade = grade.add(new BigDecimal(s));
        }

        return grade.divide(new BigDecimal(gradesArr.length));
    }

    private static void printStudents(Map<String, BigDecimal> students) {
        for (Map.Entry<String, BigDecimal> student : students.entrySet()) {
            System.out.println(String.format("%s is graduated with %s", student.getKey(), student.getValue()));
        }
    }
}
