package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String text = input.readLine();
        Map<Character, Integer> charactersCount = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (charactersCount.containsKey(text.charAt(i))) {
                charactersCount.put(text.charAt(i), charactersCount.get(text.charAt(i)) + 1);
            } else {
                charactersCount.put(text.charAt(i), 1);
            }
        }
        charactersCount.forEach((character, integer) -> System.out.println(String.format("%c: %d time/s", character, integer)));
    }
}
