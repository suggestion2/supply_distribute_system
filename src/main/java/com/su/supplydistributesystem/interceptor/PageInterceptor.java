package com.su.supplydistributesystem.interceptor;


import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.User;
import com.sug.core.platform.exception.LoginRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


public class PageInterceptor extends HandlerInterceptorAdapter {

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PageInterceptor.class);

    @Autowired
    private SessionContext sessionContext;

    @Value("${spring.profiles.active:@null}")
    private String env;

    @Value("${website.domain:@null}")
    private String domain;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.debug("PageInterceptor ----------preHandle------------, URI=" + request.getRequestURI());


        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }


        if ((((HandlerMethod) handler).getMethod().isAnnotationPresent(UserLoginRequired.class)
                || ((HandlerMethod) handler).getBeanType().isAnnotationPresent(UserLoginRequired.class))
                && Objects.isNull(sessionContext.getUser())) {
            String url = request.getRequestURI();
            if(url.contains("wap")){
                response.sendRedirect("/wap/login?redirectUrl=" + url);
            }
            response.sendRedirect("/management/login?redirectUrl=" + url);
            return false;
        }
        return true;
    }
}

