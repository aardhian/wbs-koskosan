package com.wbs.kos.service.jwt;

import com.wbs.kos.model.KosUser;
import com.wbs.kos.repository.KosUserRepository;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername JwtUserDetailsService username = "+username);
        KosUser kosUser = kosUserRepository.findByUsername(username);
        log.info("kosUser.username = "+kosUser.getUsername());
        if (kosUser != null && kosUser.getUsername().equals(username)) {
            /*return new User("randomuser123",
                    "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());*/
            return new User(kosUser.getUsername(),
                    kosUser.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
