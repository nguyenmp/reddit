package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.data.Link;
import com.nguyenmp.reddit.data.LinkData;
import com.nguyenmp.reddit.data.SubredditLinkListing;
import org.junit.Assert;
import org.junit.Test;

public class SubredditLinkListingRunnableTest {

    @Test
    public void testGetEndpointNulls() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), ".json");
        SubredditLinkListing result = subredditFetcher.call();
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetEndpointSubreddit() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().forSubreddit("wtf").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), "r/wtf/.json");
        SubredditLinkListing result = subredditFetcher.call();
        Assert.assertNotNull(result);
        Link[] children = result.getData().getChildren();
        Assert.assertTrue(children.length > 0);
        for (Link link : children) {
            LinkData data = link.getData();
            Assert.assertEquals("WTF", data.getSubreddit());
        }
    }

    @Test
    public void testGetEndpointAfter() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().after("t3_12355").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), ".json?after=t3_12355");
        SubredditLinkListing result = subredditFetcher.call();
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetEndpointAfterSubreddit() throws Exception {
        SubredditLinkListingRunnable subredditFetcher = new SubredditLinkListingRunnable.Builder().forSubreddit("aww").after("t3_12955").build();
        Assert.assertEquals(subredditFetcher.getEndpoint(), "r/aww/.json?after=t3_12955");
        SubredditLinkListing result = subredditFetcher.call();
        Assert.assertNotNull(result);
        Link[] children = result.getData().getChildren();
        Assert.assertEquals(0, children.length);
    }
}