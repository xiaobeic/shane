package com.info.shane.exception;

import com.info.shane.constant.ErrorCodes;

public class SessionExpiredException extends CustomizedException {
    public SessionExpiredException(String msg) {
        super(msg);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodes.SESSION_EXPIRED;
    }
}
