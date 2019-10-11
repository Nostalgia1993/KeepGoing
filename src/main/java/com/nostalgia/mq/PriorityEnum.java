package com.nostalgia.mq;

/**
 *
 * Created by xiaoweiwei on 2017/1/18.
 */
public enum PriorityEnum {
    LOW(1,"低优先级"),
    MIDDLE(5,"中优先级"),
    HIGH(10,"高优先级");
    private int code;
    private String desc;

    PriorityEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
