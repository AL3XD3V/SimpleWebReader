package ru.lexeder;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        Connector connector = new Connector(Settings.getSettings(), new URL("http://it-park.ggtu.ru/"));
        WebReader webReader = new WebReader(connector.getConnection());
        BufferedReader reader = webReader.getReader();

        String requestLine;
        while ((requestLine = reader.readLine()) != null) {
            System.out.println(requestLine);
        }

    }

}