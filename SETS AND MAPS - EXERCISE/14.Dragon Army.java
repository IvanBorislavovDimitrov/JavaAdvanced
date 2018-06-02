package sets_and_maps_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DragonArmy {

    private static class Stats {
        private static final int DEFAULT_HEALTH = 250;
        private static final int DEFAULT_DAMAGE = 45;
        private static final int DEFAULT_ARMOR = 10;

        private Integer damage;
        private Integer health;
        private Integer armor;

        public Stats(Integer damage, Integer health, Integer armor) {
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        public Integer getDamage() {
            return damage;
        }

        public void setDamage(Integer damage) {
            this.damage = damage == null ? DEFAULT_DAMAGE : damage;
        }

        public Integer getHealth() {
            return health;
        }

        public void setHealth(Integer health) {
            this.health = health == null ? DEFAULT_HEALTH : health;
        }

        public Integer getArmor() {
            return armor;
        }

        public void setArmor(Integer armor) {
            this.armor = armor == null ? DEFAULT_ARMOR : armor;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int dragonsCount = Integer.parseInt(input.readLine());
        Map<String, Map<String, Stats>> dragons = new LinkedHashMap<>(dragonsCount);

        for (int i = 0; i < dragonsCount; i++) {
            String line = input.readLine();
            addDragon(dragons, line);
        }

        printDragons(dragons);
    }

    private static void printDragons(Map<String, Map<String, Stats>> typesAndDragons) {
        typesAndDragons.forEach((type, dragons) -> {
            double averageDamage = dragons.values().stream().mapToDouble(Stats::getDamage).average().orElse(0);
            double averageHealth = dragons.values().stream().mapToDouble(Stats::getHealth).average().orElse(0);
            double averageArmor = dragons.values().stream().mapToDouble(Stats::getArmor).average().orElse(0);

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, averageDamage, averageHealth, averageArmor));
            dragons.forEach((dragon, stats) -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        dragon, stats.getDamage(), stats.getHealth(), stats.getArmor()));
            });
        });
    }

    private static void addDragon(Map<String, Map<String, Stats>> dragons, String line) {
        String[] lineInfo = line.split("\\s+");
        String type = lineInfo[0];
        String dragonName = lineInfo[1];
        Integer damage = lineInfo[2].equals("null") ? null : Integer.parseInt(lineInfo[2]);
        Integer health = lineInfo[3].equals("null") ? null : Integer.parseInt(lineInfo[3]);
        Integer armor = lineInfo[4].equals("null") ? null : Integer.parseInt(lineInfo[4]);

        if (!dragons.containsKey(type)) {
            dragons.put(type, new TreeMap<>());
            dragons.get(type).put(dragonName, new Stats(damage, health, armor));
        } else {
            dragons.get(type).put(dragonName, new Stats(damage, health, armor));
        }
    }
}
