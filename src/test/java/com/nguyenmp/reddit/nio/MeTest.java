package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.Config;
import com.nguyenmp.reddit.MockSession;
import com.nguyenmp.reddit.Reddit;
import com.nguyenmp.reddit.Session;
import com.nguyenmp.reddit.data.User;
import com.nguyenmp.reddit.data.UserData;
import org.junit.Test;

import java.io.StringReader;

import static junit.framework.Assert.*;

public class MeTest {

    @Test
    public void testGetEndpoint() throws Exception {
        String endpoint = new Me(new MockSession()).getEndpoint();
        assertEquals(endpoint, new Me(new MockSession()).getEndpoint());
        assertEquals("api/me/.json", endpoint);
    }

    @Test
    public void testParseResult() throws Exception {
        String json = "{\"kind\": \"t2\", \"data\": {\"has_mail\": false, \"name\": \"markerz\", \"is_friend\": false, \"created\": 1315273598.0, \"hide_from_robots\": true, \"gold_creddits\": 0, \"modhash\": \"wmzauwt9vz280033ccdfff8ac6d97705a2e75i21oiu1e03952\", \"created_utc\": 1315269998.0, \"link_karma\": 51, \"comment_karma\": 4482, \"over_18\": true, \"is_gold\": false, \"is_mod\": true, \"gold_expiration\": null, \"has_verified_email\": true, \"id\": \"5sryc\", \"has_mod_mail\": false}}";
        User user = new Me(new MockSession()).parseResult(new StringReader(json));
        assertEquals("t2", user.getKind());

        UserData data = user.getData();
        assertFalse(data.isHas_mail());
        assertEquals("markerz", data.getName());
        assertFalse(data.isIs_friend());
        assertEquals(1315273598L, data.getCreated());
        assertTrue(data.isHide_from_robots());
        assertEquals(data.getGold_creddits(), (Integer) 0);
        assertEquals("wmzauwt9vz280033ccdfff8ac6d97705a2e75i21oiu1e03952", data.getModhash());
        assertEquals(1315269998L, data.getCreated_utc());
        assertEquals(51, data.getLink_karma());
        assertEquals(4482, data.getComment_karma());
        assertTrue(data.isOver_18());
        assertFalse(data.isIs_gold());
        assertTrue(data.isIs_mod());
        assertNull(data.getGold_expiration());
        assertTrue(data.isHas_verified_email());
        assertEquals("5sryc", data.getId());
        assertFalse(data.getHas_mod_mail());
    }

    @Test
    public void testCall() throws Exception {
        Session session = Reddit.login(Config.USERNAME, Config.PASSWORD);
        User me = new Me(session).call();
        assertEquals("t2", me.getKind());
        assertEquals(Config.USERNAME, me.getData().getName());
    }
}