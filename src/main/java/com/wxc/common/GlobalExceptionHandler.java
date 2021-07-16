package com.wxc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理类
 *
 * @author cAn
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public WebResponse handleBusinessException(BusinessException e) {
        String errorMsg = e.getMsg();
        if (Status.NO_LOGIN.name().equals(errorMsg)) {
            return WebResponse.Builder.fail(Status.NO_LOGIN, "用户未登录，请先登录");
        }
        WebResponse resp = WebResponse.Builder.fail(e.getMsg());
        return resp;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public WebResponse HandleArgumentException(MethodArgumentNotValidException e) {
        // 记录错误日志到日志文件中
        List<ObjectError> errorList = e.getBindingResult().getAllErrors();
        errorList.forEach(item -> LOGGER.info("参数错误：{}", item.getDefaultMessage()));
        WebResponse resp = WebResponse.Builder.fail(errorList.get(0).getDefaultMessage());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    public WebResponse jsonErrorHandler(Exception e) {
        // 记录错误日志到日志文件中
        LOGGER.error("系统异常", e);
        WebResponse resp = WebResponse.Builder.fail("系统异常，请联系管理员");
        return resp;
    }

}

