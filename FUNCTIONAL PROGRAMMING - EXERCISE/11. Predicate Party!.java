package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> contributors = Arrays.stream(input.readLine().split("\\s+")).collect(Collectors.toList());;

        BiConsumer<String, List<String>> doubleStartsWith = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).startsWith(c)) {
                    p.add(i, p.get(i++));
                }
            }
        };
        BiConsumer<Integer, List<String>> doubleLength = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).length() == c) {
                    p.add(i, p.get(i++));
                }
            }
        };
        BiConsumer<String, List<String>> doubleEndsWith = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).endsWith(c)) {
                    p.add(i, p.get(i++));
                }
            }
        };
        BiConsumer<String, List<String>> removeStartsWith = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).startsWith(c)) {
                    p.remove(i--);
                }
            }
        };
        BiConsumer<Integer, List<String>> removeLength = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).length() == c) {
                    p.remove(i--);
                }
            }
        };
        BiConsumer<String, List<String>> removeEndsWith = (c, p) -> {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).endsWith(c)) {
                    p.remove(i--);
                }
            }
        };
        String line;
        while (!"Party!".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String commandRemoveDelete = lineInfo[0];
            String command = lineInfo[1];
            String condition = lineInfo[2];
            switch (commandRemoveDelete) {
                case "Remove":
                    doubleRemove(contributors, removeStartsWith, removeLength, removeEndsWith, command, condition);
                    break;
                case "Double":
                    doubleRemove(contributors, doubleStartsWith, doubleLength, doubleEndsWith, command, condition);
                    break;
            }
        }

        System.out.println(contributors.isEmpty() ? "Nobody is going to the party!" :
                            String.format("%s are going to the party!", String.join(", ", contributors)));
    }

    private static void doubleRemove(List<String> contributors, BiConsumer<String, List<String>> doubleStartsWith, BiConsumer<Integer, List<String>> doubleLength, BiConsumer<String, List<String>> doubleEndsWith, String command, String condition) {
        switch (command) {
            case "StartsWith":
                doubleStartsWith.accept(condition, contributors);
                break;
            case "Length":
                doubleLength.accept(Integer.parseInt(condition), contributors);
                break;
            case "EndsWith":
                doubleEndsWith.accept(condition, contributors);
                break;
        }
    }
}
