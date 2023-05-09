package com.wbs.kos.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomType {
    AC("AC"), NONAC("NONAC");

    private String code;

    private RoomType(String code) {
        this.code = code;
    }

    @JsonCreator
    public static RoomType getRoomTypeFromCode(String value) {
 
        for (RoomType rn : RoomType.values()) {
 
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
