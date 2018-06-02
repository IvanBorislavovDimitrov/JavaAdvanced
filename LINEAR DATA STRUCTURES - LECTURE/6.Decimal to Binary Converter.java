package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DecimalToBinaryConverter {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();

        binaryNumber(n, stack);
        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        destroyStack(stack);
    }

    private static void destroyStack(Stack<Integer> stack) {
        if (stack.size() > 0) {
            System.out.printf("%d", stack.pop());
            destroyStack(stack);
        }

    }

    private static void binaryNumber(int n, Stack<Integer> stack) {
        if (n > 0) {
            stack.push(n % 2);
            binaryNumber(n / 2, stack);
        }
    }
}
