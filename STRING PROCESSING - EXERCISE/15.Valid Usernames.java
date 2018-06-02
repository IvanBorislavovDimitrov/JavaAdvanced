package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] names = input.readLine().split("\\s+|\\/+|\\\\+|\\(+|\\)+");
        List<String> validNames = new ArrayList<>();

        for (String name : names) {
            if (isValid(name)) {
                validNames.add(name);
            }
        }

        bestTwo(validNames);
    }

    private static void bestTwo(List<String> words) {
        String firstBest = words.get(0);
        String secondBest = words.get(1);
        int bestSum = words.get(0).length() + words.get(1).length();
        for (int i = 1; i < words.size() - 1; i++) {
            int currentSum = words.get(i).length() + words.get(i + 1).length();
            if (currentSum > bestSum) {
                firstBest = words.get(i);
                secondBest = words.get(i + 1);
                bestSum = currentSum;
            }
        }

        System.out.println(firstBest);
        System.out.println(secondBest);
    }
    private static boolean isValid(String name) {
        Pattern pattern = Pattern.compile("^[A-Za-z][0-9_A-Za-z]{2,24}$");
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }
}
