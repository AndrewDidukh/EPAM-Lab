package com.didukh.service.exception;

import com.didukh.service.model.enums.ErrorType;

public class ActivityIsNotAcceptedException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Activity is not accepted";


    public ActivityIsNotAcceptedException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
