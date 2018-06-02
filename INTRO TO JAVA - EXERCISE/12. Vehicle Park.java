package introduction_to_java_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehiclePark {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String availableCarsInString = input.readLine();
        List<String> availableCars = availableCars(availableCarsInString);
        String line;
        int vehiclesSold = 0;
        while (! "End of customers!".equals(line = input.readLine())) {
            String[] infoAboutPurchase = line.split("\\s+");
            String type = infoAboutPurchase[0];
            int seats = Integer.parseInt(infoAboutPurchase[2]);
            Integer price = purchase(availableCars, Character.toLowerCase(type.charAt(0)), seats);
            if (price == null) {
                System.out.println("No");
            } else {
                System.out.println(String.format("Yes, sold for %d$", price));
                vehiclesSold++;
            }
        }

        System.out.println(String.format("Vehicles left: %s", String.join(", ", availableCars)));
        System.out.println("Vehicles sold: " + vehiclesSold);
    }

    private static Integer purchase(List<String> availableCars, char type, int seats) {
        for (int i = 0; i < availableCars.size(); i++) {
            char currentType = Character.toLowerCase(availableCars.get(i).charAt(0));
            int currentSeats = Integer.parseInt(availableCars.get(i).substring(1));
            if (currentType == type && seats == currentSeats) {
                Integer price = currentSeats * type;
                availableCars.remove(i);
                return price;
            }
        }

        return null;
    }

    private static List<String> availableCars(String cars) {

        return new ArrayList<>(Arrays.asList(cars.split("\\s+")));
    }
}
