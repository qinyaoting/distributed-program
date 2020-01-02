package test36.datetime;


import org.joda.time.DateTime;

import java.text.DateFormat;
import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 3/31/18
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DateTimeUsage {

    public static void main(String[] args) {

        // 1. 今天的日期
        LocalDate today = LocalDate.now();
        System.out.println(today);      //2018-03-31

        // 2. 明天日期
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);   //2018-04-01

        // 3.获取当前的时间
        LocalTime now = LocalTime.now();
        System.out.println(now);        //21:01:10.366

        // 4.如果不想显示毫秒
        LocalTime time = now.withNano(0);
        System.out.println(time);       //21:02:19

        // 5.//查看当前的时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone);    //Asia/Shanghai

        // 6.比较两个日期之间相差几天
        LocalDate tod = LocalDate.now();
        LocalDate someDate = LocalDate.of(2018, 2, 10);
        Period period = Period.between(someDate, tod);
        System.out.println(period.getDays());       // 注意:不能跨月
        System.out.println(period.getMonths());
        System.out.println(someDate.until(tod, ChronoUnit.DAYS));   // 可以跨月

        // 7.格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate forr = LocalDate.parse("20181103",  formatter);
        System.out.println(forr);       //2018-11-03

        // 8.格式化时间
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY MM dd");
        System.out.println(formatter2.format(LocalDate.now())); //2018 03 31

        // 9. Date转为LocalDateTime
        Date date = new Date();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime2); //2018-03-31T21:20:22.187


        // 10.判断两个日期是否跨年
        LocalDate before = LocalDate.of(2017, 12, 22);
        LocalDate after = LocalDate.of(2018, 1, 2);
        System.out.println(before.getYear() == after.getYear());

        // 11. 判断离本年的一月一日还有几天
        LocalDate selectDate = LocalDate.of(2018, 7, 7);
        System.out.println(selectDate.getDayOfYear());

        // 12.
        // 给定日期,年月相同, 日期是某日
        System.out.println(selectDate.withDayOfMonth(10));
        // 年相同, 月是一月, 日是指定某日    注意:
        System.out.println(selectDate.withDayOfYear(10));
        // 给定日期,年日相同, 月是某月
        System.out.println(selectDate.withMonth(10));


        //ToDo
        // 2019-12-12 -> 2019-12-12 00:00:00


    }
}
