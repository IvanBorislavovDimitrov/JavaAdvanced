import java.util.Scanner;
import java.util.regex.Matcher;

public class ReplaceATag {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while (! (line = input.nextLine()).equals("END")) {
            stringBuilder.append(line).append(System.lineSeparator());
        }

        int firstIndex = stringBuilder.indexOf("<a");
        int secondIndex = stringBuilder.indexOf("a>");
        while (firstIndex != -1 && secondIndex != -1) {
            String textBefore = stringBuilder.substring(0, firstIndex);
            String lastText = stringBuilder.substring(secondIndex + 2);
            String middlePart = stringBuilder.substring(firstIndex, secondIndex + 1);
            middlePart = "[URL" + middlePart.substring(2);
            middlePart = middlePart.substring(0, middlePart.indexOf(">"))
                + "]" + middlePart.substring(middlePart.indexOf(">") + 1);
            middlePart = middlePart.substring(0, middlePart.indexOf("<"))
                + "[/URL]";

            stringBuilder = new StringBuilder(textBefore + middlePart + lastText);
            firstIndex = stringBuilder.indexOf("<a");
            secondIndex = stringBuilder.indexOf("a>");
        }

        System.out.println(stringBuilder);
    }
}
