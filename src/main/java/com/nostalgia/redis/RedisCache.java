package com.nostalgia.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存通用类
 * Created by huangjianting-ira on 2016/4/12.
 */
@Component
public class RedisCache {
    public final static long DEFAULT_TIMEOUT_METRICS = 30;
    private static final Logger logger = LoggerFactory
            .getLogger(RedisCache.class);
    @Resource
    private RedisTemplate redisTemplate;

    public void set(String prefix, String key, Object value, long seconds) {
        set(prefix + key, value, seconds, TimeUnit.SECONDS);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value, DEFAULT_TIMEOUT_METRICS, TimeUnit.DAYS);
    }

    public void set(String prefix, String key, String value) {
        set(prefix + key, value);
    }

    public void set(String key, Object value, long milliseconds) {
        set(key, value, milliseconds, TimeUnit.MILLISECONDS);
    }

    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public <T> T get(String prefix, String key) {
        return get(prefix + key);
    }

    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void remove(String key) {
        logger.warn("redis remove key:{}", key);
        redisTemplate.delete(key);
    }

    public void remove(Collection keys) {
        logger.warn("redis remove keys:{}", keys);
        redisTemplate.delete(keys);
    }

    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 由于底层操作限制，不保证原子操作，即可能出现增长成功，但设置超时失败的情况<br/>
     * 关键业务操作不可依赖此方式进行超时设置<br/>
     *
     * @param key     redis键
     * @param delta   增长步长
     * @param timeout 过期时间长度
     * @param unit    过期时间单位
     * @return 增长后结果
     */
    public Long incrementAndSetExpireFirstTime(String key, long delta, long timeout, TimeUnit unit) {
        Long count = redisTemplate.opsForValue().increment(key, delta);
        if (count == 1) {
            redisTemplate.expire(key, timeout, unit);
        }
        return count;
    }

    /**
     * 由于底层操作限制，不保证原子操作，即可能出现增长成功，但设置超时失败的情况<br/>
     * 关键业务操作不可依赖此方式进行超时设置<br/>
     *
     * @param key     redis键
     * @param delta   增长步长
     * @param timeout 过期时间长度
     * @param unit    过期时间单位
     * @return 增长后结果
     */
    public Long incrementAndSetExpireEveryTime(String key, long delta, long timeout, TimeUnit unit) {
        Long count = redisTemplate.opsForValue().increment(key, delta);
        redisTemplate.expire(key, timeout, unit);
        return count;
    }

    /**
     * 返回redis中存储的原始字符串值，不经过java反序列化<br/>
     * 例如：<br/>
     * 1. 普通set操作会将java对象进行序列化后，将字节数组存储到redis，对应的get操作则会取出字节数组，然后执行反序列化<br/>
     * 2. redis原生increment操作，实际存储在redis中的是原始类型，因此通过get方法获取后执行反序列化时会出错，对于此类原始类型，
     * 需要使用本方法获取字符串值，然后在业务代码中进行类型转换
     *
     * @param key
     * @return 原始字符串 或 key不存在时返回空字符串
     */
    public String getStringWithoutDeserialize(String key) {
        return redisTemplate.opsForValue().get(key, 0, -1);
    }

}