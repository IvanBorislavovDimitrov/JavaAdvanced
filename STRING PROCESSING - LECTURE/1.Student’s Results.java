package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StudentsResults {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] studentInfo = input.readLine().split("\\s+|,\\s+");
        String studentName = studentInfo[0];
        double[] grades = Arrays.stream(studentInfo).skip(2).mapToDouble(Double::parseDouble).toArray();
        double jAdv = grades[0];
        double javaOop = grades[1];
        double advOop = grades[2];
        double avr = Arrays.stream(grades).average().orElse(0);
        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.println(String.format("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|",
                studentName, jAdv, javaOop, advOop, avr));
    }
}
