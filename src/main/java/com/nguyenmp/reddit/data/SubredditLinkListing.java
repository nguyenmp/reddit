package com.nguyenmp.reddit.data;

import com.nguyenmp.reddit.Session;
import com.nguyenmp.reddit.nio.SubredditLinkListingRunnable;

public class SubredditLinkListing extends Listing<Link> {

    public static SubredditLinkListing get() throws Exception {
        return get(null, null);
    }

    public static SubredditLinkListing get(Session login) throws Exception {
        return get(null, login);
    }

    public static SubredditLinkListing get(String subreddit) throws Exception {
        return get(subreddit, null);
    }

    public static SubredditLinkListing get(String subreddit, Session login) throws Exception {
        return new SubredditLinkListingRunnable.Builder()
                .forSubreddit(subreddit)
                .withUser(login)
                .build()
                .call();
    }
}
