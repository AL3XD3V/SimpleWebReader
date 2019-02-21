package ru.lexeder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Settings {

    private static Map<String, String> settings = new HashMap<>();

    public Settings() throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\settings.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            settings.put(parseKey(line), parseValue(line));
        }
    }

    public static Map<String, String> getSettings() {
        return settings;
    }

    private static String parseKey(String inputString) {
        return inputString.substring(0, inputString.indexOf('='));
    }

    private static String parseValue(String inputString) {
        return inputString.substring(inputString.indexOf('=') + 1);
    }

}