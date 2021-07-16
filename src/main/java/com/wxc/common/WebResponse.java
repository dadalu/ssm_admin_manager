package com.wxc.common;

import org.springframework.util.Assert;

/**
 * 返回给前端的数据结构
 *
 * @author cAn
 */
public class WebResponse {
    private Status status;
    private String message;
    private Object result;

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }

    public static final class Builder {
        public Builder() {}

        public static WebResponse success() {
            WebResponse response = new WebResponse();
            response.status = Status.SUCCESS;
            return response;
        }

        public static WebResponse success(Object result) {
            Assert.notNull(result, "result is null");
            WebResponse response = new WebResponse();
            response.status = Status.SUCCESS;
            response.result = result;
            return response;
        }

        public static WebResponse fail(String message) {
            Assert.hasText(message, "message is not empty");
            WebResponse response = new WebResponse();
            response.status = Status.ERROR;
            response.message = message;
            return response;
        }

        public static WebResponse fail(Status status, String message) {
            Assert.notNull(status, "status can not null");
            Assert.hasText(message, "message is not empty");
            WebResponse response = new WebResponse();
            response.status = status;
            response.message = message;
            return response;
        }
    }
}
