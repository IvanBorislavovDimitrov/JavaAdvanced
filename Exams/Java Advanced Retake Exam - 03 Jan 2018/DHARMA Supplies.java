package last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regexForFood = "\\[(#\\d+)(.*?)(\\1)\\]";
        String regexForDrinks = "\\[(#[a-z]+)(.*?)(\\1)\\]";
        String regexForAll = "\\[.*?\\]";

        StringBuilder allLines = new StringBuilder();
        String line;
        int totalLinesSize = 0;
        while (!"Collect".equals(line = input.readLine())) {
            allLines.append(line);
            totalLinesSize++;
        }

        Pattern patternForFoods = Pattern.compile(regexForFood);
        Pattern patternForDrinks = Pattern.compile(regexForDrinks);
        Pattern patternForAll = Pattern.compile(regexForAll);

        Matcher matcherForFoods = patternForFoods.matcher(allLines);
        Matcher matcherForDrinks = patternForDrinks.matcher(allLines);
        Matcher matcherForAll = patternForAll.matcher(allLines);

        int totalSize = getTotalSize(matcherForAll);
        int n = totalSize / totalLinesSize;

        int amountOfFood = 0;
        int amountOfDrinks = 0;
        int countOfValid = 0;


        while (matcherForFoods.find()) {
            if (isTagValid(matcherForFoods, n)) {
                int foodAmount = getFoodAmount(matcherForFoods.group(2), n);
                amountOfFood += foodAmount;
                countOfValid++;
            }
        }


        while (matcherForDrinks.find()) {
            if (isTagValid(matcherForDrinks, n)) {
                int drinksAmount = getDrinksAmount(matcherForDrinks.group(2), matcherForDrinks.group(1));
                amountOfDrinks += drinksAmount;
                countOfValid++;
            }
        }

        if (countOfValid != 0 && (amountOfDrinks != 0 || amountOfFood != 0)) {
            System.out.println(String.format("Number of supply crates: %d", countOfValid));
            System.out.println(String.format("Amount of food collected: %d", amountOfFood));
            System.out.println(String.format("Amount of drinks collected: %d", amountOfDrinks));
        } else {
            System.out.println("No supplies found!");
        }

    }

    private static int getDrinksAmount(String drinks, String supplyTags) {
        int sumOfDrinkCharacters = 0;
        int sumOfSupplyTags = 0;
        for (int i = 0; i < drinks.length(); i++) {
            sumOfDrinkCharacters += drinks.charAt(i);
        }

        for (int i = 1; i < supplyTags.length(); i++) {
            sumOfSupplyTags += supplyTags.charAt(i);
        }

        return sumOfDrinkCharacters * sumOfSupplyTags;
    }

    private static int getFoodAmount(String food, int n) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < food.length(); i++) {
            set.add(food.charAt(i));
        }

        int sum = 0;
        for (Character character : set) {
            sum += character;
        }

        return sum * n;
    }

    private static boolean isTagValid(Matcher food, int n) {
        return food != null && food.group(1).length() - 1 == n;
    }

    private static int getTotalSize(Matcher all) {
        int count = 0;
        while (all.find()) {
            count++;
        }

        return count;
    }
}
