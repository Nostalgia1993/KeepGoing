package com.nostalgia.date;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author liunian
 * @createTime 2019/8/16
 * @description
 */
public class TestDate {

    @Test
    public void run() throws Exception{
        System.out.println(isInRuntime("16:00:00","18:00:00"));
        System.out.println(isInRuntime("16:00:00","16:30:00"));
        System.out.println(isInRuntime("17:00:00","17:30:00"));
    }

    private boolean isInRuntime(String start,String end) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String str = format1.format(new Date());
        Date effective = format2.parse(str+" "+start);
        Date expire = format2.parse(str+" "+end);
        Date current = new Date();
        System.out.println("生效时间:"+effective+"失效时间:"+expire+"当前时间:"+current);
        if(current.before(expire) && current.after(effective)){
            return true;
        }
        return false;
    }

    @Test
    public void run1() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String format1 = format.format(new Date());
        System.out.println(format1);

    }

    @Test
    public void run2() throws Exception{
        RejectPartnerOutput rejectPartnerOutput = new RejectPartnerOutput();
        rejectPartnerOutput.setDateEffective("12:00:00");
        rejectPartnerOutput.setDateExpire("13:00:00");
        if(isInRuntime(rejectPartnerOutput)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }


    /**
     * 判断是否再生效时间内
     * @param rejectPartnerOutput
     * @return
     * @throws ParseException
     */
    private boolean isInRuntime(RejectPartnerOutput rejectPartnerOutput) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        Date current = new Date();
        String today = format1.format(current);
        String dateEffective = rejectPartnerOutput.getDateEffective();
        String dateExpire = rejectPartnerOutput.getDateExpire();
        //生效时间或失效时间为空则判断不在时间内
        if(StringUtils.isNotEmpty(dateEffective) && StringUtils.isNotEmpty(dateExpire)){
            Date effective = format2.parse(today+" "+rejectPartnerOutput.getDateEffective());
            Date expire = format2.parse(today+" "+rejectPartnerOutput.getDateExpire());
            if(current.after(effective) && current.before(expire)){
                format1 = null;
                format2 = null;
                return true;
            }
        }else if(StringUtils.isEmpty(dateEffective) && StringUtils.isEmpty(dateExpire)){
            format1 = null;
            format2 = null;
            return true;
        }
        format1 = null;
        format2 = null;
        return false;
    }


    /**
     * 计算当前时间和今天23:59:59秒的毫秒值差
     * @return
     */
    private long getTodayRemainTime(){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTime().getTime();
        System.out.println(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        long time = calendar.getTime().getTime();
        System.out.println(calendar.getTime());
        return time-now;
    }

    @Test
    public void run3() throws Exception{
        long todayRemainTime = getTodayRemainTime();
        System.out.println(todayRemainTime);


    }

    @Test
    public void run4() throws Exception{
        Object o = null;
        System.out.println(String.valueOf(o));
    }

    @Test
    public void run5() throws Exception{
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println(date);
        DateFormat formate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(formate.format(date));
    }


    @Test
    public void run6() throws Exception{
        long time = System.currentTimeMillis();
        int timestamp = (int)time;
        System.out.println(time);
        System.out.println(timestamp);
    }
}
