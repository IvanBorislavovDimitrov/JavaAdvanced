package introduction_to_java_lab;

import java.util.Scanner;

public class ExtractBitFromInteger {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int moves = input.nextInt();
        int neededPosition = 1 << moves;
        System.out.println((number & neededPosition) != 0 ? 1 : 0);
    }
}
