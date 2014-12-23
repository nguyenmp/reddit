package com.nguyenmp.reddit;

import java.net.HttpURLConnection;

public class MockSession implements Session {
    private int calls = 0;

    @Override
    public HttpURLConnection authenticate(HttpURLConnection connection) {
        calls += 1;
        return connection;
    }

    public int getCalls() {
        return calls;
    }
}
