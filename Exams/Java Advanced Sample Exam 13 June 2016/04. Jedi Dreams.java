import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediDreams {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String staticMethodsRegex = "static\\s+[a-z]+\\s+(.*?)\\(.*?\\)";
        String normalMethodsRegex = "([\\w][a-zA-Z\\d]*)\\(.*?|([A-Z][a-zA-Z\\d]*)\\(.*?\\)\\)";

        Map<String, List<String>> methods = new LinkedHashMap<>();

        Pattern staticMethodsPattern = Pattern.compile(staticMethodsRegex);
        Pattern normalMethodsPattern = Pattern.compile(normalMethodsRegex);

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(input.readLine()).append(System.lineSeparator());
        }

        Matcher staticMethods = staticMethodsPattern.matcher(sb);

        List<String> methodNames = new ArrayList<>();
        while (staticMethods.find()) {
            methods.putIfAbsent(staticMethods.group(1), new ArrayList<>());
            methodNames.add(staticMethods.group(1));
        }

        for (String methodName : methodNames) {
            int indexOfMethodName = sb.indexOf(methodName) + methodName.length();
            int indexOfNextStatic = sb.indexOf("static", indexOfMethodName + 1);
            if (indexOfNextStatic == -1) {
                indexOfNextStatic = sb.length();
            }
            String methodBody = sb.substring(indexOfMethodName, indexOfNextStatic);
            Matcher normalMethods = normalMethodsPattern.matcher(methodBody);

            while (normalMethods.find()) {
                if (normalMethods.group(1).equals("for") || normalMethods.group(1).equals("switch") ||
                        normalMethods.group(1).equals("while") || normalMethods.group(1).equals("do")) {
                    continue;
                }
                methods.get(methodName).add(normalMethods.group(1));
            }
        }


        methods.entrySet().stream()
                .sorted((x1, x2) -> {
                    if (x1.getValue().size() == x2.getValue().size()) {
                        return x1.getKey().compareTo(x2.getKey());
                    }

                    return Integer.compare(x2.getValue().size(), x1.getValue().size());
                }).forEach(m -> {
            m.getValue().sort(String::compareTo);
            System.out.println(String.format("%s -> %d -> %s", m.getKey(), m.getValue().size(),
                    String.join(", ", m.getValue())));
        });

    }
}
