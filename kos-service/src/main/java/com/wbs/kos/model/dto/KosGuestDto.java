package com.wbs.kos.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KosGuestDto {
    private Long guestKey;
    private String name;
    private String firstName;
    private String lastName;
    private String cellphone;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
}
