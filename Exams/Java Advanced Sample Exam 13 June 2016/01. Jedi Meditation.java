`import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JediMeditation {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> jedies = new ArrayList<>(6);
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < 5; i++) {
            jedies.add(new ArrayList<>());
        }

        //0 - toshko slav
        //1 - m - masters
        //2 - k - knights
        //3 - toshko slav
        //4 - p - parawan
        //

        boolean yoda = false;
        for (int i = 0; i < n; i++) {
            String[] currentJedies = input.readLine().split(" ");
            for (String currentJedy : currentJedies) {
                char type = currentJedy.charAt(0);
                switch (type) {
                    case 'm':
                        jedies.get(1).add(currentJedy);
                        break;
                    case 'k':
                        jedies.get(2).add(currentJedy);
                        break;
                    case 't':
                    case 's':
                        jedies.get(0).add(currentJedy);
                        break;
                    case 'p':
                        jedies.get(4).add(currentJedy);
                        break;
                    case 'y':
                        yoda = true;
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (yoda) {
            List<String> swap = jedies.get(0);
            jedies.set(0, jedies.get(3));
            jedies.set(3, swap);
        }

        for (List<String> jedy : jedies) {
            for (String s : jedy) {
                sb.append(s).append(" ");
            }
        }


        System.out.println(sb);
    }

    private static void changeQueues(List<String> q1, List<String> q2) {
        q2.addAll(q1);
        q1.clear();
    }
}
