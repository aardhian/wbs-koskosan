package com.wbs.kos.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KosGuest{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guestKey;

    private String firstName;

    private String middleName;
    private String lastName;
    private String cellphone;

    @Column(unique = true)
    private String email;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date checkinDate;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "account_key")
    private KosAccount kosAccount;
}
