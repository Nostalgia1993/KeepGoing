package com.nostalgia.future;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liunian
 * @createTime 2019/8/12
 * @description
 */
public class TestFuture {

    /**
     * callable被执行的两个方式之一:
     *      被线程池的submit()方法执行
     *
     * @throws Exception
     */



    @Test
    public void run() throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "返回结果";
            }
        };

        Future<String> future = executorService.submit(callable);

        String s = future.get();
        System.out.println(s);

    }

    /**
     * callable被执行的两个方式之二:
     *      FutureTask实现了future和callable接口
     *      new Thread(callable)
     */
    @Test
    public void run2() throws Exception{
        FutureTask<String> future = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "callable返回结果";
            }
        });
        Thread thread = new Thread(future);
        thread.start();
        String s = future.get(5,TimeUnit.SECONDS);
        System.out.println("start后:"+s);
    }

}
