package com.wbs.guest.model;

import com.wbs.guest.vo.RoomVO;
import com.wbs.guest.vo.VoucherVO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guestKey;
    private String fullName;
    private String idNumber;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean active;
    @Transient
    private List<RoomVO> rooms;
    @Transient
    private List<VoucherVO> vouchers;
}
