package com.zj.test;

import java.util.*;

public class Test_2 {
    public static List u = new ArrayList<User>();
    public static User user;
    public static void main(String[] args){

       while(true) {
           System.out.println("请输入：1.注册   2.登录");
           Scanner sc = new Scanner(System.in);
           String s = sc.next();
           //注册
           if ("1".equals(s)) {
               System.out.println("请输入用户名");
               String userName = sc.next();

               user = new User(userName,null);

               Iterator it = u.iterator();
               if (it.hasNext()) {
                   User us = (User) it.next();
                   System.out.println("user---->"+u.toString());
                   System.out.println("flag---->"+u.contains(us));
                   if (!u.contains(us)) {
                       user.setUserName(userName);
                   } else {
                       System.out.println("用户名已存在");
                       return;
                   }
               }

               System.out.println("请输入密码");
               String userPass = sc.next();
               user.setUserPass(userPass);

               u.add(user);
           }
       }
    }
}
