package com.wbs.kos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wbs.kos.model.enumeration.RoomNumber;
import com.wbs.kos.model.enumeration.RoomStatus;
import com.wbs.kos.model.enumeration.RoomType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KosRoom{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomKey;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.ORDINAL)
    private RoomStatus roomStatus;
    @Enumerated(EnumType.STRING)
    private RoomNumber roomNumber;
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "kos_room_guest", joinColumns = {@JoinColumn(name = "room_key")}, inverseJoinColumns = {@JoinColumn(name = "guest_key")})
    private List<KosGuest> kosGuests = new ArrayList<KosGuest>();

}
