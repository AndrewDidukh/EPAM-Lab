package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class AdminAlreadyExistsException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Admin already exists";

    public AdminAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
