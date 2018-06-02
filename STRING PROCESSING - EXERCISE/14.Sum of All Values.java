package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfAllValues {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String keyString = input.readLine();
        String textString = input.readLine();

        String startKey = getStartKey(keyString);
        String endKey = getEndKey(keyString);

        if (startKey == null || startKey.trim().equals("") || endKey == null || endKey.trim().equals("")) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        double result = getValue(textString, startKey, endKey);
        if (isInteger(result)) {
            System.out.println(result != 0 ? String.format("<p>The total value is: <em>%.0f</em></p>", result) :
                    "<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println(result != 0 ? String.format("<p>The total value is: <em>%.2f</em></p>", result) :
                    "<p>The total value is: <em>nothing</em></p>");
        }

    }

    private static double getValue(String textString, String startKey, String endKey) {
        int indexOfStartKey = textString.indexOf(startKey);
        int indexOfEndKey = textString.indexOf(endKey, indexOfStartKey + startKey.length() - 1);

        double sum = 0;

        while (indexOfStartKey != -1 && indexOfEndKey != -1) {
            String toSearch = textString.substring(indexOfStartKey + startKey.length(), indexOfEndKey);
            if (isDouble(toSearch)) {
                double num = Double.parseDouble(toSearch);
                sum += num;
            }

            indexOfStartKey = textString.indexOf(startKey, indexOfEndKey + 1);
            indexOfEndKey = textString.indexOf(endKey, indexOfStartKey + startKey.length());
        }


        return sum;
    }

    private static boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isInteger(double number) {
        String num = String.valueOf(number);
        for (int i = num.indexOf(".") + 1; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                return false;
            }
        }

        return true;
    }

    private static String getEndKey(String keyString) {
        for (int i = keyString.length() - 1; i >= 0; i--) {
            if (Character.isDigit(keyString.charAt(i))) {
                return keyString.substring(i + 1);
            }
        }

        return null;
    }

    private static String getStartKey(String keyString) {
        for (int i = 0; i < keyString.length(); i++) {
            if (Character.isDigit(keyString.charAt(i))) {
                return keyString.substring(0, i);
            }
        }

        return null;
    }
}
