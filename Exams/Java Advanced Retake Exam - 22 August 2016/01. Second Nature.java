import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> secondNatureFlowers = new LinkedList<>();
        List<Integer> flowers = Arrays.stream(input.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> buckets = Arrays.stream(input.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (buckets.size() > 0 && flowers.size() > 0) {

            int bucketSize = buckets.get(buckets.size() - 1);
            int flowerSize = flowers.get(0);
            int diff = bucketSize - flowerSize;

            if (diff > 0) {
                if (buckets.size()  == 1) {
                    buckets.set(buckets.size() - 1, buckets.get(buckets.size() - 1) - flowerSize);
                    flowers.remove(0);
                    continue;
                }
                buckets.remove(buckets.size() - 1);

                buckets.set(buckets.size() - 1, buckets.get(buckets.size() - 1) + diff);
                flowers.remove(0);
            } else if (diff == 0) {
                secondNatureFlowers.add(flowers.get(0));
                buckets.remove(buckets.size() - 1);
                flowers.remove(0);
            } else {
                flowers.set(0, Math.abs(diff));
                buckets.remove(buckets.size() - 1);
            }
        }
        if (flowers.size() == 0) {
            for (int i = buckets.size() - 1; i >= 0; i--) {
                System.out.printf("%d ", buckets.get(i));
            }
        } else {
            for (int i = 0; i < flowers.size(); i++) {
                System.out.printf("%d ", flowers.get(i));
            }
        }
        System.out.println();
        if (secondNatureFlowers.size() == 0) {
            System.out.println("None");
        } else {
            for (Integer secondNatureFlower : secondNatureFlowers) {
                System.out.printf("%d ", secondNatureFlower);
            }
        }
        System.out.println();
    }
}
