import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BitSnow {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split(",\\s+");
        List<char[]> numbersInBinary = new ArrayList<>();
        for (String number : numbers) {
            String num = String.format("%16s", Integer.toBinaryString(Integer.parseInt(number))).replaceAll(" ", "0");
            numbersInBinary.add(num.toCharArray());
        }
        boolean isFall = true;
        while (isFall) {
            isFall = false;
            for (int i = numbersInBinary.size() - 1; i > 0; i--) {
                if (fall(numbersInBinary, i - 1, i)) {
                    isFall = true;
                }
            }
        }

        toDecimal(numbersInBinary);
    }

    private static void toDecimal(List<char[]> numbers) {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(x -> {
            int num = Integer.parseInt(charArrayToString(x), 2);
            sb.append(String.format("%d, ", num));
        });
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }

    private static String charArrayToString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static boolean fall(List<char[]> numbersInBinary, int i1, int i2) {
        boolean fall = false;
        for (int i = 0; i < numbersInBinary.get(i1).length; i++) {
            if (numbersInBinary.get(i1)[i] == '1' && numbersInBinary.get(i2)[i] == '0') {
                numbersInBinary.get(i1)[i] = '0';
                numbersInBinary.get(i2)[i] = '1';
                fall = true;
            }
        }

        return fall;
    }
}
