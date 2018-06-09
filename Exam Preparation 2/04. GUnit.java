package exam_prep_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Gunit {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Set<String>>> classes = new HashMap<>(); // TODO may be set

        String line;
        while (!"It's testing time!".equals(line = input.readLine())) {
            if (!isLineValid(line)) {
                if (line.split("\\s").length != 5) {
                    continue;
                }
                continue;
            }
            String[] lineInfo = line.split("\\s+\\|\\s+");
            String className = lineInfo[0];
            String methodName = lineInfo[1];
            String unitTestName = lineInfo[2];

            addUnitTest(classes, className, methodName, unitTestName);
        }

        printClasses(classes);
    }

    private static void printClasses(Map<String, Map<String, Set<String>>> classes) {
        classes.entrySet().stream()
                .sorted((x1, x2) -> {
                    int c1 = 0;
                    int c2 = 0;
                    Collection<Set<String>> first = x1.getValue().values();
                    for (Set<String> strings : first) {
                        c1 += strings.size();
                    }
                    Collection<Set<String>> second = x2.getValue().values();
                    for (Set<String> strings : second) {
                        c2 += strings.size();
                    }
                    if (c1 == c2) {
                        if (x1.getValue().values().size() == x2.getValue().values().size()) {
                            return x1.getKey().compareTo(x2.getKey());
                        }
                        return Integer.compare(x1.getValue().values().size(), x2.getValue().values().size());
                    }
                    return Integer.compare(c2, c1);
                })
                .forEach(c -> {
                    System.out.println(c.getKey() + ":");
                    c.getValue().entrySet()
                            .stream()
                            .sorted((x1, x2) -> {
                                if (x1.getValue().size() == x2.getValue().size()) {
                                    return x1.getKey().compareTo(x2.getKey());
                                }
                                return Integer.compare(x2.getValue().size(), x1.getValue().size());
                            })
                            .forEach(m -> {
                                System.out.println("##" + m.getKey());
                                m.getValue().stream()
                                        .sorted((x1, x2) -> {
                                            if (x1.length() == x2.length()) {
                                                return x1.compareTo(x2);
                                            }

                                            return Integer.compare(x1.length(), x2.length());
                                        })
                                        .forEach(s -> {
                                            System.out.println("####" + s);
                                        });
                            });
                });
    }

    private static void addUnitTest(Map<String, Map<String, Set<String>>> classes, String className,
                                    String methodName, String unitTestName) {
        classes.putIfAbsent(className, new HashMap<>());
        classes.get(className).putIfAbsent(methodName, new HashSet<>());
        classes.get(className).get(methodName).add(unitTestName);
    }

    private static boolean isLineValid(String lineInfo) {
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9]+\\s\\|\\s[A-Z][a-zA-Z0-9]+\\s\\|\\s[A-Z][a-zA-Z0-9]+$");
        return pattern.matcher(lineInfo).matches();
    }
}
