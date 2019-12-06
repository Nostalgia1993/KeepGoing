package com.nostalgia.mock;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

/**
 * @author liunian
 * @createTime 2019/12/5
 * @description mock测试目的:1.验证方法被调用; 2.指定某个方法的返回值,或者指定某个动作
 */
public class TestMock {

    /**
     * 判断某个动作是否执行,每验证一个操作需要重新调用一次verify方法
     */
    @Test
    public void run(){
        List<String> mockList = Mockito.mock(List.class);
        mockList.add("1");
        mockList.add("2");
        Mockito.verify(mockList).add("1");
        Mockito.verify(mockList).add("2");

        System.out.println("mock判断成功...");
    }


    /**
     * 校验某个对象执行一个方法的次数,如果不传,默认为1
     * public static <T> T verify(T mock) {
     *     return MOCKITO_CORE.verify(mock, times(1));
     * }
     *  Mockito.atMost(n)最多
     *  Mockito.atLeast最少
     */
    @Test
    public void run2(){
        List<String> mockList = Mockito.mock(List.class);
        mockList.add("1");
        mockList.add("1");
        mockList.add("1");
        Mockito.verify(mockList,Mockito.atMost(3)).add("1");
        Mockito.verify(mockList,Mockito.atLeast(2)).add("1");
        System.out.println("mock判断成功...");
    }

    /**
     * 验证操作参数
     */
    @Test
    public void run3(){
        List<String> mockList = Mockito.mock(List.class);
        mockList.add("1");
        Mockito.verify(mockList).add(Mockito.eq("1"));
        Mockito.verify(mockList).add(Mockito.anyString());
        System.out.println("mock判断成功...");
    }

    /**
     * Mockito.when().thenReturn()方法待进一步了解
     */
    @Test
    public void run4(){
        User mockUser = Mockito.mock(User.class);
        Mockito.when(mockUser.singSong("ding ding dang")).thenReturn("ing ding");
        System.out.println("mock判断成功...");
    }

    @Test
    public void run5(){
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return null;
            }
        });
    }

}
