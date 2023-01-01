package com.wbs.guest.service;

import com.wbs.guest.model.Guest;
import com.wbs.guest.repository.GuestRepository;
import com.wbs.guest.vo.GuestVO;
import com.wbs.guest.vo.RoomVO;
import com.wbs.guest.vo.VoucherVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Guest saveGuest(Guest guest) {
        log.info("Inside saveGuest service");
        return guestRepository.save(guest);
    }

    public GuestVO getGuestByGuestKey(Long guestKey) {
        log.info("Inside getGuestByGuestKey service");

        GuestVO guestVO = new GuestVO();
        Guest guest = guestRepository.findById(guestKey).get();
        List<RoomVO> rooms = restTemplate.getForObject("http://localhost:8093/rooms/guestKey/"+guestKey,List.class);
        List<VoucherVO> vouchers = restTemplate.getForObject("http://localhost:8094/vouchers/guestKey/"+guestKey,List.class);

        //set guest into guestVO
        guestVO.setGuest(guest);
        //set roomVO into guestVO
        guestVO.setRooms(rooms);
        //set voucherVO into guestVO
        guestVO.setVouchers(vouchers);

        return guestVO;
    }
}
