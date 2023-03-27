package com.wbs.kos.service;

import com.wbs.kos.feign.KosGuestFeign;
import com.wbs.kos.model.KosUser;
import com.wbs.kos.model.dto.KosGuestDto;
import com.wbs.kos.repository.KosUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KosUserService {
    @Autowired
    private KosUserRepository kosUserRepository;
    @Autowired
    KosGuestFeign kosGuestFeign;

    public KosUser saveKosUser(KosUser kosUser) {
        log.info("Inside saveKosUser Service");
        return kosUserRepository.save(kosUser);
    }

    public KosUser getKosUserById(Long userKey) {
        log.info("Inside getKosUserById Service");
        KosUser kosUser = kosUserRepository.findById(userKey).get();
        KosGuestDto kosGuestDto = kosGuestFeign.getKosGuestById(kosUser.getGuestKey());
        kosUser.setKosGuestDto(kosGuestDto);
        return kosUser;
    }
}
