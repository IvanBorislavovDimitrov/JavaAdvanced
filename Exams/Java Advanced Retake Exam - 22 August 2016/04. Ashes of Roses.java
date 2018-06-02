import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> regions = new HashMap<>();
        String line;
        while (!"Icarus, Ignite!".equals(line = input.readLine())) {
            String[] infoLine = line.split("\\s");
            if (infoLine[0].compareTo("Grow") != 0 || infoLine.length != 4) {
                continue;
            }
            String regionName = getName(infoLine[1]);
            String colorName = getName(infoLine[2]);
            String roseAmountStr = infoLine[3];
            if (!isInputValid(regionName, colorName, roseAmountStr)) {
                continue;
            }
            if (containsSymbol(infoLine[1]) && containsSymbol(infoLine[2])) {
                continue;
            }
            long roseAmount = Long.parseLong(roseAmountStr);
            addRegion(regions, regionName, colorName, roseAmount);
        }

        printRegions(regions);
    }

    private static String getName(String rawInput) {
        return rawInput.substring(1, rawInput.length() - 1);
    }

    private static void printRegions(Map<String, Map<String, Long>> regions) {
        regions.entrySet()
                .stream()
                .sorted((r1, r2) -> {
                    long firstRegionRoseAmount = r1.getValue().entrySet().stream().map(Map.Entry::getValue).mapToLong(i -> i).sum();
                    long secondRegionRoseAmount = r2.getValue().entrySet().stream().map(Map.Entry::getValue).mapToLong(i -> i).sum();
                    if (firstRegionRoseAmount == secondRegionRoseAmount) {
                        return r1.getKey().compareTo(r2.getKey());
                    }

                    return Long.compare(secondRegionRoseAmount, firstRegionRoseAmount);
                }).forEach(r -> {
            System.out.println(r.getKey());
            r.getValue()
                    .entrySet()
                    .stream()
                    .sorted((c1, c2) -> {
                        long firstColorAmount = c1.getValue();
                        long secondColorAmount = c2.getValue();
                        if (firstColorAmount == secondColorAmount) {
                            return c1.getKey().compareTo(c2.getKey());
                        }

                        return Long.compare(firstColorAmount, secondColorAmount);
                    }).forEach(c -> System.out.println(String.format("*--%s | %d", c.getKey(), c.getValue())));
        });
    }

    private static void addRegion(Map<String, Map<String, Long>> regions, String regionName, String colorName,
                                  long roseAmount) {
        if (!regions.containsKey(regionName)) {
            regions.put(regionName, new HashMap<>());
            regions.get(regionName).put(colorName, roseAmount);
        } else {
            if (!regions.get(regionName).containsKey(colorName)) {
                regions.get(regionName).put(colorName, roseAmount);
            } else {
                regions.get(regionName).put(colorName, regions.get(regionName).get(colorName) + roseAmount);
            }
        }
    }

    private static boolean isInputValid(String regionName, String colorName, String roseAmountStr) {
        boolean isRegionNameValid = isRegionNameValid(regionName);
        boolean isColorNameValid = isColorNameValid(colorName);
        boolean isRoseAmountValid = isRoseAmountValid(roseAmountStr);

        return isColorNameValid && isRegionNameValid && isRoseAmountValid;
    }

    private static boolean isRoseAmountValid(String roseAmount) {
        try {
            Long.parseLong(roseAmount);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean isColorNameValid(String colorName) {
        boolean isFirstUpper = Character.isUpperCase(colorName.charAt(0));
        if (!isFirstUpper) {
            return false;
        }
        for (int i = 1; i < colorName.length(); i++) {
            if (!Character.isAlphabetic(colorName.charAt(i)) && !Character.isDigit(colorName.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean containsSymbol(String str) {
        return !str.contains("<") && !str.contains(">");
    }

    private static boolean isRegionNameValid(String regionName) {
        boolean isFirstUpper = Character.isUpperCase(regionName.charAt(0));
        if (!isFirstUpper) {
            return false;
        }
        for (int i = 1; i < regionName.length(); i++) {
            if (!Character.isLowerCase(regionName.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
