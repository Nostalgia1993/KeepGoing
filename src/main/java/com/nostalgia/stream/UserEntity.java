package com.nostalgia.stream;

/**
 * @author liunian
 * @createTime 2019/8/8
 * @description
 */
public class UserEntity {

    private String id;

    private String name;

    public UserEntity() {
    }

    public UserEntity(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
