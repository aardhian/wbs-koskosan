package com.wbs.kos.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){}
    public BadRequestException(String message){
        super(message);
    }
}
