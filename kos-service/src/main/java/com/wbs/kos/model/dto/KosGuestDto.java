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
    private String name;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
}
