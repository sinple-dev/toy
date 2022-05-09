package com.example.toy.common.result;

import java.util.Map;

public class SuccessResult extends Result {
    public SuccessResult() {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMessage(ResultCode.SUCCESS.toString());
    }

    public SuccessResult(String msg) {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMessage(msg);
    }

    public SuccessResult(String key, String value) {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMessage(ResultCode.SUCCESS.toString());
        this.put(key, value);
    }

    public SuccessResult(Map<String, Object> params) {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMessage(ResultCode.SUCCESS.toString());
        if (params != null) {
            for (String key : params.keySet()) {
                this.put(key, params.get(key));
            }
        }
    }
}