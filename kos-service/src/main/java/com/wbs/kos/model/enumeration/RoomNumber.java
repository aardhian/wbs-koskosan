package com.wbs.kos.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomNumber {
    A1("A1"), A2("A2"), A3("A3"), A4("A4"), A5("A5"), A6("A6"), A7("A7"), A8("A8"), A9("A9"), A10("A10"), A11("A11"), A12("A12"), A13("A13"), A14("A14"), A15("A15"), A16("A16"), A17("A17"), A18("A18"), A19("A19"), A20("A20"), A21("A21"), A22("A22"), A23("A23"), A24("A24"),
    B1("B1"), B2("B2"), B3("B3"), B4("B4"), B5("B5"), B6("B6"), B7("B7"), B8("B8"), B9("B9"), B10("B10"), B11("B11"), B12("B12"), B13("B13"), B14("B14"), B15("B15"), B16("B16"), B17("B17"), B18("B18"), B19("B19"), B20("B20"), B21("B21"), B22("B22"), B23("B23"), B24("B24");

    private String code;
	
	private RoomNumber (String code) {
		this.code = code;
	}

    @JsonCreator
    public static RoomNumber getRoomNumberFromCode(String value) {
 
        for (RoomNumber rn : RoomNumber.values()) {
 
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
