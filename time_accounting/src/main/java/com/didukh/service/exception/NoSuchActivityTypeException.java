package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class NoSuchActivityTypeException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Such activity type is not found";

    public NoSuchActivityTypeException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
