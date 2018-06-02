package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(input.readLine());

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if ((i + j) == number) {
                    System.out.println(String.format("%d + %d = %d", i, j, number));
                } else if ((i - j) == number) {
                    System.out.println(String.format("%d - %d = %d", i, j, number));
                }
            }
        }
    }
}
