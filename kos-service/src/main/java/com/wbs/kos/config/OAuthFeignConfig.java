package com.wbs.kos.config;

import com.wbs.kos.component.TokenManager;
import com.wbs.kos.service.jwt.JwtUserDetailsService;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@Slf4j
public class OAuthFeignConfig {

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private TokenManager tokenManager;
    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> {
            log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig = "+authentication);
            log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig = "+authentication.getDetails());
            if (authentication != null && authentication.isAuthenticated()) {
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
                User user = (User)token.getPrincipal();

                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig USER = "+user.getUsername());
                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig PASSWORD = "+user.getPassword());

                final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                final String jwtToken = tokenManager.generateJwtToken(userDetails);

                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig TOKEN = "+jwtToken);
                requestTemplate.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", jwtToken));
            }
        };
    }
}
