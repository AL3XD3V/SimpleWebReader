package ru.lexeder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

public class Connector {

    private Map<String, String> settings;
    private URL url;
    private HttpURLConnection urlConnection;

    public Connector(Map<String, String> settings, URL url) {
        this.settings = settings;
        this.url = url;
    }

    public HttpURLConnection getConnection() throws IOException {
        if (settings.containsKey("proxy")) {
            urlConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP,
                                                                    new InetSocketAddress(settings.get("proxy"),
                                                                                            Integer.parseInt(settings.get("port")))));
        } else {
            urlConnection = (HttpURLConnection) url.openConnection();
        }
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        return urlConnection;
    }

    public void closeConnection() {
        urlConnection.disconnect();
    }

}