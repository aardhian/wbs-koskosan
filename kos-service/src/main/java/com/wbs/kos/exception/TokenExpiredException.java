package com.wbs.kos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class TokenExpiredException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TokenExpiredException(){}

    public TokenExpiredException(String string) {
        super(string);
    }

}
