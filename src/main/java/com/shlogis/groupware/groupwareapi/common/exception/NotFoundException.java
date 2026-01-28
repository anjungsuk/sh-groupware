package com.shlogis.groupware.groupwareapi.common.exception;

public class NotFoundException extends BusinessException {

    public NotFoundException() {
        super(ErrorCode.RESOURCE_NOT_FOUND);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(String message) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message);
    }

    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
