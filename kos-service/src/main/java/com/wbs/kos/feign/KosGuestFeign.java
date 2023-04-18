package com.wbs.kos.feign;

import com.wbs.kos.config.OAuthFeignConfig;
import com.wbs.kos.model.dto.KosGuestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "users-feign", url = "${client.post.baseUrl}:${server.port}", fallback = KosGuestFeign.KosGuestFeignFallback.class, configuration = OAuthFeignConfig.class)
public interface KosGuestFeign {
    /*
     * These request mapping are getting from KosGuestController
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/guests/{id}")
    public KosGuestDto getKosGuestById(@PathVariable("id") Long guestKey);
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/guests/username/{username}")
    public KosGuestDto getKosGuestByUsername(@PathVariable("username") String username);

    @Component
    @Slf4j
    public static class KosGuestFeignFallback implements KosGuestFeign {

        @Override
        public KosGuestDto getKosGuestById(@PathVariable("id") Long guestKey) {
            log.info("Inside getKosGuestById Service Fallback");
            return new KosGuestDto();
        }

        @Override
        public KosGuestDto getKosGuestByUsername(@PathVariable("username") String username) {
            return new KosGuestDto();
        }
    }
}
