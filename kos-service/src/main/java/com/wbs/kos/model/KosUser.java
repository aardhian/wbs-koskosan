package com.wbs.kos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
