package com.wbs.kos.model.jwt;

import com.wbs.kos.model.dto.LoggedInUser;

import java.io.Serializable;

public class JwtResponseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private LoggedInUser loggedInUser;
    private final String token;
    public JwtResponseModel(String token, LoggedInUser loggedInUser) {
        this.token = token;
        this.loggedInUser = loggedInUser;
    }
    public String getToken() {
        return token;
    }
    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }
}
