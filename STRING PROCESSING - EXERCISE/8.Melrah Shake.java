package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(input.readLine());
        StringBuilder toRemove = new StringBuilder(input.readLine());

        while (str.length() > 0 && toRemove.length() > 0) {
            int indexOf = str.indexOf(toRemove.toString());
            int lastIndexOf = str.lastIndexOf(toRemove.toString());

            if (indexOf == -1 || lastIndexOf == -1) {
                break;
            }

            str.delete(indexOf, indexOf + toRemove.length());
            str.delete(lastIndexOf - toRemove.length(), lastIndexOf);
            toRemove.deleteCharAt(toRemove.length() / 2);
            System.out.println("Shaked it.");
        }
        System.out.println("No shake.");
        System.out.println(str);
    }
}
