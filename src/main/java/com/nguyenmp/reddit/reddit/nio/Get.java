package com.nguyenmp.reddit.reddit.nio;


import com.nguyenmp.reddit.reddit.Config;
import com.nguyenmp.reddit.reddit.data.LoginData;

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
        connection.setRequestProperty("User-Agent", Config.USER_AGENT);
    }
}
