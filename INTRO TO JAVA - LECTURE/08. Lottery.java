package introduction_to_java_lab;

public class Lottery {

    public static void main(String[] args) {
        int lengthOfCombinations = 3;
        int[] currentCombinations = new int[lengthOfCombinations];
        getCombinations(currentCombinations, 0);
    }

    private static void getCombinations(int[] arr, int index) {
        if (index == arr.length) {
            if (isValid(arr))
                printArr(arr);
        } else {
            for (int i = 1; i <= 10; i++) {
                arr[index] = i;
                getCombinations(arr, index + 1);
            }
        }
    }

    private static boolean isValid(int[] arr) {
        return arr[0] < arr[1] && arr[1] < arr[2];
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
