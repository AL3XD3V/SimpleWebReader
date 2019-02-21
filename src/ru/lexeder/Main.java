package ru.lexeder;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Settings settings = new Settings();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter url to parse:");
            String url = scanner.nextLine();
            System.out.println("Response from " + url + " :");
            Connector connector = new Connector(settings.getSettings(), new URL(url));
            WebReader webReader = new WebReader(connector.getConnection());
            BufferedReader reader = webReader.getReader();
            String requestLine;
            int count = 0;
            while ((requestLine = reader.readLine()) != null) {
                System.out.println("LINE (L: " + requestLine.length() + "):\t" + requestLine);
                count++;
            }
            System.out.println("Number of lines in response: " + count);
            connector.closeConnection();
        }
    }

}