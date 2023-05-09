package com.wbs.kos.controller;

import com.wbs.kos.model.KosRoom;
import com.wbs.kos.service.KosRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@Slf4j
public class KosRoomController {
    @Autowired
    private KosRoomService kosRoomService;

    @PostMapping("/")
    public KosRoom saveKosRoom(@RequestBody KosRoom kosRoom) {
        log.info("Inside saveKosRoom Controller");
        return kosRoomService.saveKosRoom(kosRoom);
    }

    @GetMapping("/{id}")
    public KosRoom getKosRoomById(@PathVariable("id") Long roomKey) {
        log.info("Inside getKosRoomById Controller");
        return kosRoomService.getKosRoomById(roomKey);
    }
}
