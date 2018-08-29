package com.zj.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zj.dao.StudentDao;
import com.zj.model.Student;
import com.zj.result.ResultInfo;
import com.zj.util.AssertUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;
    private static Logger log = Logger.getLogger(StudentService.class);

    public ResultInfo addStudent(Integer uid,Student student){
        ResultInfo resultInfo = new ResultInfo();
        log.info("addStudent入参："+resultInfo);
        if(student!=null){
            student.setUid(uid);
            studentDao.addStudent(student);
            resultInfo.setCode(200);
            resultInfo.setMes("添加成功");
            return resultInfo;
        }
        resultInfo.setCode(300);
        resultInfo.setMes("添加失败");
        return resultInfo;
    }

    public ResultInfo updateStudent(Student student,Integer uid){
        ResultInfo resultInfo = new ResultInfo();
        log.info("updateStudent入参："+student.toString());
        if(student!=null){
            student.setUid(uid);
            studentDao.updateStudent(student);
            resultInfo.setCode(200);
            resultInfo.setMes("添加成功");
            return resultInfo;
        }
        resultInfo.setCode(300);
        resultInfo.setMes("添加失败");
        return resultInfo;
    }


    public void deleteStudent(Integer id,Integer uid){
        AssertUtil.isNull(id);
        studentDao.deleteStudent(id,uid);
        log.info("deleteStudents删除ID："+id);
    }

    public Student findStudentById(Integer id,Integer uid){
        AssertUtil.isNull(id);
        log.info("findStudentById寻找ID："+id);
        return studentDao.findStudentById(id);
    }


    public PageList<Student> findListStudent(Integer limit){

        PageList<Student> students = studentDao.findListStudent(limit);

        return students;
    }

    public PageList<Student> findStudent(Student student){
        PageList<Student> students = studentDao.findStudent(student.buildPageBounds());
        return students;
    }
}












