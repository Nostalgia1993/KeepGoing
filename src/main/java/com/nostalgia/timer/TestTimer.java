package com.nostalgia.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liunian
 * @createTime 2019/10/11
 * @description java实现定时任务,自定义类实现timerTask类并实现run方法,然后使用timer对象的schedule(TimerTask task, Date firstTime, long period)方法
 */
public class TestTimer {

    public static void main(String[] args) {

        TimerTask task1 = new MyTask("任务1");
        TimerTask task2 = new MyTask("任务2");

        Timer time = new Timer();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.SECOND,1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.SECOND,2);

        time.schedule(task1, calendar1.getTime(),1000);
        time.schedule(task2, calendar2.getTime(),2000);
    }


}
