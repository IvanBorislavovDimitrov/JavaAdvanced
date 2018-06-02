package linear_data_structures_exercise;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class RecursiveFibonacci {

    private static long[] arr = new long[100];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        System.out.println(fib(n + 1));
    }

    private static long fib(int n) {
        if(n < 2)
            arr[n] = n;
        else if(0 == arr[n])
            arr[n] = fib(n - 1) + fib(n - 2);
        return arr[n];
    }
}
