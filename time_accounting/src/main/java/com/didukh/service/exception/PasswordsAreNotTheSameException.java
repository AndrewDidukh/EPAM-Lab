package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class PasswordsAreNotTheSameException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Passwords are not the same";


    public PasswordsAreNotTheSameException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
