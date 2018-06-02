package sets_and_maps_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<String> plateNumbers = new HashSet<>();

        String line;
        while (! "END".equals(line = input.readLine())) {
            String[] lineInfo = line.split(",\\s+");
            String command = lineInfo[0];
            String plateNumber = lineInfo[1];

            switch (command) {
                case "IN":
                    plateNumbers.add(plateNumber);
                    break;
                case "OUT":
                    plateNumbers.remove(plateNumber);
                    break;
            }
        }

        if (plateNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String plateNumber : plateNumbers) {
                System.out.println(plateNumber);
            }

        }
    }
}
