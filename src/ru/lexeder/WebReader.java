package ru.lexeder;

import java.io.*;
import java.net.HttpURLConnection;

public class WebReader {

    HttpURLConnection connection;

    public WebReader(HttpURLConnection connection) {
        this.connection = connection;
    }

    public BufferedReader getReader() throws IOException {
        InputStream inputStream = connection.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }

}