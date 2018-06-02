package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BasicStackOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split("\\s+");
        int countOfElementsToPush = Integer.parseInt(numbers[0]);
        int countOfElementsToPop  = Integer.parseInt(numbers[1]);
        int isThereNumber = Integer.parseInt(numbers[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] crNumbers = input.readLine().split("\\s+");
        Integer[] elements = new Integer[crNumbers.length];
        int cnt = 0;
        for (String crNumber : crNumbers) {
            elements[cnt++] = Integer.parseInt(crNumber);
        }
        for (int i = 0; i < countOfElementsToPush; i++) {
            stack.push(elements[i]);
        }
        for (int i = 0; i < countOfElementsToPop; i++) {
            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }
            stack.pop();
        }

        System.out.println(stack.contains(isThereNumber) ? true : smallestElement(stack));
    }

    private static int smallestElement(ArrayDeque<Integer> elements) {
        List<Integer> list = new ArrayList<>(elements);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        return list.get(0);
    }
}
