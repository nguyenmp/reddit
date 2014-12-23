package com.nguyenmp.reddit;

import java.io.Serializable;
import java.net.HttpURLConnection;

/**
 * Represents some form of authentication method of a user's session.
 */
public interface Session extends Serializable {

    /**
     * Configures the connection to use this Session's authentication method (headers?)
     * @param connection the connection to configure for authentication
     * @return the connection for chaining
     */
    public HttpURLConnection authenticate(HttpURLConnection connection);
}