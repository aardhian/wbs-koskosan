package com.wbs.kos.model.dto;

public class LoggedInUser {
    private String userId;
    private String displayName;

    public LoggedInUser(){}
    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
