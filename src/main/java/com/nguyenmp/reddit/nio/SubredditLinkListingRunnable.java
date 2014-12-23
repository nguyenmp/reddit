package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.Session;
import com.nguyenmp.reddit.data.LoginData;
import com.nguyenmp.reddit.data.SubredditLinkListing;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.Reader;

public class SubredditLinkListingRunnable extends Get<SubredditLinkListing> {
    public static class Builder {
        private String subreddit = null; // Defaults to frontpage
        private String after = null; // Defaults to the first page
        private Session loginData = null; // Defaults to logged out

        public Builder() {
            super();
        }

        public Builder forSubreddit(String subreddit) {
            this.subreddit = subreddit;
            return this;
        }

        public Builder withUser(Session loginData) {
            this.loginData = loginData;
            return this;
        }

        public Builder after(String after) {
            this.after = after;
            return this;
        }

        public SubredditLinkListingRunnable build() {
            return new SubredditLinkListingRunnable(subreddit, after, loginData);
        }
    }

    private final String subreddit;
    private final String after;


    private SubredditLinkListingRunnable(String subreddit, String after, Session login) {
        super(login);
        this.after = after;
        this.subreddit = subreddit;
    }

    @Override
    public String getEndpoint() {
        StringBuilder builder = new StringBuilder();
        if (subreddit != null) builder.append("r/").append(subreddit).append("/");
        builder.append(".json");
        if (after != null) builder.append("?after=").append(after);

        return builder.toString();
    }

    @Override
    public SubredditLinkListing parseResult(Reader reader) throws Exception {
        return new ObjectMapper().readValue(reader, SubredditLinkListing.class);
    }
}
