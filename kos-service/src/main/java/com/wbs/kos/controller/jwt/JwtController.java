package com.wbs.kos.controller.jwt;

import com.wbs.kos.component.TokenManager;
import com.wbs.kos.feign.KosGuestFeign;
import com.wbs.kos.model.KosUser;
import com.wbs.kos.model.dto.KosGuestDto;
import com.wbs.kos.model.dto.LoggedInUser;
import com.wbs.kos.model.jwt.JwtLoginRequestModel;
import com.wbs.kos.model.jwt.JwtLoginResponseModel;
import com.wbs.kos.model.jwt.JwtRequestVerifyModel;
import com.wbs.kos.model.jwt.JwtUserDetails;
import com.wbs.kos.service.KosUserService;
import com.wbs.kos.service.jwt.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/v1/token")
public class JwtController {
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private KosGuestFeign kosGuestFeign;
    @Autowired
    private KosUserService kosUserService;
    
    @PostMapping("/login")
    public ResponseEntity createToken(@RequestBody JwtLoginRequestModel
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
        final JwtUserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        log.info("Token Generated: "+jwtToken);
        LoggedInUser loggedInUser = new LoggedInUser(request.getUsername(), "");
        JwtLoginResponseModel jwtLoginResponseModel = new JwtLoginResponseModel(jwtToken, loggedInUser);

        KosUser kosUser = kosUserService.getKosUserByUsername(userDetails.getUsername());
        //KosGuestDto kosGuestDto = kosGuestFeign.getKosGuestTokenById(jwtToken, kosUser.getGuestKey().getGuestKey());
        KosGuestDto kosGuestDto = new KosGuestDto();
        kosGuestDto.setGuestKey(kosUser.getGuestKey().getGuestKey());
        if(kosGuestDto != null) {
            jwtLoginResponseModel.setId(kosGuestDto.getGuestKey());
//            jwtLoginResponseModel.setFirstName(kosGuestDto.getName());
//            jwtLoginResponseModel.setEmail(request.getUsername());
//            jwtLoginResponseModel.setCellphone(kosGuestDto.getCellphone());
        }
        return ResponseEntity.ok(jwtLoginResponseModel);
    }
    @PostMapping("/verify")
    public ResponseEntity verifyToken(@RequestBody JwtRequestVerifyModel
                                                  request) throws Exception {
        log.info("Inside verifyToken JwtController");
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
        final JwtUserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        LoggedInUser loggedInUser = new LoggedInUser(request.getUsername(), "");
        if (!tokenManager.validateJwtToken(request.getToken(), userDetails)) {
            log.info("Token verified: is valid");
            throw new Exception("INVALID_CREDENTIALS");
        }
        return ResponseEntity.ok(new JwtLoginResponseModel(request.getToken(), loggedInUser));
    }
    @PostMapping("/refresh")
    public ResponseEntity refreshToken(@RequestBody JwtLoginRequestModel
                                              request) throws Exception {
        log.info("Inside refreshToken JwtController");
        return createToken(request);
    }
}
