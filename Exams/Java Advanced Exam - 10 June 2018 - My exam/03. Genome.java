import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Genome {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> genomes = new LinkedHashMap<>();

        String line;
        while (!"Stop!".equals(line = input.readLine())) {
            addGenome(line, genomes);
        }

        genomes.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                .forEach(x -> System.out.println(String.format("%s has genome size of %d", x.getKey(), x.getValue())));
    }


    private static void addGenome(String genome, Map<String, Integer> genomes) {
        if (!genome.contains("=") || !genome.contains("--") || !genome.contains("<<")) {
            return;
        }

        if (genome.split("\\s+").length != 1) { // TODO may not be valid
            return;
        }

        int indexOfEqual = genome.indexOf("=");
        String nameBeforeEqual = genome.substring(0, indexOfEqual);
        int indexOfTwoDashes = genome.indexOf("--");
        int nameSize = Integer.parseInt(genome.substring(indexOfEqual + 1, indexOfTwoDashes));

        int lengthOfName = 0;
        for (int i = 0; i < nameBeforeEqual.length(); i++) {
            char ch = nameBeforeEqual.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lengthOfName++;
            } else if (ch != '!' && ch != '@' && ch != '#' && ch != '$' && ch != '?') {
                return;
            }
        }

        if (lengthOfName != nameSize) {
            return;
        }

        int indexOfLeftArrows = genome.indexOf("<<");
        int genomeSize = Integer.parseInt(genome.substring(indexOfTwoDashes + 2, indexOfLeftArrows));

        String group = genome.substring(indexOfLeftArrows + 2);

        if (!genomes.containsKey(group)) {
            genomes.put(group, genomeSize);
        } else {
            genomes.put(group, genomes.get(group) + genomeSize);
        }
    }
}
