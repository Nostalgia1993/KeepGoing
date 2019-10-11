package com.nostalgia.date;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author liunian
 * @createTime 2019/8/21
 * @description
 */
public class BaseDomain implements Serializable {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
