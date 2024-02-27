package com.prp.business.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus status;
    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.status = errorMessage.getStatus();
    }
    public BusinessException(HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
    }

}
