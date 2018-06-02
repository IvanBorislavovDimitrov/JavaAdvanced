package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUrl {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String url = input.readLine().trim();

        try {
            if (url.split("://").length != 2) {
                throw new Exception();
            }
            String protocol = url.substring(0, url.indexOf("://"));
            url = url.substring(url.indexOf("://") + 3);
            String server = url.substring(0, url.indexOf("/"));
            url = url.substring(url.indexOf("/") + 1);

            System.out.println(String.format("Protocol = %s", protocol));
            System.out.println(String.format("Server = %s", server));
            System.out.println(String.format("Resources = %s", url));
        } catch (Exception e) {
            System.out.println("Invalid URL");
        }
    }
}

