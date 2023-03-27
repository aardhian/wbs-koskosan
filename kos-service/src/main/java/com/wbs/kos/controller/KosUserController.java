package com.wbs.kos.controller;

import com.wbs.kos.feign.KosGuestFeign;
import com.wbs.kos.model.KosGuest;
import com.wbs.kos.model.KosUser;
import com.wbs.kos.service.KosUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class KosUserController {
    @Autowired
    private KosUserService kosUserService;

    @PostMapping("/")
    public KosUser saveKosUser(@RequestBody KosUser kosUser) {
        log.info("Inside saveKosUser Controller");
        return kosUserService.saveKosUser(kosUser);
    }

    @GetMapping("/{id}")
    public KosUser getKosUserById(@PathVariable("id") Long userKey) {
        log.info("Inside getKosUserById Controller");
        return kosUserService.getKosUserById(userKey);
    }

}
