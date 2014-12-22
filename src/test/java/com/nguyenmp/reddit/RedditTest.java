package com.nguyenmp.reddit;

import com.nguyenmp.reddit.Config;
import com.nguyenmp.reddit.Reddit;
import com.nguyenmp.reddit.data.LoginData;
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