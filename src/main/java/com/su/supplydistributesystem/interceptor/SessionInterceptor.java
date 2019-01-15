package com.su.supplydistributesystem.interceptor;

import com.su.supplydistributesystem.context.SessionContext;
import com.sug.core.platform.exception.LoginRequiredException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(SessionInterceptor.class);

    @Autowired
    private SessionContext sessionContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("SessionInterceptor ----------preHandle------------, URI=" + request.getRequestURI());

        //如果Annotation标识有LoginRequired, 判断method是否含有customer session
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        if ((((HandlerMethod) handler).getMethod().isAnnotationPresent(UserLoginRequired.class)
                || ((HandlerMethod) handler).getBeanType().isAnnotationPresent(UserLoginRequired.class))
                && Objects.isNull(sessionContext.getUser())) {
            throw new LoginRequiredException("user loginRequired");
        }

        if ((((HandlerMethod) handler).getMethod().isAnnotationPresent(DistributorLoginRequired.class)
                || ((HandlerMethod) handler).getBeanType().isAnnotationPresent(DistributorLoginRequired.class))
                && Objects.isNull(sessionContext.getDistributor())) {
            throw new LoginRequiredException("distributor loginRequired");
        }

        return true;
    }

}

