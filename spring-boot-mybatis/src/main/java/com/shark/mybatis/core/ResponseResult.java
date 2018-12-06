package com.shark.mybatis.core;

public class ResponseResult {
    private Integer code = 0;
    private String message = "success";
    private Object result;

    public ResponseResult() {
    }

    public ResponseResult(Object result) {
        this.result = result;
    }

    public ResponseResult(Integer code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
