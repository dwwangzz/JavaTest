package date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * @author: wangzz
 * @date: 2021年06月21日 11:40
 */

public class LocalDateDemo {

    /**
     * 创建LocalDate
     */
    @Test
    public void test1() {

        // 1当前日期 常用
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 2指定年月 日 方式 常用
        LocalDate ofDate = LocalDate.of(2018, 8, 8);
        System.out.println(ofDate);

        // 3使用Clock方式创建 不常用
        Clock clock = Clock.systemDefaultZone();
        LocalDate date = LocalDate.now(clock);
        System.out.println(date);

        // 2021年第100天
        LocalDate localDate2 = LocalDate.ofYearDay(2021, 100);
        System.out.println(localDate2);

        // 5
        LocalDate parse = LocalDate.parse("1999-09-09");
        System.out.println(parse);


        // 当前时间是本年 的第多少天
        int dayOfYear = localDate2.getDayOfYear();
        System.out.println(dayOfYear);
        // 当前时间是本月 的第多少天
        int dayOfMonth = localDate2.getDayOfMonth();
        System.out.println(dayOfMonth);

    }

    /**
     * 创建日期
     */
    public void test22() {
        // 创建时间
        LocalDate date =LocalDate.of(2019,9,9);
        // 获得年份
        date.getYear();
        System.out.println(date.getYear());
        // 获得一个月中的第几天
        date.getDayOfMonth();
        System.out.println(date.getDayOfMonth());
        // 获得星期
        date.getDayOfWeek();
        System.out.println(date.getDayOfWeek());
        // 获得一年中的第几天
        date.getDayOfYear();
        System.out.println(date.getDayOfYear());
        // 获得月份值
        date.getMonthValue();
        System.out.println(date.getMonthValue());
        // 获得月份长度
        date.lengthOfMonth();
        System.out.println(date.lengthOfMonth());
        // 是否是闰年
        date.isLeapYear();
        System.out.println(date.isLeapYear());


        // 创建时间
        LocalDate date2 = LocalDate.of(2019, 9, 27);
        // 获得年份
        date2.get(ChronoField.YEAR);
        System.out.println(date2.get(ChronoField.YEAR));
        // 获得月份
        date2.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(date2.get(ChronoField.MONTH_OF_YEAR));
        // 获得这个月中的第几天
        date2.get(ChronoField.DAY_OF_MONTH);
        System.out.println(date2.get(ChronoField.DAY_OF_MONTH));
        // 获得这个星期的第几天
        date2.get(ChronoField.DAY_OF_WEEK);
        System.out.println(date2.get(ChronoField.DAY_OF_WEEK));

    }


    /**
     * LocalDate
     * 获取年、月、日、星期几
     */
    @Test
    public void test2() {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

    }

    /**
     * 比较
     */
    @Test
    public void test21() {

        LocalDate date1 = LocalDate.of(2019, 10, 27);
        LocalDate date2 = LocalDate.of(2019, 10, 25);
        Period between = Period.between(date2, date1);
        System.out.println(between.getDays());

        LocalTime time1 = LocalTime.of(22, 50,20,20);
        LocalTime time2 = LocalTime.of(23, 10);
        Duration duration = Duration.between(time1, time2);
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        System.out.println(seconds);
        System.out.println(nano);

    }

    /**
     * LocalTime
     */
    @Test
    public void test3() {
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.parse("12:12:12");

        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getMinute();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
    }

    /**
     * LocalDateTime
     */
    @Test
    public void test4() {

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(12, 12, 12);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime1_2 = LocalDateTime.of(2019, 12, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);

        LocalDate localDate2 = localDateTime.toLocalDate();

        LocalTime localTime2 = localDateTime.toLocalTime();

    }

    /**
     * Instant
     * 获取秒数
     */
    public void test5() {

        Instant instant = Instant.now();
        // 获取秒数
        long currentSecond = instant.getEpochSecond();
        // 获取毫秒数
        long currentMilli = instant.toEpochMilli();

    }

    /**
     * 修改LocalDate、LocalTime、LocalDateTime、Instant
     */
    public void test6() {

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);

        // 增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        // 减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);

        // 通过with修改某些值
        //修改年为2019
        localDateTime = localDateTime.withYear(2020);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);

    }

    /**
     * 时间计算
     */
    @Test
    public void test7() {
        LocalDate localDate = LocalDate.now();

        //比如通过firstDayOfYear()返回了当前日期的第一天日期，还有很多方法这里不在举例说明
        LocalDate localDate1 = localDate.with(firstDayOfYear());
        LocalDate localDate1_2 = localDate.with(TemporalAdjusters.firstDayOfYear());

        LocalDate localDate2 = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));

    }

    /**
     * 格式化时间
     * DateTimeFormatter默认提供了多种格式化方式，如果默认提供的不能满足要求，可以通过DateTimeFormatter的ofPattern方法创建自定义格式化方式
     */
    @Test
    public void test8() {

        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);

    }

    /**
     * 解析时间
     */
    @Test
    public void test9() {
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);

    }

    /**
     * 时区偏移
     */
    @Test
    public void test10() {

        // 上海
        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
        ZoneId shanghai2 = ZoneId.of(ZoneId.SHORT_IDS.get("CTT"));
        LocalDate date = LocalDate.of(2019, 9, 9);
        System.out.println(date);
        // 设置时区
        ZonedDateTime zonedDateTime = date.atStartOfDay(shanghai);
        // 获得偏移
        ZoneOffset offset = zonedDateTime.getOffset();
        System.out.println(offset);//+08:00

        // TimeZone 转 ZoneId
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        String id = zoneId.getId();
        System.out.println(id);//Asia/Shanghai

        // 时区时间计算
        ZoneId zoneId2 = ZoneId.of("America/Chicago");
        Instant instant = Instant.now();
        // 上海时间 2019-10-27T23:51:27.168
        System.out.println(LocalDateTime.ofInstant(instant,ZoneId.of("Asia/Shanghai")));
        ZonedDateTime zonedDateTime2 = instant.atZone(zoneId2);
        ZoneOffset offset2 = zonedDateTime2.getOffset();
        // 美国芝加哥离上海时区差值 -05:00
        System.out.println(offset2);
        LocalDateTime localDateTime = zonedDateTime2.toLocalDateTime();
        // 芝加哥时间
        System.out.println(localDateTime);//2019-10-27T10:51:27.168
    }


}
