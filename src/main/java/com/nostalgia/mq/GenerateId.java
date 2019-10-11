package com.nostalgia.mq;

import java.util.UUID;

/**
 * Created by xiaoweiwei on 2017/1/9.
 */
public class GenerateId {
    /**
     * UUID
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
