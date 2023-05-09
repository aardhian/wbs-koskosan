package com.wbs.kos.model.jwt;

import com.wbs.kos.model.dto.LoggedInUser;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

public class JwtLoginResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private LoggedInUser loggedInUser;
    private final String token;
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String accessToken;
    private String refreshToken;
    private Date birthday;
    public JwtLoginResponseModel(String token, LoggedInUser loggedInUser) {
        this.token = token;
        this.loggedInUser = loggedInUser;
        this.email = loggedInUser.getUserId();
        this.accessToken = token;
        this.refreshToken = token;
    }
    public String getToken() {
        return token;
    }
    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
