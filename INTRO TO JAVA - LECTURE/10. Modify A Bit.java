package introduction_to_java_lab;

import java.util.Scanner;

public class ModifyABit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = input.nextInt();    
        int bit = input.nextInt();
        if (bit == 0) {
            int mask = 1 << p;
            System.out.println(n & ~mask);
        } else {
            int max = 1 << p;
            System.out.println(n | max);
        }

    }
}
