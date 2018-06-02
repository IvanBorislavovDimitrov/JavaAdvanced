package introduction_to_java_exercise;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        long sum = 0;
        int indexForS1 = 0;
        int indexForS2 = 0;

        while (indexForS1 < s1.length() && indexForS2 < s2.length()) {
            sum += (s1.charAt(indexForS1++) * s2.charAt(indexForS2++));
        }

        while (indexForS1 < s1.length()) {
            sum += s1.charAt(indexForS1++);
        }

        while (indexForS2 < s2.length()) {
            sum += s2.charAt(indexForS2++);
        }

        System.out.println(sum);
    }
}
