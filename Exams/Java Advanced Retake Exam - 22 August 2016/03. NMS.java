import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while (!"---NMS SEND---".equals(line = input.readLine())) {
            sb.append(line);
        }
        String delimiter = input.readLine();
        printSequences(sb.toString(), delimiter);
    }

    private static void printSequences(String text, String delimiter) {
        int start = 0;
        int end = text.length();
        int stop = 0;
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            if (stop + 1 >= end) {
                sb.append(text.substring(start, stop + 1)).append(delimiter);
                break;
            }
            char currentCh = Character.toLowerCase(text.charAt(stop));
            char nextCh = Character.toLowerCase(text.charAt(stop + 1));
            if (currentCh <= nextCh) {
                stop++;
            } else {
                sb.append(text.substring(start, stop + 1)).append(delimiter);
                stop++;
                start = stop;
            }
        }

        System.out.println(sb.substring(0, sb.length() - delimiter.length()));
    }
}
