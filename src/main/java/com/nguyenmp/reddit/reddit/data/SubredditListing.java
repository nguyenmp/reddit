package com.nguyenmp.reddit.reddit.data;

import com.nguyenmp.reddit.reddit.nio.SubredditListingRunnable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class SubredditListing extends Listing<Subreddit> {
    public static SubredditListing get() throws Exception {
        return new SubredditListingRunnable().call();
    }

    public static SubredditListing get(int count) throws Exception {
        return new SubredditListingRunnable(count).call();
    }
}
