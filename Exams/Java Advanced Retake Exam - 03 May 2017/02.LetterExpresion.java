import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([+-]?[0-9]*[.]?[0-9]*)(.*?)([+-]?[0-9]*[.]?[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        double sum = 0;
        String text = input.readLine();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            double left = Double.parseDouble(matcher.group(1));
            int cnt = matcher.group(2).length();

            double right = Double.parseDouble(matcher.group(3));

            if (cnt % 2 == 0) {
                sum = (left + right);
            } else {
                sum = (left - right);
            }
            if (cnt == 0) {
                break;
            }
            text = sum + text.substring(text.indexOf(matcher.group()) + matcher.group().length());
            matcher = pattern.matcher(text);
        }

        System.out.println(new DecimalFormat("#.#######").format(sum));
    }
}
