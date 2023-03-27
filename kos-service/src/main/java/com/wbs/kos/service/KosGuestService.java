package com.wbs.kos.service;

import com.wbs.kos.model.KosGuest;

public interface KosGuestService {

    public KosGuest saveKosGuest(KosGuest kosGuest);

    public KosGuest getKosGuestById(Long guestKey);
}
