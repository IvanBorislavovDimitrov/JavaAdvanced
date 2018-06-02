package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterByAge {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfPeople = Integer.parseInt(input.readLine());
        MapString, Integer people = new LinkedHashMap();
        for (int i = 0; i  countOfPeople; i++) {
            String[] lineInfo = input.readLine().split(,s);
            String personName = lineInfo[0];
            int age = Integer.parseInt(lineInfo[1]);
            people.put(personName, age);
        }

        String condition = input.readLine();
        int yearsLimit = Integer.parseInt(input.readLine());
        String[] columns = input.readLine().split(s);

        if (condition.equals(younger)) {
            if (columns.length == 2) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue()  yearsLimit)
                        .forEach(x - System.out.println(String.format(%s - %d, x.getKey(), x.getValue())));
            } else if (columns[0].equals(name)) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue()  yearsLimit)
                        .forEach(x - System.out.println(String.format(%s, x.getKey())));
            } else if (columns[0].equals(age)) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue()  yearsLimit)
                        .forEach(x - System.out.println(String.format(%d, x.getValue())));
            }
        } else {
            if (columns.length == 2) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue() = yearsLimit)
                        .forEach(x - System.out.println(String.format(%s - %d, x.getKey(), x.getValue())));
            } else if (columns[0].equals(name)) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue() = yearsLimit)
                        .forEach(x - System.out.println(String.format(%s, x.getKey())));
            } else if (columns[0].equals(age)) {
                people.entrySet()
                        .stream()
                        .filter(x - x.getValue() = yearsLimit)
                        .forEach(x - System.out.println(String.format(%d, x.getValue())));
            }

        }
    }
}
