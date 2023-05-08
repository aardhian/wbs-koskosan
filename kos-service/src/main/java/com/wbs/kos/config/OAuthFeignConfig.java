package com.wbs.kos.config;

import com.wbs.kos.component.TokenManager;
import com.wbs.kos.model.jwt.JwtUser;
import com.wbs.kos.model.jwt.JwtUserDetails;
import com.wbs.kos.service.jwt.JwtUserDetailsService;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

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
                JwtUser user = (JwtUser)token.getPrincipal();

                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig USER = "+user.getUsername());
                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig PASSWORD = "+user.getPassword());

                final JwtUserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                final String jwtToken = tokenManager.generateJwtToken(userDetails);

                log.info("Inside RequestInterceptor->requestTemplate OAuthFeignConfig TOKEN = "+jwtToken);
                requestTemplate.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", jwtToken));
            }
        };
    }
}
