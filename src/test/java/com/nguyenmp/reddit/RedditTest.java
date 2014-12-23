package com.nguyenmp.reddit;

import org.junit.Test;

public class RedditTest {

    @Test
    public void test() throws Exception {
        Session credentials = Reddit.login(Config.USERNAME, Config.PASSWORD);
        // TODO: Implement some way of checking for the authenticated session
        // Perhaps query the "me" endpoint to verify that the username is the same
    }
}