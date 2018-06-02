package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emails = new LinkedHashMap<>();
        String line;
        while (!"stop".equals(line = input.readLine().trim())) {
            String email = input.readLine().trim();
            if (email.toLowerCase().endsWith(".us") || email.toLowerCase().equals(".uk")
                    || email.toLowerCase().endsWith(".com")) {
                continue;
            }
            emails.put(line, email);
        }
        emails.forEach((x1, x2) -> System.out.println(String.format("%s -> %s", x1, x2)));
    }
}
