package com.nguyenmp.reddit;

import com.nguyenmp.reddit.data.LoginData;
import com.nguyenmp.reddit.data.LoginResult;
import com.nguyenmp.reddit.nio.LoginRunnable;

/** An interface to access reddit.com */
public class Reddit {
    public static LoginData login(String username, String password) throws Exception {
        LoginResult result = new LoginRunnable(username, password).call();
        if (result.json.errors.length > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (String[] error : result.json.errors) {
                builder.append("[");
                for (String message : error) {
                    builder.append(message); builder.append(",");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append("]");
                builder.append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            throw new Exception("Failed to log in: " + builder.toString());
        }
        else return result.json.data;
    }
}
