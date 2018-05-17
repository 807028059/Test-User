package com.zj.proxy;

import com.zj.exception.LoginException;
import com.zj.model.IsLogin;
import com.zj.model.User;
import javafx.fxml.LoadException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoginProxy {

    @Autowired
    private HttpSession session;

    @Pointcut(value = "@annotation(com.zj.model.IsLogin)")
    private void pointcut(){

    }

    @Before(value="pointcut()")
    public void beforeMethod(JoinPoint joinPoint){
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new LoginException("请先登录");
        }
    }

}
