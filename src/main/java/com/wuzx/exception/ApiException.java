package com.wuzx.exception;

import com.wuzx.enums.ResultCode;

public class ApiException extends RuntimeException{


    public ApiException(String excMsg) {
    }

    public ApiException(ResultCode resultCode) {
    }
}
