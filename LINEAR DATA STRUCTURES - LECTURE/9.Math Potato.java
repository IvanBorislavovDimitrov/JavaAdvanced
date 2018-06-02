package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HotPotato {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] participants = input.readLine().split("\\s+");
        int removeIndex = Integer.parseInt(input.readLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String participant : participants) {
            queue.offer(participant);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < removeIndex; i++) {
                String currentParticipant = queue.poll();
                queue.offer(currentParticipant);
            }

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int n) {
        double ceil = Math.sqrt(n);
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= ceil; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
