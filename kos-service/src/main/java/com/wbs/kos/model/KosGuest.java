package com.wbs.kos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "guestKey", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<KosUser> kosUsers = new ArrayList<KosUser>();
}
