package com.nguyenmp.reddit.nio;


import com.nguyenmp.reddit.data.LoginData;

import java.net.HttpURLConnection;

public abstract class Get<ResultType> extends Connection<ResultType> {
    public Get() {
        super();
    }

    protected Get(LoginData loginData) {
        super(loginData);
    }

    @Override
    public void initializeConnection(HttpURLConnection connection) {
        // No initialization necessary here
        // User-agent and cookies are set in Connection
    }
}
