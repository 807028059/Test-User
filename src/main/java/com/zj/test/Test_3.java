package com.zj.test;

import redis.clients.jedis.Jedis;

public class Test_3 {
    public static void main(String[] args){
        Jedis t = new Jedis("127.0.0.1",6379);
        t.auth("123456");
        //t.set("id","1");

        System.out.println(t.get("id"));
    }
}
