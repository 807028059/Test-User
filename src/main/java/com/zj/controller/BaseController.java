package com.zj.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ModelAttribute
    protected void preMethod(HttpServletRequest request, Model model) {
        String ctx = request.getContextPath();
        model.addAttribute("proPath",ctx);
    }
}
