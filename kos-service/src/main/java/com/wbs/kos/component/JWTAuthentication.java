package com.wbs.kos.component;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Slf4j
public class JWTAuthentication implements Authentication {
    public static final String ROLES_CLAIM_NAME = "roles";

    protected String tokenString;
    protected Claims tokenClaims;
    protected List<GrantedAuthority> authorities;
    protected boolean authenticated;


    public JWTAuthentication(String tString) {
        tokenString = tString;
        authorities = new ArrayList<>(0);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getDetails() {
        return tokenClaims.toString();
    }

    @Override
    public Object getPrincipal() {
        return tokenClaims.getSubject();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return tokenClaims.getSubject();
    }

    public String getToken() {
        return tokenString;
    }

    public void setTokenClaims(Claims tTokenClaims) {
        log.info("Inside setTokenClaims JWTAuthentication");
        this.tokenClaims = tTokenClaims;
        Collection roles = tokenClaims.get(ROLES_CLAIM_NAME, Collection.class);
        if (null != roles) {
            ArrayList<GrantedAuthority> authsList = new ArrayList<>(roles.size());
            for (Object role : roles) {
                authsList.add(new SimpleGrantedAuthority(role.toString()));
            }
            authorities = Collections.unmodifiableList(authsList);
        } else {
            authorities = Collections.emptyList();
        }
    }
}
