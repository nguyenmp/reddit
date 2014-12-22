package com.nguyenmp.reddit.reddit;

import com.nguyenmp.reddit.reddit.data.ListingData;
import com.nguyenmp.reddit.reddit.data.Subreddit;
import com.nguyenmp.reddit.reddit.data.SubredditListing;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubredditListingTest {

    @Test
    public void test() throws Exception {
        SubredditListing listing = SubredditListing.get();
        assertNotNull(listing);
        assertEquals(listing.getKind(), "Listing");

        ListingData<Subreddit> listingData = listing.getData();
        assertNotNull(listingData);
        assertNull(listingData.getBefore());
        assertNotNull(listingData.getAfter());
        assertNotNull(listingData.getModhash());
        assertEquals(listingData.getModhash(), "");
    }
}