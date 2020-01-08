package test35.joda;

import org.joda.time.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.Duration;
import java.time.Period;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/14/17
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test1 {

    public static void main(String[] args) {

        //1, 获取每天的零点
        DateTime dt = new DateTime().withMillisOfDay(0);
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));

        //2017-09-14 00:00:00

        //2, 在每天的6:30处理一些东西
        DateTime dt2  =new DateTime().withHourOfDay(6).withMinuteOfHour(30).withSecondOfMinute(0);
        System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));

        //2017-09-14 06:30:00

        //在每年的8月的7号的6:30处理一些东西
        DateTime dt3 = new DateTime().withMonthOfYear(8).withDayOfMonth(7).withHourOfDay(6).withMinuteOfHour(30).withSecondOfMinute(0);
        System.out.println(dt3.toString("yyyy-MM-dd HH:mm:ss"));
        //2017-08-07 06:30:00

        //获取每个月的第一天和最后一天
        DateTime dt4 = new DateTime();
        System.out.println(dt4.dayOfMonth().withMinimumValue().dayOfMonth().get());
        System.out.println(dt4.dayOfMonth().withMaximumValue().dayOfMonth().get());

        //1
        //30

        //获取每天的零点的下一天零点
        DateTime dt5 = new DateTime().withMillisOfDay(0).plusDays(1);
        System.out.println(dt5.toString("yyyy-MM-dd HH:mm:ss"));

        //2017-09-15 00:00:00

        //获取日期差
        DateTime start = new DateTime(2017,9,12,12,20);
        DateTime end = new DateTime(2017,9,13,14,20);
        //Period period = new Period();

        System.out.println(Days.daysBetween(start,end).getDays());
        System.out.println(Hours.hoursBetween(start,end).getHours());
        System.out.println(Minutes.minutesBetween(start,end).getMinutes());     //可以是负数
        System.out.println(Seconds.secondsBetween(start,end).getSeconds());



        // 时分(字符串)转date "08:30"->Date

        // 20170912 12:20:01
        // 20170912 12:20:59 same minutes


        //TODO
        //获取这个月
        DateTime dt22 = new DateTime().dayOfMonth().withMinimumValue().withMillisOfDay(0);
        System.out.println(dt22.toString("yyyy-MM-dd HH:mm:ss"));

        long s1 = System.currentTimeMillis();
        long s2 = DateTimeUtils.currentTimeMillis();
        System.out.printf(String.format("%s - %s s1 same to s2", s1,s2));


    }


}
