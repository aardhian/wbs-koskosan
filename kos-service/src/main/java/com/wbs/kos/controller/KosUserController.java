package com.wbs.kos.controller;

import com.wbs.kos.model.KosUser;
import com.wbs.kos.service.KosUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class KosUserController {
    @Autowired
    private KosUserService kosUserService;

    @PostMapping("/register")
    public KosUser saveKosUser(@RequestBody KosUser kosUser) {
        log.info("Inside saveKosUser Controller");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = kosUser.getPassword().trim().isEmpty()? "" : encoder.encode(kosUser.getPassword());
        kosUser.setPassword(encryptedPassword);

        return kosUserService.saveKosUser(kosUser);
    }

    @GetMapping("/{id}")
    public KosUser getKosUserById(@PathVariable("id") Long userKey) {
        log.info("Inside getKosUserById Controller");
        return kosUserService.getKosUserById(userKey);
    }

    @GetMapping("/username/{username}")
    public KosUser getKosUserByUsername(@PathVariable("username") String username) {
        log.info("Inside getKosUserByUsername Controller");
        return kosUserService.getKosUserByUsername(username);
    }

}
