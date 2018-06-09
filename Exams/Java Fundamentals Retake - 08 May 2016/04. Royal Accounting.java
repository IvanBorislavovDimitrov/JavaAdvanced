import java.awt.event.PaintEvent;
import java.beans.PersistenceDelegate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class RoyalAccounting {

    private static class Employee {
        private String name;
        private int workHoursPerDay;
        private double dailyPayment;

        public Employee() {
        }

        public Employee(String name, int workHoursPerDay, double dailyPayment) {
            this.name = name;
            this.workHoursPerDay = workHoursPerDay;
            this.dailyPayment = dailyPayment;
        }

        public double getDailyIncome() {
            return (this.getDailyPayment() * this.getWorkHoursPerDay()) / 24;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getEmployeeMonthlyPayment() {
            return (((this.getDailyPayment() * this.getWorkHoursPerDay()) / 24) * 30);
        }

        public int getWorkHoursPerDay() {
            return workHoursPerDay;
        }

        public void setWorkHoursPerDay(int workHoursPerDay) {
            this.workHoursPerDay = workHoursPerDay;
        }

        public double getDailyPayment() {
            return dailyPayment;
        }

        public void setDailyPayment(double dailyPayment) {
            this.dailyPayment = dailyPayment;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> teams = new HashMap<>();
        String regex = "^[a-zA-Z]+;-?\\d+;-?\\d+(\\.\\d+)?;[A-Za-z]+$";
        Pattern pattern = Pattern.compile(regex);
        String line;
        while (!"Pishi kuf i da si hodim".equals(line = input.readLine())) {
            if (!pattern.matcher(line).matches()) {
                continue;
            }
            String[] lineInfo = line.split(";");
            String employeeName = lineInfo[0];
            int employeeWorkHours = Integer.parseInt(lineInfo[1]);
            double employeeDailyPayment = Double.parseDouble(lineInfo[2]);
            String teamName = lineInfo[3];
            addEmployee(teams, employeeName, employeeWorkHours, employeeDailyPayment, teamName);
        }
        printTeams(teams);
    }

    private static void printTeams(Map<String, List<Employee>> teams) {
        teams.entrySet().stream()
                .sorted(Comparator.comparing(x -> x.getValue().stream().mapToDouble(Employee::getEmployeeMonthlyPayment).sum(),
                        Comparator.reverseOrder()))
                .filter(x -> x.getValue().size() > 0)
                .forEach(t -> {
                    System.out.println(String.format("Team - %s", t.getKey()));
                    t.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getWorkHoursPerDay, Comparator.reverseOrder())
                                    .thenComparing(Employee::getDailyIncome, Comparator.reverseOrder())
                                    .thenComparing(Employee::getName))
                            .forEach(e -> System.out.println(String.format("$$$%s - %d - %.6f",
                                    e.getName(), e.getWorkHoursPerDay(), e.getDailyIncome())));
                });
    }

    private static void addEmployee(Map<String, List<Employee>> teams, String employeeName, int employeeWorkHours,
                                    double employeeDailyPayment, String teamName) {
        teams.putIfAbsent(teamName, new ArrayList<>());
        if (teams.entrySet().stream().noneMatch(x -> x.getValue().stream().anyMatch(l -> l.getName().equals(employeeName)))) {
            teams.get(teamName).add(new Employee(employeeName, employeeWorkHours, employeeDailyPayment));
        }
    }
}
