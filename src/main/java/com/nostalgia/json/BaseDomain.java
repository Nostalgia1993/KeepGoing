package com.nostalgia.json;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by huangjianting-ira on 2016/4/12.
 */
public class BaseDomain implements Serializable {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
