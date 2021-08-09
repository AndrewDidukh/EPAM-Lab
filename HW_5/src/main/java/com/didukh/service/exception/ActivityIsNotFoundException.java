package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class ActivityIsNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Activity is not found";


    public ActivityIsNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
