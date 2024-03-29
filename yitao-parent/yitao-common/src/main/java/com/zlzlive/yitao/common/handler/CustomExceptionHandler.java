package com.zlzlive.yitao.common.handler;

import com.zlzlive.yitao.common.entity.CommonResponse;
import com.zlzlive.yitao.common.exception.ParamValidationException;
import com.zlzlive.yitao.common.exception.PermissionDeniedException;
import com.zlzlive.yitao.common.exception.ResourceNotFoundException;
import com.zlzlive.yitao.common.exception.ServiceException;
import org.apache.logging.log4j.core.Logger;
import org.springframework.http.HttpStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j2
@ControllerAdvice(annotations = ResponseBody.class)
public class CustomExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResponse commonExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[SystemException]Exception:", e);
        return commonResponse.fail("System Error, please try again later! Message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(value = ServiceException.class)
    public CommonResponse serviceExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ServiceException]Exception:", e);
        return commonResponse.fail("ServiceException, message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = PermissionDeniedException.class)
    public CommonResponse permissionDeniedExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[PermissionDeniedException]Exception:", e);
        return commonResponse.fail("Permission Denied!");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ParamValidationException.class,
            ServletRequestBindingException.class})
    public CommonResponse paramValidationExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ParamValidationException]Exception:", e);
        return commonResponse.fail("Parameter validation failure! Message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public CommonResponse resourceNotFoundExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ResourceNotFoundException]Exception:", e);
        return commonResponse.fail("Resource not found! Message:" + e.getMessage());
    }
}
