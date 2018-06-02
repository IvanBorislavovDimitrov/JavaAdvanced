package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BiPredicate<String, Integer> checkNamePredicate = createPredicateForNameCheck();
        int n = Integer.parseInt(input.readLine());
        String[] names = input.readLine().split("\\s+");
        
        Arrays.stream(names).forEach(x -> {
            if (checkNamePredicate.test(x, n)) {
                System.out.println(x);
            }
        });

    }

    private static BiPredicate<String, Integer> createPredicateForNameCheck() {
        return (x1, x2) -> x1.length() <= x2;
    }
}
