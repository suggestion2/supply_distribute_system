package com.su.supplydistributesystem.context;

import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionContext {
    private static final long CAPTCHA_EXPIRED_TIME = 120000L;

    @Autowired
    private HttpSession httpSession;

    public void setUser(User user){
        httpSession.setAttribute("user",user);
    }

    public User getUser(){
        return httpSession.getAttribute("user") == null ? null : (User)httpSession.getAttribute("user");
    }

    public void setDistributor(Distributor distributor){
        httpSession.setAttribute("distributor",distributor);
    }

    public Distributor getDistributor(){
        return httpSession.getAttribute("user") == null ? null : (Distributor)httpSession.getAttribute("distributor");
    }

    public void logout(){
        httpSession.invalidate();
    }
}
