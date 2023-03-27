package com.wbs.kos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KosUserDto {
    private String username;
    private String password;
    private Boolean active;
    private Long guestKey;
}
