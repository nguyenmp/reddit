package com.nguyenmp.reddit.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    public boolean isHas_mail() {
        return has_mail;
    }

    public void setHas_mail(boolean has_mail) {
        this.has_mail = has_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_friend() {
        return is_friend;
    }

    public void setIs_friend(boolean is_friend) {
        this.is_friend = is_friend;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isHide_from_robots() {
        return hide_from_robots;
    }

    public void setHide_from_robots(boolean hide_from_robots) {
        this.hide_from_robots = hide_from_robots;
    }

    public Integer getGold_creddits() {
        return gold_creddits;
    }

    public void setGold_creddits(Integer gold_creddits) {
        this.gold_creddits = gold_creddits;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public long getCreated_utc() {
        return created_utc;
    }

    public void setCreated_utc(long created_utc) {
        this.created_utc = created_utc;
    }

    public int getLink_karma() {
        return link_karma;
    }

    public void setLink_karma(int link_karma) {
        this.link_karma = link_karma;
    }

    public int getComment_karma() {
        return comment_karma;
    }

    public void setComment_karma(int comment_karma) {
        this.comment_karma = comment_karma;
    }

    public boolean isOver_18() {
        return over_18;
    }

    public void setOver_18(boolean over_18) {
        this.over_18 = over_18;
    }

    public boolean isIs_gold() {
        return is_gold;
    }

    public void setIs_gold(boolean is_gold) {
        this.is_gold = is_gold;
    }

    public boolean isIs_mod() {
        return is_mod;
    }

    public void setIs_mod(boolean is_mod) {
        this.is_mod = is_mod;
    }

    public Long getGold_expiration() {
        return gold_expiration;
    }

    public void setGold_expiration(Long gold_expiration) {
        this.gold_expiration = gold_expiration;
    }

    public boolean isHas_verified_email() {
        return has_verified_email;
    }

    public void setHas_verified_email(boolean has_verified_email) {
        this.has_verified_email = has_verified_email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getHas_mod_mail() {
        return has_mod_mail;
    }

    public void setHas_mod_mail(Boolean has_mod_mail) {
        this.has_mod_mail = has_mod_mail;
    }

    private boolean has_mail; // null if not from me.json
    private String name;
    private boolean is_friend;
    private long created;
    private boolean hide_from_robots;
    private Integer gold_creddits; // null if not from me.json
    private String modhash; // null if not from me.json
    private long created_utc;
    private int link_karma;
    private int comment_karma;
    private boolean over_18;
    private boolean is_gold;
    private boolean is_mod;
    private Long gold_expiration; // null if ont from me.json
    private boolean has_verified_email;
    private String id;
    private Boolean has_mod_mail; // null if not from me.json
}
