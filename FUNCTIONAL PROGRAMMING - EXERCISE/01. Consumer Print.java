package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> splitWords = x -> {
            x = x.replaceAll(" ", System.lineSeparator());
            System.out.println(x);
        };
        splitWords.accept(input.readLine());
    }
}
