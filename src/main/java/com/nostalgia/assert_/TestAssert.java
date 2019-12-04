package com.nostalgia.assert_;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/12/4
 * @description 断言的使用
 */
public class TestAssert {

    @Test
    public void run(){
        try {
            assert 5>4: "断言1处错误";
            System.out.println("断言1正常");
            assert 4>5;
            System.out.println("断言2正常");
        } catch (Exception e) {
            System.out.println("Exception捕获到异常");
        } catch (Error e) {
            System.out.println("Error捕获到异常");
        }
    }



}
