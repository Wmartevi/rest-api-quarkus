package org.rest.api.exception;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class BadRequestException extends RuntimeException {

    public String BadRequestException(String message){
       return message + Response.Status.BAD_REQUEST;
    }
}
