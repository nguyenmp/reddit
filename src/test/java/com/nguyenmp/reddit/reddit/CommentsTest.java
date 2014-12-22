package com.nguyenmp.reddit.reddit;

import com.nguyenmp.reddit.reddit.data.Comments;
import com.nguyenmp.reddit.reddit.data.Link;
import com.nguyenmp.reddit.reddit.data.Listing;
import com.nguyenmp.reddit.reddit.data.ListingData;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentsTest {

    @Test
    public void testGet() throws Exception {
        Comments comments = Comments.get("2c449y");
        integrityCheck(comments);
    }

    @Test
    public void testGet2() throws Exception {
        Comments comments = Comments.get("2c8ed1");
        integrityCheck(comments);
    }

    public static void integrityCheck(Comments comments) {
        assertNotNull(comments);
        Listing<Link> parents = comments.getParent();
        assertNotNull(parents);
        ListingData<Link> parentsData = parents.getData();
        assertNotNull(parentsData);
        assertNotNull(parentsData.getModhash());
        assertEquals("Modhash should not be provided in this listing", parentsData.getModhash(), "");
        assertNull(parentsData.getBefore());
        assertNull(parentsData.getAfter());
        Link[] parentsChildren = parentsData.getChildren();
        assertNotNull(parentsChildren);
        assertEquals(parentsChildren.length, 1);
    }
}