package com.nostalgia.equals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liunian
 * @createTime 2019/11/9
 * @description
 */
public class TestCompareTo {


    public static void main(String[] args) {

        Person p1 = new Person("1","张三",22);
        Person p2 = new Person("1","李四",11);
        Person p3 = new Person("1","王五",33);
        Person p4 = new Person("1","赵六",22);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list);
        System.out.println(list);

     }
}
