package com.nguyenmp.reddit;

import com.nguyenmp.reddit.data.LoginData;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * An authentication method backed by a cookie
 * retrieved by the traditional reddit auth method
 */
public class CookieSession implements Session {
    private final LoginData login;

    public CookieSession(LoginData login) {
        this.login = login;
    }

    @Override
    public HttpURLConnection authenticate(HttpURLConnection connection) {
        if (connection != null && login != null) {
            connection.setRequestProperty("Cookie", "reddit_session=" + URLEncoder.encode(login.cookie));
        }
        return connection;
    }
}