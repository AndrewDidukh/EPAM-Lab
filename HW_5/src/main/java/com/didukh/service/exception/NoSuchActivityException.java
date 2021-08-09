package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class NoSuchActivityException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "User with such activity is not found";

    public NoSuchActivityException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
