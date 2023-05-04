package com.wbs.kos.model;

import com.wbs.kos.model.dto.KosGuestDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"username"})})
@AllArgsConstructor
@NoArgsConstructor
public class KosUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userKey;
    private String username;
    private String password;
    private Boolean active;
    private Long guestKey;

    @ManyToOne
    @JoinColumn(name = "account_key")
    private KosAccount kosAccount;

    @Transient
    private KosGuestDto kosGuestDto;
}
