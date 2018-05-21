package com.archangel_design.babycentral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Session expired.")
public class SessionExpiredException extends RuntimeException {

}
