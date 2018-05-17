package com.zj.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

public class RedisUtil {
    public static Properties properties = new Properties();

    // 连接 redis 等待时间
    private int timeOut = 10000;

    // 可用连接实例的最大数目，默认值为8；
    // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
    private int maxTotal = 1024;

    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8
    private int maxIdle = 200;

    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
    private int maxWait = 10000;

    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
    private boolean testOnBorrow = true;

    // 连接池
    private JedisPool jedisPool = null;

    // 构造函数
    public RedisUtil() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            InputStream path = RedisUtil.class.getClassLoader().getResourceAsStream("redis1.properties");
            properties.load(path);
            String ip = properties.getProperty("ip");
            int port = Integer.parseInt(properties.getProperty("port"));
            String pwd = properties.getProperty("pwd");
            jedisPool = new JedisPool(config,ip,port);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 获取 Jedis 实例
    public Jedis getJedis() {
        if (jedisPool != null) {
            return jedisPool.getResource();
        }
        return null;
    }

    public static void main(String[] arg){
        RedisUtil r = new RedisUtil();
        Jedis s = r.getJedis();
        s.set("1","1");
        s.expire("1",1);
        System.out.println("1-->"+s.get("1"));

        try {
            Thread.sleep(100);
            System.out.println("2-->"+s.get("1"));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
