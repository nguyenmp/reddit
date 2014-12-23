package com.nguyenmp.reddit.nio;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.*;

public class ConnectionTest {

    @Test
    public void testAsString() {
        StringReader reader = new StringReader("");
        String result = Connection.asString(reader);
        assertEquals("", result);
    }

    @Test
    public void testAsString2() {
        StringReader reader = new StringReader("1");
        String result = Connection.asString(reader);
        assertEquals("1", result);
    }

    @Test
    public void testAsString3() {
        StringReader reader = new StringReader("{\"kind\": \"t2\", \"data\": {\"has_mail\": false, \"name\": \"markerz\", \"is_friend\": false, \"created\": 1315273598.0, \"hide_from_robots\": true, \"gold_creddits\": 0, \"modhash\": \"wmzauwt9vz280033ccdfff8ac6d97705a2e75i21oiu1e03952\", \"created_utc\": 1315269998.0, \"link_karma\": 51, \"comment_karma\": 4482, \"over_18\": true, \"is_gold\": false, \"is_mod\": true, \"gold_expiration\": null, \"has_verified_email\": true, \"id\": \"5sryc\", \"has_mod_mail\": false}}");
        String result = Connection.asString(reader);
        assertEquals("{\"kind\": \"t2\", \"data\": {\"has_mail\": false, \"name\": \"markerz\", \"is_friend\": false, \"created\": 1315273598.0, \"hide_from_robots\": true, \"gold_creddits\": 0, \"modhash\": \"wmzauwt9vz280033ccdfff8ac6d97705a2e75i21oiu1e03952\", \"created_utc\": 1315269998.0, \"link_karma\": 51, \"comment_karma\": 4482, \"over_18\": true, \"is_gold\": false, \"is_mod\": true, \"gold_expiration\": null, \"has_verified_email\": true, \"id\": \"5sryc\", \"has_mod_mail\": false}}", result);
    }
}