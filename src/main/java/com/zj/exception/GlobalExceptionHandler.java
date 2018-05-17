package com.zj.exception;

import com.alibaba.fastjson.JSON;
import com.zj.controller.BaseController;
import com.zj.result.ResultInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(value = LoginException.class)
    public String handlerParamException(LoginException loginException, HttpServletRequest request,
                                        HttpServletResponse response,Model model){
        model.addAttribute("proPath", request.getContextPath());

        String xmlHttpRequest = request.getHeader("X-Requested-With");

        return "login";
    }
}














