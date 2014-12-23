package com.nguyenmp.reddit;

import com.nguyenmp.reddit.data.LoginData;
import com.nguyenmp.reddit.data.Subreddit;
import com.nguyenmp.reddit.data.SubredditListing;
import com.nguyenmp.reddit.nio.SubredditListingRunnable;
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