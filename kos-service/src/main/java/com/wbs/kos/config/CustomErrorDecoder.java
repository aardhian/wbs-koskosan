package com.wbs.kos.config;

import com.wbs.kos.exception.BadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.data.crossstore.ChangeSetPersister;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new ChangeSetPersister.NotFoundException();
            default:
                return new Exception("Generic error");
        }
    }
}
