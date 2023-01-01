package com.wbs.room.controller;

import com.wbs.room.model.Room;
import com.wbs.room.service.RoomService;
import com.wbs.room.vo.GuestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
@Slf4j
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/")
    public Room saveRoom(@RequestBody Room room) {
        log.info("Inside saveRoom controller");
        return roomService.saveRoom(room);
    }

    @GetMapping("/guestKey/{id}")
    public List<Room> findAllRoomsByGuestKey(@PathVariable("id") Long guestKey) {
        log.info("Inside getGuestWithAllRooms controller");

        return roomService.findAllRoomsByGuestKey(guestKey);

    }
}
