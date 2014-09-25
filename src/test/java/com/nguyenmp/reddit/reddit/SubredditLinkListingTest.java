package com.nguyenmp.reddit.reddit;

import com.nguyenmp.reddit.reddit.Reddit;
import com.nguyenmp.reddit.reddit.data.Link;
import com.nguyenmp.reddit.reddit.data.ListingData;
import com.nguyenmp.reddit.reddit.data.LoginData;
import com.nguyenmp.reddit.reddit.data.SubredditLinkListing;

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
        LoginData login = Reddit.login("584669", "584669");
        SubredditLinkListing listing = SubredditLinkListing.get(login);
        assertNotNull(listing);
        assertEquals(listing.getKind(), "Listing");

        ListingData<Link> listingData = listing.getData();
        assertNotNull(listingData);
        assertNull(listingData.getBefore());
        assertNotNull(listingData.getModhash());
        assertEquals(listingData.getModhash(), "");
    }

    @Test
    public void test3() throws Exception {

    }
}