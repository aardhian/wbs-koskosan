package com.wbs.kos.model;

import com.wbs.kos.model.dto.KosGuestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KosUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userKey;
    private String username;
    private String password;
    private Boolean active;
    private Long guestKey;
    @Transient
    private KosGuestDto kosGuestDto;
}
