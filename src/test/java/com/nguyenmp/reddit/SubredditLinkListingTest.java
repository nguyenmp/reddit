package com.nguyenmp.reddit;

import com.nguyenmp.reddit.data.Link;
import com.nguyenmp.reddit.data.ListingData;
import com.nguyenmp.reddit.data.SubredditLinkListing;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubredditLinkListingTest {

    @Test
    public void test() throws Exception {
        SubredditLinkListing listing = SubredditLinkListing.get();
        assertNotNull(listing);
        assertEquals(listing.getKind(), "Listing");

        ListingData<Link> listingData = listing.getData();
        assertNotNull(listingData);
        assertNull(listingData.getBefore());
        assertNotNull(listingData.getModhash());
        assertEquals(listingData.getModhash(), "");
    }

    @Test
    public void test2() throws Exception {
        Session session = Reddit.login("584669", "584669");
        SubredditLinkListing listing = SubredditLinkListing.get(session);
        assertNotNull(listing);
        assertEquals(listing.getKind(), "Listing");

        ListingData<Link> listingData = listing.getData();
        assertNotNull(listingData);
        assertNull(listingData.getBefore());
        assertNotNull(listingData.getModhash());
        assertNotEquals(0, listingData.getModhash().length());
    }

    @Test
    public void test3() throws Exception {

    }
}