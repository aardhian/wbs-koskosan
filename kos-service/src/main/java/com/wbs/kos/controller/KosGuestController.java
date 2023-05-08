package com.wbs.kos.controller;

import com.wbs.kos.model.KosGuest;
import com.wbs.kos.service.KosGuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guests")
@Slf4j
public class KosGuestController{
    @Autowired
    private KosGuestService kosGuestService;

    final String AUTH_TOKEN = "Authorization";

    @PostMapping("/")
    public KosGuest saveKosGuest(@RequestBody KosGuest kosGuest) {
        log.info("Inside saveKosGuest Controller");
        return kosGuestService.saveKosGuest(kosGuest);
    }

    @GetMapping("/{id}")
    public KosGuest getKosGuestById(@PathVariable("id") Long guestKey) {
        log.info("Inside getKosGuestById Controller");
        return kosGuestService.getKosGuestById(guestKey);
    }

    @GetMapping("/token/{id}")
    public KosGuest getKosGuestTokenById(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable("id") Long guestKey) {
        log.info("Inside getKosGuestById Controller");
        return kosGuestService.getKosGuestById(guestKey);
    }
}
