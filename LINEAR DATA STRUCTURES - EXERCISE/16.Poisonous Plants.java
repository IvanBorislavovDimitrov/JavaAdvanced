package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PoisonousPlants {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int days = 0;
        List<Integer> alivePlants = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            alivePlants.add(input.nextInt());
        }

        boolean plantDies = true;

        while (plantDies) {
            plantDies = false;
            for (int i = alivePlants.size() - 1; i >= 1; i--) {
                if (alivePlants.get(i) > alivePlants.get(i - 1)) {
                    alivePlants.remove(i);
                    plantDies = true;
                }
            }
            if (plantDies)
                days++;
        }


        System.out.println(days);
    }
}
