import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

public class Internship {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int problemsCount = Integer.parseInt(input.readLine());
        int participantsCount = Integer.parseInt(input.readLine());
        Queue<String> participants = new LinkedList<>();
        ArrayDeque<String> problems = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            problems.push(input.readLine());
        }

        for (int i = 0; i < participantsCount; i++) {
            String participantName = input.readLine();
            if (isNameValid(participantName)) {
                participants.offer(participantName);
            }
        }

        while (participants.size() > 1 && !problems.isEmpty()) {
            String currentParticipant = participants.poll();
            String currentProblem = problems.pop();
            if (isProblemSolved(currentProblem, currentParticipant)) {
                System.out.println(String.format("%s solved %s.", currentParticipant, currentProblem));
                participants.offer(currentParticipant);
            } else {
                System.out.println(String.format("%s failed %s.", currentParticipant, currentProblem));
                problems.offerLast(currentProblem);
            }
        }

        if (participants.size() == 1) {
            System.out.println(String.format("%s gets the job!", participants.peek()));
        } else {
            System.out.println(String.join(", ", participants));
        }
    }

    private static boolean isProblemSolved(String problemName, String participantName) {
        long problemSum = 0;
        long participantSum = 0;
        for (int i = 0; i < problemName.length(); i++) {
            problemSum += problemName.charAt(i);
        }

        for (int i = 0; i < participantName.length(); i++) {
            participantSum += participantName.charAt(i);
        }

        return participantSum >= problemSum;
    }

    private static boolean isNameValid(String participantName) {
        String regex = "^[A-Z][a-z]+? [A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(participantName).matches();
    }
}
