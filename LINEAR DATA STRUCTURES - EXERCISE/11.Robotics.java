package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Robotics {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> robots = new LinkedHashMap<>();
        String robotsLine = input.readLine();
        Map<String, Integer> freeRobots = new LinkedHashMap<>();
        addRobots(robotsLine, robots, freeRobots);
        String startTime = input.readLine();
        ArrayDeque<String> details = new ArrayDeque<>();
        String detail;

        while (! "End".equals(detail = input.readLine())) {
            details.offer(detail);
        }
        StringBuilder sb = new StringBuilder();
        while (details.size() > 0) {
            String currentDetail = details.poll();
            String freeRobotName = getFreeRobot(freeRobots);
            startTime = updateTime(startTime);
            if (freeRobotName == null) {
                minusOneSec(freeRobots);
                details.offer(currentDetail);
                continue;
            }
            sendRobotToWork(robots, freeRobots, freeRobotName);
            sb.append(String.format("%s - %s [%s]%n", freeRobotName, currentDetail, printTime(startTime)));
            minusOneSec(freeRobots);
        }
        System.out.println(sb);
    }

    private static void minusOneSec(Map<String, Integer> freeRobots) {
        freeRobots.forEach((x, a) -> {
             if (a > 0) {
                 freeRobots.put(x, a - 1);
             }
        });
    }

    private static void sendRobotToWork(Map<String, Integer> robots, Map<String, Integer> freeRobots, String robotName) {
        Integer robotCooldown = robots.get(robotName);
        freeRobots.put(robotName, robotCooldown);
    }

    private static String getFreeRobot(Map<String, Integer> freeRobots) {
        for (Map.Entry<String, Integer> robot : freeRobots.entrySet()) {
            if (robot.getValue() == 0) {
                return robot.getKey();
            }
        }

        return null;
    }

    private static String printTime(String time) {
        String[] currentInfoTimeStr = time.split(":");
        int[] currentInfoTime = new int[currentInfoTimeStr.length];
        for (int i = 0; i < currentInfoTimeStr.length; i++) {
            currentInfoTime[i] = Integer.parseInt(currentInfoTimeStr[i]);
        }
        String hours = String.valueOf(currentInfoTime[0]);
        String minutes = String.valueOf(currentInfoTime[1]);
        if (hours.length() == 1) {
            hours = "0" + hours;
        }
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }

        String seconds = String.valueOf(currentInfoTime[2]);
        if (seconds.length() == 1) {
            seconds = "0" + seconds;
        }

        return (String.format("%s:%s:%s", hours, minutes, seconds));
    }

    private static String updateTime(String currentTime) {
        String[] currentInfoTimeStr = currentTime.split(":");
        int[] currentInfoTime = new int[currentInfoTimeStr.length];
        for (int i = 0; i < currentInfoTimeStr.length; i++) {
            currentInfoTime[i] = Integer.parseInt(currentInfoTimeStr[i]);
        }        currentInfoTime[2] += 1;
        if (currentInfoTime[2] == 60) {
            currentInfoTime[2] = 0;
            currentInfoTime[1] += 1;
        }

        if (currentInfoTime[1] == 60) {
            currentInfoTime[1] = 0;
            currentInfoTime[0] += 1;
        }

        if (currentInfoTime[0] == 24) {
            currentInfoTime[0] = 0;
        }

        return String.valueOf(currentInfoTime[0]) + ":" + currentInfoTime[1] + ":" + currentInfoTime[2];
    }

    private static void addRobots(String robotsLine, Map<String, Integer> robots, Map<String, Integer> freeRobots) {
        String[] robotsInfo = robotsLine.split(";");
        for (String robotInfo : robotsInfo) {
            String[] currentRobotInfo = robotInfo.split("\\-");
            String robotName = currentRobotInfo[0];
            int robotTime = Integer.parseInt(currentRobotInfo[1]);
            robots.put(robotName, robotTime);
            freeRobots.put(robotName, 0);
        }
    }
}
