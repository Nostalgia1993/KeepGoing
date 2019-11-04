package com.nostalgia.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author liunian
 * @createTime 2019/10/8
 * @description
 */
public class TestJunit5 {

    @Test
    void run(){
        assertEquals(4,4,"is not the same number...");

    }

    @Test
    void run1() {
        UserEntity user1 = new UserEntity();
        user1.setId("111");
        user1.setName("aaa");

        UserEntity user2 = new UserEntity();
        user2.setId("222");
        user2.setName("bbb");

        List<UserEntity> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        Map<String, UserEntity> map = list.stream().collect(Collectors.toMap(UserEntity::getId, Function.identity(), (key1, key2) -> key2));


        for (Object str : map.keySet()) {
            System.out.println(str.toString() + "==" + map.get(str.toString()));

        }
    }


}
