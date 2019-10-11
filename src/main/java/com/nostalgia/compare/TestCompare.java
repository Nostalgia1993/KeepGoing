package com.nostalgia.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liunian
 * @createTime 2019/8/23
 * @description
 */
public class TestCompare {


    @Test
    public void run(){

        CompareEntity entity1 = new CompareEntity(1,2);
        CompareEntity entity2 = new CompareEntity(2,4);
        CompareEntity entity3 = new CompareEntity(3,1);
        CompareEntity entity4 = new CompareEntity(4,3);
        CompareEntity entity5 = new CompareEntity(5,4);
        List<CompareEntity> list = new ArrayList();
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        Collections.sort(list);
        list.stream().forEach(entity -> System.out.println(entity));
    }

}
