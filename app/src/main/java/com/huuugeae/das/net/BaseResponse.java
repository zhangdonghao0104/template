package com.huuugeae.das.net;

public class BaseResponse<T> {
    private int code = 0;    //成功的code
    private boolean success;                 //响应码
    private String message;                //提示信息
    private String msg;                //提示信息
    private T body;                     //返回的具体数据

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}