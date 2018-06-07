import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class LittleAlchemy {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Integer[] numbers = Arrays.stream(input.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(queue, numbers);
        String line;
        int countOfSecretStorage = 0;
        while (!"Revision".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            int num = Integer.parseInt(lineInfo[2]);
            switch (lineInfo[0]) {
                case "Apply":
                    for (int i = 0; i < num; i++) {
                        if (queue.isEmpty()) {
                                break;
                        }
                        int queuePoll = queue.poll();
                        queuePoll--;
                        if (queuePoll == 0) {
                            countOfSecretStorage++;
                        } else {
                            queue.offer(queuePoll);
                        }
                    }
                    break;
                case "Air":
                    if (countOfSecretStorage != 0) {
                        queue.offer(num);
                        countOfSecretStorage--;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : queue) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
        System.out.println(countOfSecretStorage);

    }
}
