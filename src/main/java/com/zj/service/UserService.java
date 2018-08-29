package com.zj.service;

import com.zj.dao.UserDao;
import com.zj.model.User;
import com.zj.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserDao userDao;
    private Logger log = Logger.getLogger(UserService.class);
    RedisUtil r = new RedisUtil();

    public User login(User user,String id) {
        log.info("用户登录："+user);
        return userDao.login(user);
    }
}