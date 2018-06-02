package introduction_to_java_lab;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersNM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstNum = input.nextInt();
        int secondNum = input.nextInt();
        BigDecimal productOfNumbers = productOfNumbers(firstNum, secondNum);
        System.out.println(String.format("product[%d..%d] = %s", firstNum, secondNum, productOfNumbers));
    }

    private static BigDecimal productOfNumbers(int firstNumber, int secondNum) {
        if (firstNumber <= secondNum) {
            BigDecimal number = new BigDecimal(firstNumber);
            return number.multiply(productOfNumbers(firstNumber + 1, secondNum));
        }

        return BigDecimal.ONE;
    }
}
