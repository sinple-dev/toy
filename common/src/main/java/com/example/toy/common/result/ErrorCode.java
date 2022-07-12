package com.example.toy.common.result;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BAD_REQUEST("fail", "400", "잘못된 요청")
    ;

    private final String status;
    private final String code;
    private final String message;


    ErrorCode(final String status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
