package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> queue = new ArrayDeque<>();
        String parentheses = input.readLine();
        for (int i = 0; i < parentheses.length(); i++) {
            if (isOpening(parentheses.charAt(i))) {
                queue.offer(parentheses.charAt(i));
            } else if (! queue.isEmpty()) {
                char last = queue.peekLast();
                char current = parentheses.charAt(i);
                if (areEqual(last, current)) {
                      queue.pollLast();
                }
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(queue.size() == 0 ? "YES" : "NO");
    }

    private static boolean areEqual(char open, char close) {
        switch (open) {
            case '(':
                return close == ')';
            case '{':
                return close == '}';
            case '[':
                return close == ']';
        }

        return false;
    }

    private static boolean isOpening(char parentheses) {
        return parentheses == '{' || parentheses == '[' || parentheses == '(';
    }
}
