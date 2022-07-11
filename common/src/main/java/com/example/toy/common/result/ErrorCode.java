package com.example.toy.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ErrorCode {

    OVER_FILE_SIZE("fail", "804", "파일 사이즈는 320*240 이하여야만 합니다."),
    INTERNAL_SERVER_ERROR("fail", "500", "서버 에러");

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
