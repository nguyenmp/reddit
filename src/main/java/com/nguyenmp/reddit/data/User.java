package com.nguyenmp.reddit.data;

public class User extends Thing {
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}