package linear_data_structures_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine());
        String text = "";
        Stack<String> lastCommand = new Stack<>();
        for (int i = 0; i < count; i++) {
            String[] lineInfo = input.readLine().split("\\s+");
            String command = lineInfo[0];
            switch (command) {
                case "1":
                    lastCommand.push(text);
                    text += lineInfo[1];
                    break;
                case "2":
                    lastCommand.push(text);
                    for (int j = 0; j < Integer.parseInt(lineInfo[1]); j++) {
                        text = text.substring(0 , text.length() - 1);
                    }
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(lineInfo[1]) - 1));
                    break;
                case "4":
                    text = lastCommand.pop();
                    break;
            }
        }
    }
}
