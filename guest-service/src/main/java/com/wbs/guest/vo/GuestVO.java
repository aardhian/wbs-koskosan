package com.wbs.guest.vo;

import com.wbs.guest.model.Guest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestVO {
    private Guest guest;
    private List<RoomVO> rooms;
    private List<VoucherVO> vouchers;
}
