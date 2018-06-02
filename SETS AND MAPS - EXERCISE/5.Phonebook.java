package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phonebook = new HashMap<>();
        String line;
        while (!"search".equals(line = input.readLine())) {
            String[] lineInfo = line.split("-");
            String contactNumber = lineInfo[0];
            String number = lineInfo[1];
            phonebook.put(contactNumber, number);
        }

        while (!"stop".equals(line = input.readLine())) {
            if (phonebook.containsKey(line)) {
                System.out.println(String.format("%s -> %s", line, phonebook.get(line)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", line));
            }
        }
    }
}
