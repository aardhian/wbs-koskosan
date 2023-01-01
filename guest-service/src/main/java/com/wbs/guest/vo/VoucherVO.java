package com.wbs.guest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherVO {
    private String voucherCode;
    private Date voucherIssued;
    private Integer duration;
}
