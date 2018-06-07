package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsJoinedToSpecialties {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> work = new ArrayList<>();
        String line;
        while (!"Students:".equals(line = input.readLine())) {
            List<String> arr = new ArrayList<>(Arrays.asList(line.split("\\s+")));
            work.add(arr);
        }
        while (!"END".equals(line = input.readLine())) {
            addStudent(work, line.split("\\s+"));
        }

        for (List<String> w : work) {
            if (w.size() > 3) {
                String temp1 = w.get(0);
                String temp2 = w.get(1);
                w.set(0, w.get(3));
                w.set(1, w.get(4));
                w.set(3, temp1);
                w.set(4, temp2);
            }
        }



        work.stream().sorted((x1, x2) -> {
            String s1 = x1.get(0) + x1.get(1);
            String s2 = x2.get(0) + x2.get(1);

            return s1.compareTo(s2);
        }).forEach(x -> {
            if (x.size() > 3) {
                System.out.println(String.format("%s", String.join(" ", x)));
            }
        });
    }

    private static void addStudent(List<List<String>> students, String[] info) {
        String facultyNumber = info[0];
        for (List<String> student : students) {
            if (student.get(2).equals(facultyNumber)) {
                student.add(info[1]);
                student.add(info[2]);
            }
        }
    }
}
