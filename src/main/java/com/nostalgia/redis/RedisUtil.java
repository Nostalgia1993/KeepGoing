package com.nostalgia.redis;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by zss on 2017/8/11.
 */
public class RedisUtil {

    private static final Logger LOGGER = LogManager.getLogger(RedisUtil.class);

    /*private static RedisTemplate redisTemplate = SpringContextHolder.getApplicationContext().getBean("redisTemplate", RedisTemplate.class);*/
    @Autowired
    private static RedisTemplate redisTemplate;

    public static Integer getRedisSerializerValue(String redisKey) {
        try {
            Integer execute = (Integer) redisTemplate.execute((RedisCallback<Integer>) redisConnection -> {
                byte[] bytes = redisConnection.get(redisKey.getBytes());
                if (null == bytes || bytes.length == 0) {
                    return null;
                }
                return Integer.parseInt(new String(bytes));
            });
            return execute;
        } catch (Exception e) {
            LOGGER.error("获取缓存key的值异常 redisKey={}",redisKey,e);
            return null;
        }
    }
    public static Long getRedisLongValue(String redisKey) {
        try {
            Long execute = (Long) redisTemplate.execute((RedisCallback<Long>) redisConnection -> {
                byte[] bytes = redisConnection.get(redisKey.getBytes());
                if (null == bytes || bytes.length == 0) {
                    return null;
                }
                return Long.parseLong(new String(bytes));
            });
            return execute;
        } catch (Exception e) {
            LOGGER.error("获取缓存key的值异常 redisKey={}",redisKey,e);
            return null;
        }
    }

    // 获取redis值
    private static List<Integer> getRedisValue(Set<String> allKeySet) {
        if (null == allKeySet || allKeySet.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> returnList = new ArrayList<>();
        for (String key : allKeySet) {
            returnList.add(RedisUtil.getRedisSerializerValue(key));
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return returnList;
    }

    // 获取redis值，批量查询
    public static List<Integer> getValueList(Set<String> allKeySet) {
        if (null == allKeySet || allKeySet.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<byte[]> keyList = new ArrayList<>();
        for (String allKey : allKeySet) {
            keyList.add(allKey.getBytes());
        }
        List<Integer> valueList = (List<Integer>) redisTemplate.execute(new RedisCallback<List<Integer>>() {
            @Override
            public List<Integer> doInRedis(RedisConnection connection) throws DataAccessException {
                List<byte[]> returnRedisValueByteList = new ArrayList<byte[]>();
                int size = keyList.size();
                // 分批查询，10个一组
                for (int i = 0; i <= size / 20; i++) {
                    int endIndex = (i + 1) * 20;
                    if (endIndex > size) {
                        endIndex = size;
                    }
                    List<byte[]> returnRedisKeyByteList = keyList.subList(i * 20, endIndex);
                    returnRedisValueByteList.addAll(connection.mGet(returnRedisKeyByteList.toArray(new byte[][]{})));
                    if (endIndex == size) {
                        break;
                    }
                }
                List<Integer> returnList = new ArrayList<Integer>();
                for (byte[] redisByte : returnRedisValueByteList) {
                    if (null == redisByte || redisByte.length == 0) {
                        returnList.add(null);
                    } else {
                        try {
                            returnList.add(Integer.parseInt(new String(redisByte)));
                        } catch (Exception e) {
                            returnList.add(null);
                        }
                    }
                }
                return returnList;
            }
        });
        return valueList;
    }


    /**
     * 获取redis中指定key的的过期时间。
     *
     * @param redisKey
     * @return 过期时间。单位：毫秒。如果key不存在，则返回-2；如果ttl不过期，则返回-1；
     */
    public static Long getRedisExpire(String redisKey) {
        if (StringUtils.isEmpty(redisKey)) {
            return -2L;
        }
        return redisTemplate.getExpire(redisKey, TimeUnit.MILLISECONDS);
    }

    /**
     * 设置redis中指定key的过期时间
     *
     * @param redisKey
     * @param timeout 超时时间
     * @param unit 超时时间的单位
     * @return
     */
    public static Boolean setRedisExpire(String redisKey, long timeout, TimeUnit unit) {
        if (StringUtils.isEmpty(redisKey)) {
            return false;
        }
        return redisTemplate.expire(redisKey, timeout, unit);
    }

    /**
     * 若设置redisKey的过期时间失败, 则重新设置
     * @param redisKey
     * @param timeout
     * @param unit
     * @param sum
     */
    public static Long incrementAndSetExpireFirstTime(RedisCache redisCache, String redisKey, long timeout, TimeUnit unit,long sum) {
        Long count = redisCache.incrementAndSetExpireFirstTime(redisKey,sum , timeout, TimeUnit.MILLISECONDS);
        if (getRedisExpire(redisKey) == -1L) {
            LOGGER.warn("设置redisKey的过期时间失败, 重新设置, redisKey={}", redisKey);
            setRedisExpire(redisKey, timeout, unit);
        }
        return count;
    }

}
