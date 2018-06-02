package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BasicQueueOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        int countOfElementsToPush = Integer.parseInt(numbers[0]);
        int countOfElementsToPop  = Integer.parseInt(numbers[1]);
        int isThereNumber = Integer.parseInt(numbers[2]);

        Deque<Integer> queue = new ArrayDeque<>();
        String[] crNumbers = input.readLine().split("\\s+");
        Integer[] elements = new Integer[crNumbers.length];
        int cnt = 0;
        for (String crNumber : crNumbers) {
            elements[cnt++] = Integer.parseInt(crNumber);
        }
        for (int i = 0; i < countOfElementsToPush; i++) {
            queue.offer(elements[i]);
        }
        for (int i = 0; i < countOfElementsToPop; i++) {
            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }
            queue.poll();
        }

        System.out.println(queue.contains(isThereNumber) ? true : smallestElement(queue));
    }

    private static int smallestElement(Deque<Integer> elements) {
        List<Integer> list = new ArrayList<>(elements);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        return list.size() == 0 ? 0 : list.get(0);
    }
}
