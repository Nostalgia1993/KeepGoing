package com.nostalgia.map;

/**
 * @author liunian
 * @createTime 2019/8/5
 * @description
 */
public enum RespFlagEnum {
    SUCCESS("S", "成功"),
    FAIL("F", "失败");

    private String code;
    private String desc;

    RespFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
