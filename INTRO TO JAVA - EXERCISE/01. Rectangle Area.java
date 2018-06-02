package introduction_to_java_exercise;

import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();

        System.out.println(String.format("%.2f", a * b));
    }
}
