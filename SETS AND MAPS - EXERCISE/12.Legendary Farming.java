package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {

    private static class Hero {
        private String name;
        private int itemsCount;

        public Hero(String name) {
            this.name = name;
            this.itemsCount = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public void setItemsCount(int itemsCount) {
            this.itemsCount = itemsCount;
        }
    }

    private static final short WINNER_VALUE = 250;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Hero shadowmourne = new Hero("Shadowmourne");
        Hero valanyr = new Hero("Valanyr");
        Hero dragonwrath = new Hero("Dragonwrath");

        Map<String, Integer> junkElements = new HashMap<>();
        Map<String, Integer> normalElements = new HashMap<>();

        normalElements.put("shards", 0);
        normalElements.put("fragments", 0);
        normalElements.put("motes", 0);

        while (true) {
            String[] itemsInfo = input.readLine().split("\\s+");
            for (int i = 0; i < itemsInfo.length; i += 2) {
                String elementName = itemsInfo[i + 1];
                int elementCount = Integer.parseInt(itemsInfo[i]);
                Hero winner = addElement(shadowmourne, valanyr, dragonwrath,
                        elementName, elementCount, junkElements, normalElements);

                if (winner != null) {
                    printWinner(winner, junkElements, normalElements);
                    return;
                }
            }
        }
    }

    private static void printWinner(Hero winner, Map<String, Integer> junkElements,
                                    Map<String, Integer> normalElements) {
        System.out.println(winner.getName() + " obtained!");
        normalElements.entrySet()
                .stream()
                .sorted((x1, x2) -> {
                    if (x2.getValue().compareTo(x1.getValue()) == 0) {
                        return x1.getKey().compareTo(x2.getKey());
                    }

                    return x2.getValue().compareTo(x1.getValue());
                })
                .forEach(x -> System.out.println(String.format("%s: %d", x.getKey(), x.getValue())));
        junkElements.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> System.out.println(String.format("%s: %d", x.getKey(), x.getValue())));
    }

    private static Hero addElement(Hero shadowmourne, Hero valanyr, Hero dragonwrath,
                                   String elementName, int elementCount, Map<String, Integer> junkElements,
                                   Map<String, Integer> normalElements) {
        String elementNameLowerCase = elementName.toLowerCase();
        switch (elementNameLowerCase) {
            case "shards":
                int newItemsCount = shadowmourne.getItemsCount() + elementCount;
                shadowmourne.setItemsCount(newItemsCount);
                Hero winner = getWinner(shadowmourne, valanyr, dragonwrath);
                normalElements.put(elementNameLowerCase, newItemsCount);
                if (winner != null) {
                    normalElements.put(elementNameLowerCase, normalElements.get(elementNameLowerCase) - WINNER_VALUE);
                    return winner;
                }
                break;
            case "fragments":
                newItemsCount = valanyr.getItemsCount() + elementCount;
                valanyr.setItemsCount(newItemsCount);
                winner = getWinner(shadowmourne, valanyr, dragonwrath);
                normalElements.put(elementNameLowerCase, newItemsCount);
                if (winner != null) {
                    normalElements.put(elementNameLowerCase, normalElements.get(elementNameLowerCase) - WINNER_VALUE);
                    return winner;
                }
                break;
            case "motes":
                newItemsCount = dragonwrath.getItemsCount() + elementCount;
                dragonwrath.setItemsCount(newItemsCount);
                winner = getWinner(shadowmourne, valanyr, dragonwrath);
                normalElements.put(elementNameLowerCase, newItemsCount);
                if (winner != null) {
                    normalElements.put(elementNameLowerCase, normalElements.get(elementNameLowerCase) - WINNER_VALUE);
                    return winner;
                }
                break;
            default:
                if (!junkElements.containsKey(elementNameLowerCase)) {
                    junkElements.put(elementNameLowerCase, elementCount);
                } else {
                    junkElements.put(elementNameLowerCase, junkElements.get(elementNameLowerCase) + elementCount);
                }
                break;
        }

        return null;
    }


    private static Hero getWinner(Hero shadowmourne, Hero valanyr, Hero dragonwrath) {
        if (shadowmourne.getItemsCount() >= WINNER_VALUE) {
            return shadowmourne;
        } else if (valanyr.getItemsCount() >= WINNER_VALUE) {
            return valanyr;
        } else if (dragonwrath.getItemsCount() >= WINNER_VALUE) {
            return dragonwrath;
        }

        return null;
    }
}
