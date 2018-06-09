import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Earthquake {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Queue<Queue<Integer>> nestedQueues = new ArrayDeque<>();
        Queue<Integer> result = new ArrayDeque<>();
        int n = Integer.parseInt(input.readLine());

        // input
        for (int i = 0; i < n; i++) {
            Queue<Integer> curQueue = new LinkedList<>();
            String[] arr = input.readLine().split(" ");

            for (String i1 : arr) {
                curQueue.offer(Integer.parseInt(i1));
            }
            nestedQueues.offer(curQueue);
        }
        // input ends

        int count = 0;
        while (!nestedQueues.isEmpty()) {
            Queue<Integer> curQueue = nestedQueues.poll();
            int seismicity = curQueue.poll();
            while (!curQueue.isEmpty()) {
                if (seismicity >= curQueue.peek()) {
                    curQueue.poll();
                } else {
                    result.offer(seismicity);
                    nestedQueues.offer(curQueue);
                    count++;
                    break;
                }
            }
            if (curQueue.isEmpty()) {
                result.offer(seismicity);
                count++;
            }
        }
        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(String.format("%d ", integer));
        }
        System.out.println(sb);
    }
}
