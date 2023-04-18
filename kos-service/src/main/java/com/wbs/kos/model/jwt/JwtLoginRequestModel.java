package com.wbs.kos.model.jwt;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtLoginRequestModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}
