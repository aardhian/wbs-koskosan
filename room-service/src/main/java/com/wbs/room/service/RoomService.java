package com.wbs.room.service;

import com.wbs.room.model.Room;
import com.wbs.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> findAllRoomsByGuestKey(Long guestKey) {
        return roomRepository.findByGuestKey(guestKey);
    }
}
