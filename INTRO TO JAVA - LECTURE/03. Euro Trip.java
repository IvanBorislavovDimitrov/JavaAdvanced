package introduction_to_java_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EuroTrip {

    private static final String EXCHANGE_RATE = "4210500000000";

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double kilograms = Double.parseDouble(input.readLine()) * 1.2;
        BigDecimal priceOfWurst = new BigDecimal(EXCHANGE_RATE);
        System.out.printf("%.2f marks\n", priceOfWurst.multiply(new BigDecimal(kilograms)));
    }
}
