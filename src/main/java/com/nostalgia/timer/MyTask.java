package com.nostalgia.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liunian
 * @createTime 2019/10/11
 * @description
 */
public class MyTask extends TimerTask {

    private String name;


    public MyTask() {
    }

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("线程"+this.name+"于"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime())+"在执行...");
    }
}
