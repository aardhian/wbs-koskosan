package com.wbs.kos.feign;

import com.wbs.kos.model.KosGuest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "usersfeign", url = "http://localhost:8091")
public interface KosGuestFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/guests/{id}")
    public KosGuest getKosGuestById(@PathVariable("id") Long guestKey);
}
