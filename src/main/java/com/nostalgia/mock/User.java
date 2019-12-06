package com.nostalgia.mock;

/**
 * @author liunian
 * @createTime 2019/12/5
 * @description
 */
public class User {

    private String id;

    private String name;

    public String singSong(String song){
        return "is singing the" + song;
    }



    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }


}
