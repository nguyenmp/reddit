package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.Config;
import com.nguyenmp.reddit.Session;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;

public abstract class Connection<ResultType> implements Callable<ResultType> {
    private static final String BASE_URL = "https://www.reddit.com/";

    public final Session loginData;

    public Connection() {
        this(null);
    }

    public Connection(Session loginData) {
        this.loginData = loginData;
    }

    public ResultType call() throws Exception {
        String endpoint = getEndpoint();
        String target = endpoint == null ? getBaseURL() : getBaseURL().concat(endpoint);

        URL url = new URL(target);
        RateLimiter.enqueue();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("User-Agent", Config.USER_AGENT);
        if (loginData != null) loginData.authenticate(urlConnection);
        initializeConnection(urlConnection);

        InputStream inputStream = urlConnection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);
        ResultType result = parseResult(reader);

        urlConnection.disconnect();
        reader.close();

        return result;
    }

    public static String getBaseURL() {
        return BASE_URL;
    }

    public abstract String getEndpoint();

    public abstract void initializeConnection(HttpURLConnection connection) throws Exception;

    public abstract ResultType parseResult(Reader reader) throws Exception;

    public String asString(Reader reader) {
        Scanner scanner = new Scanner(reader);
        scanner.useDelimiter("\\A");
        return scanner.next();
    }
}
