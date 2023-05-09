package com.wbs.kos.service.impl;

import com.wbs.kos.model.KosRoom;
import com.wbs.kos.repository.KosGuestRepository;
import com.wbs.kos.repository.KosRoomRepository;
import com.wbs.kos.service.KosRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KosRoomServiceImpl implements KosRoomService {
    @Autowired
    private KosGuestRepository kosGuestRepository;
    @Autowired
    private KosRoomRepository kosRoomRepository;

    @Override
    public KosRoom saveKosRoom(KosRoom kosRoom) {
        log.info("Inside saveKosRoom Service");
        return kosRoomRepository.save(kosRoom);
    }

    @Override
    public KosRoom getKosRoomById(Long roomKey) {
        log.info("Inside getKosRoomById Service");
        return kosRoomRepository.findById(roomKey).get();
    }
}
