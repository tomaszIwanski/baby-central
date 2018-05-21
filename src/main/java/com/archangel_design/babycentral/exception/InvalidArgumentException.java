package com.archangel_design.babycentral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
        super();
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
