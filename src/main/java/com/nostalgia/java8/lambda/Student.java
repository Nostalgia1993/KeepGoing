package com.nostalgia.java8.lambda;

/**
 * @author liunian
 * @createTime 2019/9/16
 * @description
 */
public class Student {


    private String id;

    private Integer score;

    public Student(String id, Integer score) {
        this.id = id;
        this.score = score;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", score=" + score +
                '}';
    }
}
