package com.zj.dao;

import com.zj.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from usertable where userName =#{userName} and userPassword =#{userPassword}")
    public User login(User user);

    /*测试*/
    List<User> test();
}