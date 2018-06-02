package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class SimpleCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = input.readLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, arr);
        while (stack.size() > 1) {
            Integer leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            Integer rightOperand = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(leftOperand + rightOperand));
                    break;
                case "-":
                    stack.push(String.valueOf(leftOperand - rightOperand));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
