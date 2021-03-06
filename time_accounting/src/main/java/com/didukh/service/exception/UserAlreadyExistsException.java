package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class UserAlreadyExistsException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "User already exists";

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
