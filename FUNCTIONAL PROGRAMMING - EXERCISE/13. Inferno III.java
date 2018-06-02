package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InfernoThree {

    private static class Previous {
        private List<Point> numbers;
        private String condition;

        public Previous() {
            this.numbers = new ArrayList<>();
        }

        public Previous(String condition) {
            this.condition = condition;
        }

        public Previous(String condition, List<Point> numbers) {
            this.numbers = numbers;
            this.condition = condition;
        }

        public List<Point> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Point> numbers) {
            this.numbers = numbers;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }
    }

    private static class Point {
        private Integer x;
        private boolean valid;

        public Point() {
            this.valid = true;
        }

        public Point(Integer x) {
            this.x = x;
            this.valid = true;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Point> numbers = Arrays.stream(input.readLine().split("\\s+"))
                .map(x -> new Point(Integer.parseInt(x)))
                .collect(Collectors.toList());


        Stack<Previous> previous = new Stack<>();
        String line;

        while (!"Forge".equals(line = input.readLine())) {
            String[] lineInfo = line.split(";");
            String excludeReverse = lineInfo[0];
            String command = lineInfo[1];
            int sum = Integer.parseInt(lineInfo[2]);

            if (excludeReverse.equals("Exclude")) {
                switch (command) {
                    case "Sum Left":
                        List<Point> currList = new ArrayList<>();
                        for (Point number : numbers) {
                            currList.add(new Point(number.getX()));
                        }
                        previous.push(new Previous(command + ";" + sum, currList));
                        excludeSumLeft(sum, numbers);
                        break;
                    case "Sum Right":
                        currList = new ArrayList<>();
                        for (Point number : numbers) {
                            currList.add(new Point(number.getX()));
                        }
                        previous.push(new Previous(command + ";" + sum, currList));
                        excludeSumRight(sum, numbers);
                        break;
                    case "Sum Left Right":
                        currList = new ArrayList<>();
                        for (Point number : numbers) {
                            currList.add(new Point(number.getX()));
                        }
                        previous.push(new Previous(command + ";" + sum, currList));
                        excludeSumLeftRight(sum, numbers);
                        break;
                }
            } else if (excludeReverse.equals("Reverse")) {
                while (true) {
                    String currentCommand = (command + ";" + sum);
                    if (!currentCommand.equals(previous.peek().getCondition())) {
                        previous.pop();
                    } else {
                        numbers = previous.pop().getNumbers();
                        break;
                    }
                }
            }
        }

        for (Point number : numbers) {
            if (number.valid) {
                System.out.printf("%d ", number.getX());
            }
        }

        System.out.println();
    }

    private static void excludeSumLeftRight(int sum, List<Point> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() == 1) {
                if (numbers.get(0).getX().equals(sum)) {
                    numbers.get(0).setValid(false);
                }
            } else {
                if (i == 0) {
                    if (numbers.get(i).getX() + numbers.get(i + 1).getX() == sum) {
                        numbers.get(i).setValid(false);
                    }
                } else if (i == numbers.size() - 1) {
                    if (numbers.get(i - 1).getX() + numbers.get(i).getX() == sum) {
                        numbers.get(i).setValid(false);
                    }
                } else {
                    if (numbers.get(i - 1).getX() + numbers.get(i).getX() + numbers.get(i + 1).getX() == sum) {
                        numbers.get(i).setValid(false);
                    }
                }
            }
        }
    }

    private static void excludeSumLeft(int sum, List<Point> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                if (numbers.get(i).getX().equals(sum)) {
                    numbers.get(i).setValid(false);
                }
            } else {
                if (numbers.get(i).getX() + numbers.get(i - 1).getX() == sum) {
                    numbers.get(i).setValid(false);
                }
            }
        }
    }

    private static void excludeSumRight(int sum, List<Point> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                if (numbers.get(i).getX().equals(sum)) {
                    numbers.remove(i);
                }
            } else {
                if (numbers.get(i).getX() + numbers.get(i + 1).getX() == sum) {
                    numbers.remove(i);
                }
            }
        }
    }

}
