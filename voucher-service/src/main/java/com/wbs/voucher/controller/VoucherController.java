package com.wbs.voucher.controller;

import com.wbs.voucher.model.Voucher;
import com.wbs.voucher.service.VoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vouchers")
@Slf4j
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping("/")
    public Voucher saveVoucher(@RequestBody Voucher voucher) {
        log.info("Inside saveVoucher controller");
        return voucherService.saveVoucher(voucher);
    }

    @GetMapping("/guestKey/{id}")
    public List<Voucher> findAllVouchersByGuestKey(@PathVariable("id") Long guestKey) {
        log.info("Inside findAllVouchersByGuestKey controller");
        return voucherService.findAllVouchersByGuestKey(guestKey);
    }
}
