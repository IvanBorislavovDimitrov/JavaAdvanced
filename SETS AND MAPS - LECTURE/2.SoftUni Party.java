package sets_and_maps_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    private static final String PARTY = "PARTY";
    private static final String END = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<String> vipGuests = new TreeSet<>();
        Set<String> normalGuests = new TreeSet<>();
        String guestNumber;
        while (!PARTY.equals(guestNumber = input.readLine())) {
            if (isVip(guestNumber)) {
                vipGuests.add(guestNumber);
            } else {
                normalGuests.add(guestNumber);
            }
        }

        while (!END.equals(guestNumber = input.readLine())) {
            if (isVip(guestNumber)) {
                vipGuests.remove(guestNumber);
            } else {
                normalGuests.remove(guestNumber);
            }
        }

        printPeople(vipGuests, normalGuests);
    }

    private static void printPeople(Set<String> vipGuests, Set<String> normalGuests) {
        System.out.println(vipGuests.size() + normalGuests.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String normalGuest : normalGuests) {
            System.out.println(normalGuest);
        }
    }

    private static boolean isVip(String guestNumber) {
        return Character.isDigit(guestNumber.charAt(0));
    }
}
