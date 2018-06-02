package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVat {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(input.readLine().split("\\s*,\\s*"))
        .mapToDouble(Double::parseDouble)
        .forEach(x -> System.out.println(String.format("%.2f", addVat.apply(x))));
    }
}
