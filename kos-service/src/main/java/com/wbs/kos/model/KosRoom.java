package com.wbs.kos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

}
