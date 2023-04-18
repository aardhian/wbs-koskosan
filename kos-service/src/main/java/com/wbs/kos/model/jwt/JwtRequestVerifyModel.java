package com.wbs.kos.model.jwt;

public class JwtRequestVerifyModel {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String token;
    public JwtRequestVerifyModel() {
    }
    public JwtRequestVerifyModel(String username, String password) {
        super();
        this.username = username; this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() { return password; }
    public void setToken(String token) {this.token = token;}
}
