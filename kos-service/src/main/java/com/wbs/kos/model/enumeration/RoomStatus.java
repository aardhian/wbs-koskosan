package com.wbs.kos.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomStatus {
    UNAVAILABLE("UNAVAILABLE"), AVAILABLE("AVAILABLE"), OPEN("OPEN"), NORENT("NORENT"), REPAIR("REPAIR");

    private String code;

    private RoomStatus (String code) {
        this.code = code;
    }

    @JsonCreator
    public static RoomStatus getRoomStatusFromCode(String value) {
 
        for (RoomStatus rn : RoomStatus.values()) {
 
            if (rn.getCode().equals(value)) {
 
                return rn;
            }
        }
 
        return null;
    }

    @JsonValue
	public String getCode() {
		return code;
	}
}
