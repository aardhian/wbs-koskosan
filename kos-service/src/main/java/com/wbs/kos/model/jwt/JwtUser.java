package com.wbs.kos.model.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JwtUser extends User implements JwtUserDetails{

    private Long userKey;

    public  JwtUser(java.lang.String username, java.lang.String password, java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public JwtUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public Long getUserKey() {
        return userKey;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }
    
}
