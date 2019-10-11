package com.nostalgia.json.fastJson;

/**
 * @author liunian
 * @createTime 2019/8/9
 * @description
 */
public class InnerBean {

    private String id;

    private String sex;

    public InnerBean() {}

    public InnerBean(String id, String sex) {
        this.id = id;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "InnerBean{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
