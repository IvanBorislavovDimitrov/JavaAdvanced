import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalFlush {

    private static final String C_FLUSH = "10cJcQcKcAc";
    private static final String D_FLUSH = "10dJdQdKdAd";
    private static final String H_FLUSH = "10hJhQhKhAh";
    private static final String S_FLUSH = "10sJsQsKsAs";

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(input.readLine());
        String matchCardsRegex = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)([cdhs])";
        Pattern pattern = Pattern.compile(matchCardsRegex);
        StringBuilder sb = new StringBuilder();

        StringBuilder cPaint = new StringBuilder();
        StringBuilder dPaint = new StringBuilder();
        StringBuilder hPaint = new StringBuilder();
        StringBuilder sPaint = new StringBuilder();

        for (int i = 0; i < lineCount; i++) {
            Matcher matcherForCards = pattern.matcher(input.readLine());
            while (matcherForCards.find()) {
                sb.append(matcherForCards.group()).append(" ");
            }
        }
        int cnt = 0;

        for (String s : sb.toString().split(" ")) {
            switch (String.valueOf(s.charAt(s.length() - 1))) {
                case "c":
                    cPaint.append(s);
                    if (cPaint.toString().contains(C_FLUSH)) {
                        System.out.println("Royal Flush Found - Clubs");
                        cnt++;
                        cPaint = new StringBuilder();
                    }
                    break;
                case "d":
                    dPaint.append(s);
                    if (dPaint.toString().contains(D_FLUSH)) {
                        System.out.println("Royal Flush Found - Diamonds");
                        cnt++;
                        dPaint = new StringBuilder();
                    }
                    break;
                case "h":
                    hPaint.append(s);
                    if (hPaint.toString().contains(H_FLUSH)) {
                        System.out.println("Royal Flush Found - Hearts");
                        cnt++;
                        hPaint = new StringBuilder();
                    }
                    break;
                case "s":
                    sPaint.append(s);
                    if (sPaint.toString().contains(S_FLUSH)) {
                        System.out.println("Royal Flush Found - Spades");
                        cnt++;
                        sPaint = new StringBuilder();
                    }
                    break;
            }
        }
        System.out.println(String.format("Royal's Royal Flushes - %d.", cnt));
    }
}
