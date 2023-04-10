package com.wbs.kos.model;

import com.wbs.kos.model.dto.KosGuestDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"username"})})
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
