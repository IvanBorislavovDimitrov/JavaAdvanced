package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxElement {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfCommands = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < countOfCommands; i++) {
            String[] info = input.readLine().split("\\s");
            Integer command = Integer.parseInt(info[0]);
            switch (command) {
                case 1:
                    int number = Integer.parseInt(info[1]);
                    stack.push(number);
                    break;
                case 2:
                    if (! stack.isEmpty())
                        stack.pop();
                    break;
                case 3:
                    System.out.println(biggestElement(stack));
                    break;
            }
        }
    }

    private static int biggestElement(Stack<Integer> elements) {
        if (elements.isEmpty()) {
            return 0;
        }
        int biggestElement = elements.peek();
        for (Integer element : elements) {
            if (biggestElement < element) {
                biggestElement = element;
            }
        }

        return biggestElement;
    }
}
