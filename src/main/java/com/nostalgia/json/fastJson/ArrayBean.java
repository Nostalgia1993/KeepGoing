package com.nostalgia.json.fastJson;

import java.util.List;

/**
 * @author liunian
 * @createTime 2019/8/12
 * @description
 */
public class ArrayBean {

    private String id;

    private List<String> groups;

    private List<InnerBean> beans;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<InnerBean> getBeans() {
        return beans;
    }

    public void setBeans(List<InnerBean> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "ArrayBean{" +
                "id='" + id + '\'' +
                ", groups=" + groups +
                ", beans=" + beans +
                '}';
    }
}
