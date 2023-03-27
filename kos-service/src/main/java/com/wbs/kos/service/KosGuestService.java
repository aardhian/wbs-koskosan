package com.wbs.kos.service;

import com.wbs.kos.model.KosGuest;
import com.wbs.kos.repository.KosGuestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KosGuestService {
    @Autowired
    private KosGuestRepository kosGuestRepository;

    public KosGuest saveKosGuest(KosGuest kosGuest) {
        log.info("Inside saveKosGuest Service");
        return kosGuestRepository.save(kosGuest);
    }

    public KosGuest getKosGuestById(Long guestKey) {
        log.info("Inside getKosGuestById Service");
        return kosGuestRepository.findById(guestKey).get();
    }
}
