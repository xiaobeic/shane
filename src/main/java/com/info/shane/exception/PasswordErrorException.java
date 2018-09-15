package com.info.shane.exception;

import com.info.shane.constant.ErrorCodes;

public class PasswordErrorException extends CustomizedException {

    public PasswordErrorException(String msg) {
        super(msg);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodes.PASSWORD_ERROR;
    }
}
