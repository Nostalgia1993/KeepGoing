package com.nostalgia.random;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author liunian
 * @createTime 2019/9/6
 * @description
 */
public class TestRandom {

    @Test
    public void run(){
        Random random = new Random();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<100;i++){
            int ran = random.nextInt(5);
            if(map.containsKey(ran)){
                map.put(ran,map.get(ran)+1);
            }else{
                map.put(ran,1);
            }

        }
        System.out.println(map.toString());

    }

}
