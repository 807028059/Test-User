package com.zj.directive;

import com.alibaba.fastjson.JSON;
import com.zj.model.Student;
import com.zj.model.User;
import com.zj.service.StudentService;
import com.zj.service.UserService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class StudentDirective extends BaseDirective{

    @Autowired
    private StudentService studentService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer limit = getParameter("limit", params, Integer.class);

        List<Student> students = studentService.findListStudent(limit);

        setVariable(env,body,"students",students);

    }
}
