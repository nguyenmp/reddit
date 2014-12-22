package com.nguyenmp.reddit.reddit;

import com.nguyenmp.reddit.reddit.data.LoginData;
import org.junit.Assert;
import org.junit.Test;

public class RedditTest {

    @Test
    public void test() throws Exception {
        LoginData credentials = Reddit.login(Config.USERNAME, Config.PASSWORD);
        Assert.assertNotNull(credentials.cookie);
        Assert.assertNotNull(credentials.modhash);
    }
}