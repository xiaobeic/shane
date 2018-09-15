package com.info.shane.exception;

import com.info.shane.constant.ErrorCodes;

public class NoUserException extends CustomizedException {

    public NoUserException(String msg) {
        super(msg);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodes.NO_USER;
    }
}
