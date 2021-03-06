package com.zj.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zj.model.IsLogin;
import com.zj.model.Student;
import com.zj.model.User;
import com.zj.result.ResultInfo;
import com.zj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController extends BaseController{
    @Autowired
    private StudentService studentService;

    /*
    * 添加操作
    * */
    @RequestMapping("add")
    @ResponseBody
    @IsLogin
    public ResultInfo addStudent(HttpServletRequest request,Student student){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int uid = user.getUid();
        return studentService.addStudent(uid,student);
    }

    /*
    * 跳转添加视图
    * */
    @RequestMapping("addView")
    @IsLogin
    public String addView(){
        return "addView";
    }


    /*
    * 跳转主页
    * */
    @RequestMapping("main")
    @IsLogin
    public String findListStudent(Student student, Model model){
        PageList<Student> students = studentService.findStudent(student);
        model.addAttribute("students",students);
        model.addAttribute("pagenator",students.getPaginator());
        model.addAttribute("student",student);
        return "main";
    }

    /*
    * 删除操作
    * */
    @RequestMapping("delete/{id}")
    @IsLogin
    public String deleteStudent(@PathVariable Integer id,@PathVariable Integer uid){
        studentService.deleteStudent(id,uid);
        return "redirect:/student/main";
    }

    /*
    * 跳转编辑页面
    * */
    @RequestMapping("updateView/{id}")
    @IsLogin
    public String updateView(@PathVariable Integer id,Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        Student student = studentService.findStudentById(id,user.getUid());
        model.addAttribute("student",student);
        return "update";
    }


    /*
    * 编辑操作
    * */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateStudent(Student student, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        /*if(user == null){
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setCode(300);
            resultInfo.setMes("请先登录");
            return resultInfo;
        }*/
        return  studentService.updateStudent(student,user.getUid());
    }

}
