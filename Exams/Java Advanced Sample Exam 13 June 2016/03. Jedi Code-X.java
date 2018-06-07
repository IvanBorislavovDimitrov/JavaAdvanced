import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediCodeX {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(input.readLine()); // TODO add space
        }

        String firstPattern = input.readLine();
        String secondPattern = input.readLine();


        String firstRegex = (firstPattern) + "([a-zA-Z]{" + firstPattern.length() + "})";
        String secondRegex = (secondPattern) + "([a-zA-Z\\d]{" + secondPattern.length() + "})";

        Pattern pattern1 = Pattern.compile(firstRegex);
        Pattern pattern2 = Pattern.compile(secondRegex);

        Matcher firstWords = pattern1.matcher(sb);
        Matcher secondWords = pattern2.matcher(sb);

        List<String> names = new ArrayList<>();
        List<String> patterns = new ArrayList<>();

        while (firstWords.find()) {
            names.add(firstWords.group(1));
        }

        while (secondWords.find()) {
            patterns.add(secondWords.group(1));
        }

        int[] indexes = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0;
        for (int index : indexes) {
            if (index <= patterns.size() && cnt < names.size()) {
                System.out.println(String.format("%s - %s", names.get(cnt++), patterns.get(index - 1)));
            }
        }
    }
}
