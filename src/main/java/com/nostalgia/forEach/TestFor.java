package com.nostalgia.forEach;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liunian
 * @createTime 2019/11/11
 * @description 返回该数组内重复的元素,返回结果为一个数组,包含的元素为重复的第一个索引的位置以及重复的个数
 */
public class TestFor {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);

        List<IndexClass> indexList = getIndexList(list);
        System.out.println(indexList);


    }


    public static List<IndexClass> getIndexList(List<Integer> list){
        List<IndexClass> response = new ArrayList<>();
        int sum = 0;
        int j = 0;
        for (int i = 0;i<list.size()-1;i=j){
            System.out.println("i:"+i+"  j:"+j);
            inner:
            for (j=i+1;j<list.size();j++){
                System.out.println("i:"+i+"  j:"+j);
                if(list.get(i) != list.get(j)){
                    if(j-i>1){
                        IndexClass indexClass = new IndexClass(i,j-i);
                        response.add(indexClass);
                    }
                    break inner;
                }else if (j == list.size()-1){
                    IndexClass indexClass = new IndexClass(i,j-i+1);
                    response.add(indexClass);
                }
            }
        }
        return response;
    }




   public static class IndexClass{

       private Integer index;
       private Integer sum;

       public IndexClass() {
       }

       public IndexClass(Integer index, Integer sum) {
           this.index = index;
           this.sum = sum;
       }

       public Integer getIndex() {
           return index;
       }

       public IndexClass setIndex(Integer index) {
           this.index = index;
           return this;
       }

       public Integer getSum() {
           return sum;
       }

       public IndexClass setSum(Integer sum) {
           this.sum = sum;
           return this;
       }

       @Override
       public String toString() {
           return "IndexClass{" +
                   "index=" + index +
                   ", sum=" + sum +
                   '}';
       }
   }
}
