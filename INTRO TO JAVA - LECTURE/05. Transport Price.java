package introduction_to_java_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransportPrice {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int kilometres = Integer.parseInt(input.readLine());
        String daytime = input.readLine();
        double lowestPrice = getPrice(kilometres, daytime);

        System.out.println(String.format("%.2f", lowestPrice));
    }

    private static double getPrice(int kilometres, String daytime) {
        double priceForTaxi = 0;
        double priceForBus = 0;
        double priceForTrain = 0;
        switch (daytime) {
            case "day":
                priceForTaxi = 0.70;
                priceForTaxi += 0.79 * kilometres;
                if (kilometres >= 20) {
                    priceForBus = 0.09 * kilometres;
                }
                if (kilometres >= 100) {
                    priceForTrain = 0.06 * kilometres;
                }
                break;
            case "night":
                priceForTaxi = 0.70;
                priceForTaxi += 0.90 * kilometres;
                if (kilometres >= 20) {
                    priceForBus = 0.09 * kilometres;
                }
                if (kilometres >= 100) {
                    priceForTrain = 0.06 * kilometres;
                }
                break;
        }

        double smallestPrice = priceForTaxi;
        if (smallestPrice > priceForBus && priceForBus != 0) {
            smallestPrice = priceForBus;
        }

        if (smallestPrice > priceForTrain && priceForTrain != 0) {
            smallestPrice = priceForTrain;
        }

        return smallestPrice;
    }
}
