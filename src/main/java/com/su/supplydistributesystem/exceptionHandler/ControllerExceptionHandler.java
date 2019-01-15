package com.su.supplydistributesystem.exceptionHandler;

import com.sug.core.platform.exception.ForbiddenException;
import com.sug.core.platform.exception.LoginRequiredException;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/5/24.
 */
@ControllerAdvice("com.su.supplydistributesystem.controller.page")
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {

        return "404";
    }

    @ExceptionHandler(ForbiddenException.class)
    public String handleForbiddenException() {

        return "404";
    }

    @ExceptionHandler(LoginRequiredException.class)
    public String handleUserAuthorizationException(HttpServletRequest request) throws UnsupportedEncodingException {
        return String.format("redirect:/management/login?returnUrl=%s", URLEncoder.encode(request.getServletPath(),"UTF-8"));
    }

    @ExceptionHandler(value = Throwable.class)
    public String error(Throwable e) {
        logger.error(ExceptionUtils.stackTrace(e));

        return "500";
    }
}
