package com.wxc.common;

/**
 * 业务异常类
 *
 * @author cAn
 */
public class BusinessException extends Exception {

    private String msg;
    private Status status;

    public BusinessException(String msg, Status... status) {
        this.msg = msg;
        if (status != null && status.length > 0) {
            this.status = status[0];
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
