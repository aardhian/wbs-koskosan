package com.wbs.kos.controller.jwt;

import com.wbs.kos.component.TokenManager;
import com.wbs.kos.feign.KosGuestFeign;
import com.wbs.kos.model.KosGuest;
import com.wbs.kos.model.dto.KosGuestDto;
import com.wbs.kos.model.dto.LoggedInUser;
import com.wbs.kos.model.jwt.JwtRequestModel;
import com.wbs.kos.model.jwt.JwtResponseModel;
import com.wbs.kos.service.jwt.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class JwtController {
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private KosGuestFeign kosGuestFeign;
    @PostMapping("/login")
    public ResponseEntity createToken(@RequestBody JwtRequestModel
                                                request) throws Exception {
        log.info("Inside createToken JwtController");
        try {
            authenticationManager.authenticate(
                    new
                            UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        log.info("Token Generated: "+jwtToken);
        LoggedInUser loggedInUser = new LoggedInUser(request.getUsername(), "");
        return ResponseEntity.ok(new JwtResponseModel(jwtToken, loggedInUser));
    }
}
