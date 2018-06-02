package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String text = input.readLine().toUpperCase();
        String searchedWord = input.readLine().toUpperCase();
        int index = text.indexOf(searchedWord);
        int cnt = 0;
        while (index != -1) {
            cnt++;
            index = text.indexOf(searchedWord, index + 1);
        }

        System.out.println(cnt);
     }
}
