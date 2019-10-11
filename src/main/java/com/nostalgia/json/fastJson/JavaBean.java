package com.nostalgia.json.fastJson;

/**
 * @author liunian
 * @createTime 2019/8/9
 * @description
 */
public class JavaBean {

    private String id;

    private String name;

    private Integer sum;

    private InnerBean innerBean;

    public JavaBean() {}

    public JavaBean(String id, String name, Integer sum, InnerBean innerBean) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.innerBean = innerBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                ", innerBean=" + innerBean +
                '}';
    }
}
