package introduction_to_java_lab;

import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstStr = input.next();
        String secondStr = input.next();
        input.nextLine();
        long firstNum = input.nextLong();
        long secondNum = input.nextLong();
        long lastNum = input.nextLong();
        input.nextLine();
        String lastWord = input.nextLine();

        System.out.println(String.format("%s %s %s %d", firstStr, secondStr, lastWord, firstNum + secondNum + lastNum));
    }
}