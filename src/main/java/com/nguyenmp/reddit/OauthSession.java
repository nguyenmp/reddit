package com.nguyenmp.reddit;

import java.net.HttpURLConnection;


public class OauthSession implements Session {
    @Override
    public HttpURLConnection authenticate(HttpURLConnection connection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Method has not been implemented yet");
    }
}
