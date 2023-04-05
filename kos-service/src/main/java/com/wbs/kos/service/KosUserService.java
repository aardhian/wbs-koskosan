package com.wbs.kos.service;

import com.wbs.kos.model.KosUser;

public interface KosUserService {

    public KosUser saveKosUser(KosUser kosUser);

    public KosUser getKosUserById(Long userKey);

    public KosUser getKosUserByUsername(String username);
}
