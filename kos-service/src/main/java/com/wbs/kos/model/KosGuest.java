package com.wbs.kos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KosGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guestKey;
    private String name;
    private String firstName;
    private String lastName;
    private String cellphone;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
}
