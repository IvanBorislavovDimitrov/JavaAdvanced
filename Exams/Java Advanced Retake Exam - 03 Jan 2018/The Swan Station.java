package last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheSwanStation {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersStr = input.readLine().split(" +");
        String[] secondNumbers = input.readLine().split(" +");
        Queue<Integer> theNumbers = new ArrayDeque<>();
        Queue<Integer> others = new ArrayDeque<>();
        for (String s : numbersStr) {
            theNumbers.offer(Integer.parseInt(s));
        }
        for (String secondNumber : secondNumbers) {
            others.offer(Integer.parseInt(secondNumber));
        }
        List<Integer> finalNumbers = new ArrayList<>(6);

        while (finalNumbers.size() < 6) {
            int divisor = theNumbers.peek();
            int number = others.poll();

            if (number % divisor == 0) {
                finalNumbers.add(number);
                theNumbers.poll();
                theNumbers.offer(divisor);
            } else {
                others.offer(number + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer finalNumber : finalNumbers) {
            sb.append(finalNumber).append(", ");
        }

        sb.deleteCharAt(sb.length() - 2);

        System.out.println(sb);

    }
}
