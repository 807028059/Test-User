package com.zj.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zj.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    @Select("select a.* from student a,usertable b where a.uid=b.uid and limit #{limit}")
    PageList<Student> findListStudent(@Param(value = "limit") Integer limit);

    @Select("select * from student ")
    PageList<Student> findStudent(PageBounds pageBounds);


    @Select("select a.* from student a,usertable b where a.uid=b.uid and a.id=#{id}")
    Student findStudentById(@Param(value = "id") Integer id);

    @Update({"insert student(name,gender,age,uid) values(#{name},#{gender},#{age},#{uid})"})
    void addStudent(Student student);

    @Update({"UPDATE student set name=#{name},gender=#{gender},age=#{age} where id = #{id} and uid=#{uid}"})
    void updateStudent(Student student);

    @Delete("delete from student where id=#{id} and uid=#{uid}")
    void deleteStudent(@Param(value = "id") Integer id,@Param(value = "uid") Integer uid);
}
