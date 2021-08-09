package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class AdminIsNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Admin is not found";

    public AdminIsNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
