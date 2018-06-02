package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        int firstNumber = Integer.parseInt(numbers[0]);
        double secondNumber = Double.parseDouble(numbers[1]);
        double thirdNumber = Double.parseDouble(numbers[2]);

        String firstValue = String.format("%-10s", Integer.toHexString(firstNumber)).toUpperCase();
        String secondValue = String.format("%10s", Integer.toBinaryString(firstNumber)).replace(" ", "0");
        String thirdValue =  String.format("%10s", String.format("%.2f", secondNumber));
        String fourthValue = String.format("%-10s", String.format("%.3f", thirdNumber));

        String output = String.format("|%s|%s|%s|%s|", firstValue, secondValue, thirdValue, fourthValue);

        System.out.println(output);
    }
}
