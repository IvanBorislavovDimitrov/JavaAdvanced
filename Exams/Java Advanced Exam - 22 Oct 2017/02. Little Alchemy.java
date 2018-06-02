import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LittleAcademy {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> firstStones = Arrays
                .stream(input.readLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Queue<Integer> stones = new LinkedList<>();
        Stack<Integer> goldStones = new Stack<>();
        stones.addAll(firstStones);

        String line;
        while (!"Revision".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String command = lineInfo[0];
            int value = Integer.parseInt(lineInfo[2]);

            switch (command) {
                case "Apply":
                    applyAcid(stones, value, goldStones);
                    break;
                case "Air":
                    airLeak(stones, value, goldStones);
                    break;
            }
        }
        printOutput(stones, goldStones);
    }

    private static void printOutput(Queue<Integer> stones, Stack<Integer> goldStones) {
        StringBuilder sb = new StringBuilder();
        for (Integer stone : stones) {
            sb.append(stone).append(" ");
        }
        System.out.println(sb);
        System.out.println(goldStones.size());
    }

    private static void airLeak(Queue<Integer> stones, int value, Stack<Integer> goldStones) {
        if (goldStones.isEmpty()) {
            return;
        }
        int stone = goldStones.pop();
        stone += value;
        stones.offer(stone);

    }

    private static void applyAcid(Queue<Integer> stones, int value, Stack<Integer> goldStones) {
        for (int i = 0; i < value; i++) {
            if (stones.isEmpty()) {
                continue;
            }
            int firstStone = stones.poll();
            firstStone--;
            if (firstStone == 0) {
                goldStones.push(firstStone);
            } else {
                stones.offer(firstStone);
            }
        }
    }
}
