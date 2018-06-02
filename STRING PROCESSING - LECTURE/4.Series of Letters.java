package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(input.readLine());
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(sb);
    }
}
