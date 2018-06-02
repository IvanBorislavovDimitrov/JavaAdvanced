package linear_data_structures_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptSortPrintArray {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfElements = Integer.parseInt(input.readLine());
        String[] arr = new String[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            arr[i] = input.readLine();
        }

        int[] sums = getSums(arr);
        Arrays.sort(sums);

        printArr(sums);
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int[] getSums(String[] strings) {
        int[] sums = new int[strings.length];
        int cnt = 0;
        for (String string : strings) {
            sums[cnt++] = getSumOfCurrentSum(string);
        }

        return sums;
    }

    private static int getSumOfCurrentSum(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                sum += ch * str.length();
            } else {
                sum += ch / str.length();
            }
        }

        return sum;
    }

    private static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'u' || lowerCh == 'o';
    }
}
