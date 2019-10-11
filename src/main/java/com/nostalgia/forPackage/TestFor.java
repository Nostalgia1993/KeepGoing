package com.nostalgia.forPackage;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/9/23
 * @description js和java中break都是跳出该层循环,内层循环跳出外层循环语法一致
 */
public class TestFor {


    /**
     * java多层循环中内层循环break回直接跳出该层循环
     */
    @Test
    public void run(){
        for (int i=0;i<6;i++){
            for (int j = 0;j<6;j++){
                System.out.println("进入内层循环...");
                if(j == 3){
                    break;
                }
                System.out.println("=====i:"+i+"=======j:"+j);
            }
        }
    }


    /**
     * continue指挥结束该次循环
     */
    @Test
    public void run1(){
        for (int i=0;i<5;i++){
            for (int j = 0;j<5;j++){
                System.out.println("进入内层循环...");
                if(j == 3){
                    continue;
                }
                System.out.println("=====i:"+i+"=======j:"+j);
            }

        }
    }

    /**
     * return会直接结束方法
     */
    @Test
    public void run2(){
        for (int i=0;i<5;i++){
            for (int j = 0;j<5;j++){
                System.out.println("进入内层循环...");
                if(j == 3){
                    return;
                }
                System.out.println("=====i:"+i+"=======j:"+j);
            }
        }
        System.out.println("方法结束");
    }

    /**
     * java多层循环中内层循环break回直接跳出该层循环
     */
    @Test
    public void run3(){
        for (int i=0;i<6;i++){
            for (int j = 0;j<6;j++){
                System.out.println("进入内层循环...");
                if(j == 3){
                    break;
                }
                System.out.println("=====i:"+i+"=======j:"+j);
            }
            if(i==3){
                break;
            }
        }
        System.out.println("方法结束");
    }

    /**
     * 如果需要在内层循环跳出外层循环,则需要使用label标签
     * 直接break 指定标签的循环
     */
    @Test
    public void run4(){
        outloop:
        for (int i=0;i<6;i++){
            for (int j = 0;j<6;j++){
                System.out.println("进入内层循环...");
                if(j == 3){
                    break outloop;
                }
                System.out.println("=====i:"+i+"=======j:"+j);
            }
        }
        System.out.println("方法结束");
    }


}
