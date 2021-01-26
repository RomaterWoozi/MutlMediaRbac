package com.wuzx.login.exception;

import com.wuzx.login.enums.ResultCode;

public class ApiException extends RuntimeException{


    public ApiException(String excMsg) {
    }

    public ApiException(ResultCode resultCode) {
    }
}
