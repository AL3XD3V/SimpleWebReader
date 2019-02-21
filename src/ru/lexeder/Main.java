package ru.lexeder;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Settings settings = null;
        try {
            settings = new Settings();
        } catch (IOException e) {
            System.out.println("Troubles with settings file!");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter url to parse or type \"exit\" to stop process:");
            String url = scanner.nextLine();
            if (url.equals("exit")) {
                break;
            }
            try {
                Connector connector = new Connector(settings.getSettings(), new URL(url));
                WebReader webReader = new WebReader(connector.getConnection());
                BufferedReader reader = webReader.getReader();
                String requestLine;
                int count = 1;
                System.out.println("Response from " + url + " :");
                while ((requestLine = reader.readLine()) != null) {
                    System.out.println("LINE #" + count + " (L: " + requestLine.length() + "):\t" + requestLine);
                    count++;
                }
                connector.closeConnection();
            } catch (IOException e) {
                System.out.println("Not correct url or other error occured!");
            }
        }
    }

}