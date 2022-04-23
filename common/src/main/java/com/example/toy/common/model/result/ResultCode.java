package com.example.toy.common.model.result;

public enum ResultCode {

    //DEFAULT
    FAIL("0"),
    SUCCESS("1");

    private String code;

    private ResultCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}