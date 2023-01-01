package com.wbs.login.service;

import com.wbs.login.model.User;
import com.wbs.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser service");
        return userRepository.save(user);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        log.info("Inside getUserByUsernameAndPassword service");
        return userRepository.getUserByUsernameAndPassword(username, password);
    }
}
