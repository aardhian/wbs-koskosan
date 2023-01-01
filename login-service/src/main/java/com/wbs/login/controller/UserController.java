package com.wbs.login.controller;

import com.wbs.login.model.User;
import com.wbs.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser controller");
        return userService.saveUser(user);
    }
    @GetMapping("/")
    public User getActiveUserByUsernameAndPassword(@PathVariable("username") String username,
                                                     @PathVariable("password") String password) {
        log.info("Inside getActiveUserByUsernameAndPassword controller");
        User user = userService.getUserByUsernameAndPassword(username, password);
        return user;
    }
}
