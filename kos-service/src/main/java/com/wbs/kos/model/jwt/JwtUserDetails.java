package com.wbs.kos.model.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtUserDetails extends UserDetails{
    public Long getUserKey();
}
