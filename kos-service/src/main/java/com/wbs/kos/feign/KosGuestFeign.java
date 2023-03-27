package com.wbs.kos.feign;

import com.wbs.kos.model.dto.KosGuestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "users-feign", url = "${client.post.baseUrl}:${server.port}", fallback = KosGuestFeign.KosGuestFeignFallback.class)
public interface KosGuestFeign {
    /*
     * These request mapping are getting from KosGuestController
     */
    @RequestMapping(method = RequestMethod.GET, value = "/guests/{id}")
    public KosGuestDto getKosGuestById(@PathVariable("id") Long guestKey);

    @Component
    @Slf4j
    public static class KosGuestFeignFallback implements KosGuestFeign {

        @Override
        public KosGuestDto getKosGuestById(@PathVariable("id") Long guestKey) {
            log.info("Inside getKosGuestById Service Fallback");
            return new KosGuestDto();
        }
    }
}
