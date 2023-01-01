package com.wbs.room.vo;

import com.wbs.room.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestVO {
    private Long guestKey;
    private List<Room> rooms;
}
