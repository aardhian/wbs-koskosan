package com.wbs.guest.controller;

import com.wbs.guest.model.Guest;
import com.wbs.guest.service.GuestService;
import com.wbs.guest.vo.GuestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guests")
@Slf4j
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping("/")
    public Guest saveGuest(@RequestBody Guest guest) {
        log.info("Inside saveGuest controller");
        return guestService.saveGuest(guest);
    }

    @GetMapping("/{id}")
    public GuestVO getGuestByGuestKey(@PathVariable("id") Long guestKey) {
        log.info("Inside getGuestByGuestKey controller");

        GuestVO guestVO = guestService.getGuestByGuestKey(guestKey);

        return guestVO;
    }
}
