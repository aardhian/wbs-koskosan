package com.wbs.kos.service;

import com.wbs.kos.model.KosUser;
import com.wbs.kos.repository.KosUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KosUserService {
    @Autowired
    private KosUserRepository kosUserRepository;

    public KosUser saveKosUser(KosUser kosUser) {
        log.info("Inside saveKosUser Service");
        return kosUserRepository.save(kosUser);
    }

    public KosUser getKosUserById(Long userKey) {
        log.info("Inside getKosUserById Service");
        return kosUserRepository.findById(userKey).get();
    }
}
