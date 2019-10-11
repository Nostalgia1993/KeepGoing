package com.nostalgia.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @author liunian
 * @createTime 2019/8/6
 * @description
 */
public class TestRedis {

    @Resource
    private RedisCache redisCache;

    @Test
    public void run1(){
        System.out.println("redis初始化...");
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool pool = new JedisPool(poolConfig,"47.97.213.112",6379,2000,"admin123");
        Jedis jedis = pool.getResource();
        jedis.set("1111","1111");
        jedis.set("3333","3333");
    }

    @Test
    public void run2(){
    }

}
