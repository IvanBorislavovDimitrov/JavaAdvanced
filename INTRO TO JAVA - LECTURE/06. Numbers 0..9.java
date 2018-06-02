package introduction_to_java_lab;

public class NumbersZeroToNine {

    public static void main(String[] args) {
        printNumbers(0);
    }

    private static void printNumbers(int number) {
        if (number == 10) {
            return;
        }

        System.out.println(String.format("Number: %d", number));
        printNumbers(number + 1);
    }
}
