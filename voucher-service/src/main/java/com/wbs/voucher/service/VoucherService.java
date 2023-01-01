package com.wbs.voucher.service;

import com.wbs.voucher.model.Voucher;
import com.wbs.voucher.repository.VoucherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public Voucher saveVoucher(Voucher voucher) {
        log.info("Inside saveVoucher service");
        return voucherRepository.save(voucher);
    }

    public List<Voucher> findAllVouchersByGuestKey(Long guestKey) {
        log.info("Inside findAllVouchersByGuestKey service");
        return voucherRepository.findByGuestKey(guestKey);
    }
}
