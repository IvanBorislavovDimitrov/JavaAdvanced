import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        String line;
        while (!"Print".equals(line = input.readLine())) {
            if (line.contains("%")) {
                line = line.replaceAll("%", "[^ ]*");
                line = line.replaceAll("\\.", "\\\\.");
                Pattern pattern = Pattern.compile(line);
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    String before = s.substring(0, s.indexOf(matcher.group()));
                    String after = s.substring(s.indexOf(matcher.group()) + matcher.group().length());
                    s = before + new StringBuilder(matcher.group()).reverse().toString() + after;
                }
            } else {
                int indexOf = s.indexOf(line);
                while (indexOf != -1) {
                    s = s.replaceAll(line, new StringBuilder(line).reverse().toString());
                    indexOf = s.indexOf(line, indexOf + 1);
                }
            }
        }

        System.out.println(s);
    }
}
