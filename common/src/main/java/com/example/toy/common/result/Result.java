package com.example.toy.common.result;


import java.util.HashMap;
import java.util.Map;

public class Result {
    private String code;
    private String status;
    private String message;
    private String messageCode;
    private Map<String, Object> extend;

    public Result() {

    }


    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.toString();
    }

    public Result(ResultCode resultCode, String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }

    public Result(ResultCode resultCode, String key, String value) {
        this.code = resultCode.getCode();
        this.message = resultCode.toString();
        this.put(key, value);
    }

    public Result setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.toString();

        return this;
    }

    public Result setResultCode(ResultCode resultCode, String key, Object value) {
        this.code = resultCode.getCode();
        this.message = resultCode.toString();
        this.put(key, value);

        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public Result setExtend(Map<String, Object> extend) {
        this.extend = extend;
        return this;
    }

    public void put(String key, Object object) {
        if (extend == null) {
            extend = new HashMap<String, Object>();
        }
        this.extend.put(key, object);
    }
}
