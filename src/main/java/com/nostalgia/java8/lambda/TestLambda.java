package com.nostalgia.java8.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author liunian
 * @createTime 2019/9/16
 * @description
 */
public class TestLambda {


    @Test
    public void run(){

        List<Student> list = new ArrayList();
        list.add(new Student("1",33));
        list.add(new Student("2",44));
        list.add(new Student("3",66));
        list.add(new Student("4",55));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });
        System.out.println(list);
    }


    @Test
    public void run1(){

        List<Student> list = new ArrayList();
        list.add(new Student("1",33));
        list.add(new Student("2",44));
        list.add(new Student("3",66));
        list.add(new Student("4",55));
        Collections.sort(list,(Student s1,Student s2) ->{
            return s2.getScore().compareTo(s1.getScore());
        });
        System.out.println(list);
    }

    /**
     * 只有一行{}可以省略?
     */
    @Test
    public void run2(){
        List<Student> list = new ArrayList();
        list.add(new Student("1",33));
        list.add(new Student("2",44));
        list.add(new Student("3",66));
        list.add(new Student("4",55));
        Collections.sort(list,(Student s1,Student s2) -> s2.getScore().compareTo(s1.getScore()));
        System.out.println(list);
    }

    /**
     * 直接使用List的sort方法
     * @Since jdk1.8
     */
    @Test
    public void run3(){
        List<Student> list = new ArrayList();
        list.add(new Student("1",33));
        list.add(new Student("2",44));
        list.add(new Student("3",66));
        list.add(new Student("4",55));
        Comparator<Student> comparator = (Student s1, Student s2) -> s2.getScore().compareTo(s1.getScore());
        list.sort(comparator);
        System.out.println(list);
    }

    @Test
    public void run4(){
        Consumer<String> consumer = (str) -> System.out.println(str);
        Function<String,String> function = (str) -> str.toUpperCase();
        List<String> list = Arrays.asList("a","f2","fjei");
        list.forEach(consumer);
        list.stream().map(function).forEach(consumer);
    }

    @Test
    public void run5(){
        /*Consumer<String> consumer = Integer :: toString;
        List<String> list = Arrays.asList("1","22","33,5");
        list.stream().forEach(consumer);*/
    }


}
