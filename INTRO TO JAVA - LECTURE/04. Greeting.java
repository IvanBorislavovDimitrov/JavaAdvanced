package introduction_to_java_lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greeting {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String firstName = input.readLine();
        String lastName = input.readLine();
        System.out.println(String.format("Hello, %s %s!", firstName.isEmpty() ? "*****" : firstName, lastName.isEmpty() ?
        "*****" : lastName));
    }
}
