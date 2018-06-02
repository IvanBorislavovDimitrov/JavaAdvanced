package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            usernames.add(input.readLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
