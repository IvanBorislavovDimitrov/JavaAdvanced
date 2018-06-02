import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DharmaSonarFace {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"Reprogram".equals(line = input.readLine())) {
            char[] inBinary = String.format("%32s", Integer.toBinaryString(Integer.parseInt(line)))
                    .replaceAll(" ", "0")
                    .toCharArray();
            System.out.println(switchNumber(inBinary));
        }
    }

    private static long switchNumber(char[] numberInBinary) {
        int startIndex = 0;
        while (startIndex < numberInBinary.length - 1) {
            if (numberInBinary[startIndex] == '0' && numberInBinary[startIndex + 1] == '0') {
                numberInBinary[startIndex] = '1';
                numberInBinary[startIndex + 1] = '1';
                startIndex += 2;
            } else if (numberInBinary[startIndex] == '1' && numberInBinary[startIndex + 1] == '1') {
                numberInBinary[startIndex] = '0';
                numberInBinary[startIndex + 1] = '0';
                startIndex += 2;
            } else {
                startIndex += 1;
            }
        }

        return Long.parseLong(String.valueOf(charArrayToString(numberInBinary)), 2);
    }

    private static String charArrayToString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
