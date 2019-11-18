package com.nostalgia.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class MyStream {

    public static ArrayList<String> list = new ArrayList();
    public static ArrayList<String> list1 = new ArrayList();
    public static ArrayList<UserEntity> userList = new ArrayList();
    static {
        list.add("aaa");
        list.add("bbbb");
        list.add("ccc");
        list.add("dd");
        list.add("e");
        list1.add("aaa1");
        list1.add("bbbb1");
        list1.add("ccc1");
        list1.add("dd1");
        list1.add("e1");
        userList.add(new UserEntity("1111","zhangsan"));
        userList.add(new UserEntity("2222","zhangsan"));
        userList.add(new UserEntity("2222","lisi"));
        userList.add(new UserEntity("3333","wangwu"));

    }

    @Test
    public void simple(){
        list.stream().forEach((string) ->{
            System.out.println(string);
        });

    }

    /**
     * filter将元素经过过滤条件筛选出新的stream数据,返回Stream<T>对象
     * 调用collect(Collectors.toList())方法可以返回过滤后的集合
     *
     */
    @Test
    public void filter(){
        Stream<UserEntity> userEntityStream = userList.stream().filter(user -> user.getId().equals("2222"));
        List<UserEntity> collect = userEntityStream.collect(Collectors.toList());
        collect.forEach(user -> System.out.println(user));

    }

    /**
     * map将原数据根据指定的操作转换为新的格式
     */
    @Test
    public void map(){
        userList.stream().map(user ->(user.getName()))
                .forEach(string ->System.out.println(string));
        System.out.println("==================================");
        Stream<String> distinct = userList.stream().map(user -> (user.getName())).distinct();
        System.out.println("==================================");
        List<String> newList = userList.stream().map(user -> (user.getName())).distinct().collect(Collectors.toList());
        System.out.println("newList:"+newList);
        System.out.println("==================================");
        userList.stream().map(user -> (user.getName())).distinct().forEach(string -> System.out.println(string));
        System.out.println("==================================");
        userList.stream().map(user -> (user.getName())).distinct().collect(Collectors.toList()).stream().forEach(string -> System.out.println(string));


    }

    @Test
    public void testMap(){
        List<String> collect = userList.stream().map(user -> user.getName()).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 将原有的stream摊平到新的stream中
     */
    @Test
    public void flatMap(){
        Stream<ArrayList<String>> stream = Stream.of(list, list1);
        stream.flatMap(item -> item.stream()).forEach(str -> System.out.println(str));
        System.out.println("=========================");
        Stream.of(list, list1).flatMap(item -> item.stream()).forEach(System.out::println);

    }

    @Test
    public void distict(){
        List<String> collect = userList.stream().map(user -> user.getId()).distinct().collect(Collectors.toList());
        collect.forEach(str -> System.out.println(str));
        System.out.println("=================");
        userList.stream().map(user -> user.getId()).collect(Collectors.toList()).forEach(str -> System.out.println(str));

    }


    @Test
    public void collect(){
        /*List<String> collect = list.stream().filter(str -> {
            return str.startsWith("a") || str.startsWith("b");
        }).collect(Collectors.toList());

        System.out.println(collect.toString());*/
        Map<String, List<UserEntity>> collect = userList.stream().collect(Collectors.groupingBy(UserEntity::getId, Collectors.toList()));
        collect.entrySet().forEach(entry -> System.out.println(entry.getKey()+":"+entry.getValue().toString()));

    }


}
