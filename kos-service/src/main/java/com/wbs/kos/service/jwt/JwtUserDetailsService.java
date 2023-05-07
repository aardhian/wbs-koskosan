package com.wbs.kos.service.jwt;

import com.wbs.kos.model.KosUser;
import com.wbs.kos.model.jwt.JwtUser;
import com.wbs.kos.model.jwt.JwtUserDetails;
import com.wbs.kos.repository.KosUserRepository;
import com.wbs.kos.service.KosUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private KosUserRepository kosUserRepository;
    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername JwtUserDetailsService username = "+username);
        KosUser kosUser = kosUserRepository.findByUsernameAndActiveTrue(username);
        log.info("kosUser.username = "+kosUser.getUsername());
        if (kosUser != null && kosUser.getUsername().equals(username)) {
            JwtUser user = new JwtUser(kosUser.getUsername(),
                    kosUser.getPassword(),
                    new ArrayList<>());
            user.setUserKey(kosUser.getUserKey());
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    
}
