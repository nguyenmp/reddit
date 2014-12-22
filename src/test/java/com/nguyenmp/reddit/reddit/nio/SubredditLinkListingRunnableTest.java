package com.nguyenmp.reddit.reddit.nio;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubredditLinkListingRunnableTest {

    @Test
    public void testGetEndpointNulls() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), ".json");
    }

    @Test
    public void testGetEndpointSubreddit() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().forSubreddit("wtf").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), "r/wtf/.json");
    }

    @Test
    public void testGetEndpointAfter() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().after("t3_12355").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), ".json?after=t3_12355");
    }

    @Test
    public void testGetEndpointAfterSubreddit() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().forSubreddit("aweee").after("t3_12955").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), "r/aweee/.json?after=t3_12955");
    }
}