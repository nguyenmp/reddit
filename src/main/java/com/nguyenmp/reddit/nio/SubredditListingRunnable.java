package com.nguyenmp.reddit.nio;

import com.nguyenmp.reddit.data.LoginData;
import com.nguyenmp.reddit.data.SubredditListing;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.Reader;

public class SubredditListingRunnable extends Get<SubredditListing> {

    public static enum Category {
        Mine("mine"), Popular("popular"), New("new");

        private final String internalRep;

        Category(String internalRep) {
            this.internalRep = internalRep;
        }

        @Override
        public String toString() {
            return internalRep;
        }
    }

    public static class Builder {
        private Integer limit = null;
        private LoginData loginData = null;
        private Category category = null;

        public Builder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder byUser(LoginData loginData) {
            this.loginData = loginData;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public SubredditListingRunnable build() {
            return new SubredditListingRunnable(limit, loginData, category);
        }
    }

    private final Integer limit;
    private final Category category;

    public SubredditListingRunnable(Integer limit, LoginData loginData, Category category) {
        super(loginData);
        this.limit = limit;
        this.category = category;
    }

    @Override
    public String getEndpoint() {
        StringBuilder builder = new StringBuilder("subreddits/");
        if (category != null) builder.append(category).append("/");
        builder.append(".json");
        if (limit != null) builder.append("?limit=").append(limit);
        return builder.toString();
    }

    @Override
    public SubredditListing parseResult(Reader reader) throws Exception {
        return new ObjectMapper().readValue(reader, SubredditListing.class);
    }
}
