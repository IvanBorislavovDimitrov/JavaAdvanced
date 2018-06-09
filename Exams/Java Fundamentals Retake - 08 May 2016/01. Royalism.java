import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Royalism {

    private static final int R_POS = 18;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] totalBelievers = input.readLine().split("\\s+");
        List<String> royalists = new ArrayList<>();
        List<String> others = new ArrayList<>();

        for (String believer : totalBelievers) {
            int currentBelieverSum = getSum(believer);
            if (R_POS == currentBelieverSum) {
                royalists.add(believer);
            } else {
                others.add(believer);
            }
        }

        if (royalists.size() >= others.size()) {
            System.out.println("Royalists - " + royalists.size());
            royalists.forEach(System.out::println);
            System.out.println("All hail Royal!");
        } else {
            others.forEach(System.out::println);
            System.out.println("Royalism, Declined!");
        }
    }

    private static int getSum(String believer) {
        int sum = 0;
        for (int i = 0; i < believer.length(); i++) {
            sum += believer.charAt(i);
            sum %= 26;
        }

        return sum;
    }
}
