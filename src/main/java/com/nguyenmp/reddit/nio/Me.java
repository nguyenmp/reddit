package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.Session;
import com.nguyenmp.reddit.data.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.Reader;

public class Me extends Get<User> {

    /**
     * This API only supports authenticated calls.
     * @param loginData the authentication to perform this call with
     */
    public Me(Session loginData) {
        super(loginData);
    }

    @Override
    public String getEndpoint() {
        return "api/me/.json";
    }

    @Override
    public User parseResult(Reader reader) throws Exception {
        return new ObjectMapper().readValue(reader, User.class);
    }
}
