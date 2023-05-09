package com.wbs.kos.service;

import com.wbs.kos.model.KosRoom;

public interface KosRoomService {
    public KosRoom saveKosRoom(KosRoom kosRoom);
    public KosRoom getKosRoomById(Long roomKey);
}
