package com.zj.controller;

import com.zj.model.User;
import com.zj.result.ResultInfo;
import com.zj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(User user, HttpServletRequest request, HttpSession session){
        ResultInfo resultInfo = new ResultInfo();
        String id = request.getSession().getId();
        User acc= userService.login(user,id);
        System.out.println("sessioid---------------->"+id);
        if(acc!=null){
            //存session
            session.setAttribute("user", acc);
            resultInfo.setCode(200);
            resultInfo.setMes("登陆成功");
            return resultInfo;
        }
        resultInfo.setCode(300);
        resultInfo.setMes("登录失败");
        return resultInfo;
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user!=null){
            return "redirect:/student/main";
        }
        return "login";
    }

    @RequestMapping("out")
    public String out(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("yzm")
    public void sendYzm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 图片高度
        final int IMG_HEIGHT = 100;
        // 图片宽度
        final int IMG_WIDTH = 25;
        // 验证码长度
        final int CODE_LEN = 4;

        // 用于绘制图片，设置图片的长宽和图片类型（RGB)
        BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
        // 获取绘图工具
        Graphics graphics = bi.getGraphics();
        graphics.setColor(new Color(100, 230, 200)); // 使用RGB设置背景颜色
        graphics.fillRect(0, 0, 100, 30); // 填充矩形区域

        // 验证码中所使用到的字符
        char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
        String captcha = ""; // 存放生成的验证码
        Random random = new Random();
        for(int i = 0; i < CODE_LEN; i++) { // 循环将每个验证码字符绘制到图片上
            int index = random.nextInt(codeChar.length);
            // 随机生成验证码颜色
            graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
            // 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
            captcha += codeChar[index];
        }
        // 将生成的验证码code放入sessoin中
        request.getSession().setAttribute("code", captcha);
        // 通过ImageIO将图片输出
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    @RequestMapping("check")
    @ResponseBody
    public ResultInfo checkYzm(HttpServletRequest request, HttpServletResponse response){
        ResultInfo resultInfo = new ResultInfo();
        // 获取存放在session中的验证码
        String code = (String) request.getSession().getAttribute("code");
        // 获取页面提交的验证码
        String inputCode = request.getParameter("code");
        if(code.toLowerCase().equals(inputCode.toLowerCase())) { // 验证码不区分大小写
            // 验证成功，跳转到成功页面
            resultInfo.setCode(200);
        } else { // 验证失败
            resultInfo.setCode(300);
            resultInfo.setMes("验证码错误");
        }
        return resultInfo;
    }
}






















