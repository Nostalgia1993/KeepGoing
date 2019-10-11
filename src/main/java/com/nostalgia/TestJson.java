package com.nostalgia;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TestJson {


    @Test
    public void run(){
        HashMap<String,String> map = new HashMap();
        map.put("aaa","111");
        map.put("bbb","222");
        String s = JSON.toJSONString(map);
        System.out.println(s);

    }

    @Test
    public void run1(){
        Map<String,String> map = (Map<String,String>)JSON.parse("{\"aaa\":\"111\",\"bbb\":\"222\"}");
        map.forEach((k,v) -> System.out.println(k+" : "+v));
    }


    @Test
    public void run2(){
        String origReqStr = "{\"hitType\":\"IDNO\",\"custName\":\"张三\",\"idNo\":320926195511175300,\"ip\":\"10.254.55.17\"}";
        Map<String, String> bizContent = (Map<String, String>) JSON.parse(origReqStr);
        Iterator<Map.Entry<String, String>> iterator = bizContent.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+" : "+next.getValue());
        }
    }


    @Test
    public void run3(){

        String c ="ccc";
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.hashCode() > b.hashCode() ? 1 : (a.hashCode() == b.hashCode() ? 0 : -1);
            }
        });
    }

    /**
     *
     */
    @Test
    public void run4(){
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        Collections.sort(list,(String a,String b)->{
            return a.hashCode() > b.hashCode() ? 1 : (a.hashCode() == b.hashCode() ? 0 : -1);
        } );
    }



    /**
     *  并行处理所需时间:606
     *  并行处理所需时间:586
     */
    @Test
    public void run5(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int i=0;i<n;i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime = System.currentTimeMillis();
        long count = list.stream().sorted().count();
        long endTime = System.currentTimeMillis();
        System.out.println("并行处理所需时间:"+(endTime-startTime));
    }

    /**
     *
     */
    @Test
    public void run11(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int i=0;i<n;i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime = System.currentTimeMillis();
        long count = list.stream().sorted().count();
        long endTime = System.currentTimeMillis();
        System.out.println("并行处理所需时间:"+(endTime-startTime));
    }

    /**
     * 343
     */
    @Test
    public void run6(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int i=0;i<n;i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime = System.currentTimeMillis();
        long count = list.parallelStream().sorted().count();
        long endTime = System.currentTimeMillis();
        System.out.println("并行处理所需时间:"+(endTime-startTime));
    }

    /**
     * stream().parallel()并行100次处理平均所需时间:107
     */
    @Test
    public void run7(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int j=0;j<n;j++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime,endTime;
        long count = 0l;
        for (int i=0;i<10;i++){
            startTime = System.nanoTime();
            list.stream().parallel().sorted().count();
            endTime = System.nanoTime();
            count += (endTime-startTime);
        }
        System.out.println("stream().parallel()并行100次处理平均所需时间:"+count/10);
    }

    /**
     * parallelStream并行100次处理平均所需时间:113
     */
    @Test
    public void run8(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int j=0;j<n;j++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime,endTime;
        long count = 0l;
        for (int i=0;i<10;i++){
            startTime = System.nanoTime();
            list.parallelStream().sorted().count();
            endTime = System.nanoTime();
            count += (endTime-startTime);
        }
        System.out.println("parallelStream并行100次处理平均所需时间:"+count/10);
    }

    /**
     *
     */
    @Test
    public void run9(){
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int j=0;j<n;j++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime,endTime;
        long count = 0l;
        for (int i=0;i<10;i++){
            startTime = System.nanoTime();
            list.stream().sorted().count();
            endTime = System.nanoTime();
            count += (endTime-startTime);
        }
        System.out.println("stream并行100次处理平均所需时间:"+count/10);
    }

    @Test
    public void run10(){
        BigDecimal divisor = new BigDecimal("1");
        BigDecimal dividend = new BigDecimal("8");
        System.out.println(divisor.divide(dividend,2, RoundingMode.DOWN) );
        System.out.println(divisor.divide(dividend,2, RoundingMode.CEILING) );
        System.out.println(divisor.divide(dividend,2, RoundingMode.HALF_UP) );


    }

    /**
     * 100次平均运行时间:纯stream()--16544 stream().parallel()运行时间--1610 parallelStream()运行时间--699
     * 100次平均运行时间:纯stream()--16966 stream().parallel()运行时间--917 parallelStream()运行时间--1150
     * 100次平均运行时间:纯stream()--26054 stream().parallel()运行时间--1373 parallelStream()运行时间--1103
     * 100次平均运行时间:纯stream()--20182 stream().parallel()运行时间--854 parallelStream()运行时间--950
     */
    @Test
    public void runAllTypes() {
        int n = 1000000;
        List<String> list = new ArrayList();
        for (int j=0;j<n;j++) {
            list.add(UUID.randomUUID().toString());
        }
        //stream
        long streanSum =0l,streanParallelSum=0l,parallelStreamSum=0l;
        long startTime,endTime;
        for (int i=0;i<100;i++){
            //stream
            startTime = System.nanoTime();
            list.stream().sorted();
            endTime = System.nanoTime();
            streanSum += (endTime-startTime);
            //streamParallel
            startTime = System.nanoTime();
            list.stream().parallel().sorted();
            endTime = System.nanoTime();
            streanParallelSum += (endTime-startTime);
            //parallelStream
            startTime = System.nanoTime();
            list.parallelStream().sorted();
            endTime = System.nanoTime();
            parallelStreamSum += (endTime-startTime);
        }
        System.out.println("100次平均运行时间:纯stream()--"+streanSum/100+" stream().parallel()运行时间--"
                +streanParallelSum/100+" parallelStream()运行时间--"+parallelStreamSum/100);
    }
}
