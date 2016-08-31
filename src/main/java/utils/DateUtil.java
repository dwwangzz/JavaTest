package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author wangzz-a
 * @version $Id: DateUtil.java, v 0.1 2015年11月25日 下午2:23:50 wangzz-a Exp $
 */
public abstract class DateUtil {
	
	/** 私有构造函数 */
	private DateUtil(){}
	
    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple                  = "yyyy-MM-dd HH:mm:ss";
    
    /** 年月日时分秒  yyyyMMddHHmmss */
    public static final String dtLong                  = "yyyyMMddHHmmss";
    
    /** 年-月-日 小时:分钟 yyyy-MM-dd HH:mm */
    public static final String simpleFormat            = "yyyy-MM-dd HH:mm";
    
    /** 年月日时分 yyyyMMddHHmm */
    public static final String dtMiddle                = "yyyyMMddHHmm";
    
    /** 年-月-日 yyyy-MM-dd */
    public static final String dtSimple                = "yyyy-MM-dd";
    
    /** 年月日 yyyyMMdd */
    public static final String dtShort                 = "yyyyMMdd";
    
    /** 年-月  yyyy-MM */
    public static final String yMFormat 			   = "yyyy-MM";
    
    /** 年月  yyyyMM */
    public static final String yMShort			  	   = "yyyyMM";
    
    /** 时分秒 HH:mm:ss */
    public static final String hmsFormat               = "HH:mm:ss";
    
    /** 时分 HH:mm */
    public static final String hmFormat                = "HHmm";
    
    /** yyyy年MM月dd日 HH:mm:ss */
    public static final String dtSimpleChineseWithTime = "yyyy年MM月dd日 HH:mm:ss";
    
    /** yyyy年MM月dd日 */
    public static final String dtSimpleChinese         = "yyyy年MM月dd日";
    
    public static final String WEEK                    ="EEEE";
    public static final String YEAR                    ="YEAR";
    public static final String MONTH                   ="MONTH";
    public static final String DAY                     ="DAY";
    public static final String QUARTER                 ="QUARTER";
    
    /** 
     * 获取日期格式化工具类
     * @author wangzz-a
     * @param format 日期格式
     * @return DateFormat
     * @date 2015年11月26日 上午9:52:38 
     */
    public static final DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /** 
     * 日期--->字符串<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     * @author wangzz-a
     * @param date 日期
     * @return String 日期的字符串表现形式
     * @date 2015年11月26日 上午9:53:11 
     */
    public static final String dateToStr(Date date) {
        return getFormat(simple).format(date);
    }
    
    /** 
     * 日期--->字符串
     * @author wangzz-a
     * @param date 日期
     * @param format 日期格式
     * @return String 日期的字符串表现形式
     * @date 2015年11月26日 上午9:54:12 
     */
    public static final String dateToStr(Date date, String format) {
    	return getFormat(format).format(date);
    }
    
    /** 
     * 字符串--->日期
     * @author wangzz-a
     * @param strDate 日期字符
     * @param format 日期字符的格式
     * @return java.util.Date
     * @throws ParseException
     * @date 2015年11月26日 上午9:30:11 
     */
    public static final Date strToDate(String strDate,String format) throws ParseException {
    	if (strDate == null||format==null) {
            return null;
    	}
        try {
			return getFormat(format).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("strDate:"+strDate+" format:"+format, 106);
		}
    }
    
    /** 
     * 时间戳--->java.util.Date
     * @author wangzz-a
     * @param currentTime 时间戳
     * @return java.util.Date
     * @date 2015年11月26日 上午9:56:02 
     */
    public static Date currentTimeToUtilDate(long currentTime){
    	return new Date(currentTime);
    }
    /** 
     * 时间戳--->java.sql.Date
     * @author wangzz-a
     * @param currentTime 时间戳
     * @return java.sql.Date
     * @date 2015年11月26日 上午9:56:45 
     */
    public static java.sql.Date currentTimeToSqlDate(long currentTime){
    	return new java.sql.Date(currentTime);
    }
    /** 
     * 时间戳--->Timestamp
     * @author wangzz-a
     * @param currentTime 时间戳
     * @return Timestamp
     * @date 2015年11月26日 上午9:57:16 
     */
    public static Timestamp currentTimeToTimestamp(long currentTime){
    	return new Timestamp(currentTime);
    }
    
    /** 
     * java.util.Date--->java.sql.Date
     * @author wangzz-a
     * @param java.util.Date 日期
     * @return java.sql.Date
     * @date 2015年11月26日 上午9:57:47 
     */
    public static java.sql.Date utilDateToSqlDate(Date date){
    	return new java.sql.Date(date.getTime());
    }
    /** 
     * java.util.Date--->Timestamp
     * @author wangzz-a
     * @param java.util.Date 日期
     * @return Timestamp
     * @date 2015年11月26日 上午9:59:01 
     */
    public static Timestamp utilDateToTimestamp(Date date){
    	return new Timestamp(date.getTime());
    }
    
    /** 
     * java.sql.Date--->java.util.Date
     * @author wangzz-a
     * @param java.sql.Date 日期
     * @return java.util.Date
     * @date 2015年11月26日 上午9:59:34 
     */
    public static Date sqlDateToUtilDate(java.sql.Date date){
    	return new Date(date.getTime());
    }
    /** 
     * java.sql.Date--->Timestamp
     * @author wangzz-a
     * @param java.sql.Date 日期
     * @return Timestamp
     * @date 2015年11月26日 上午10:00:11 
     */
    public static Timestamp sqlDateToTimestamp(java.sql.Date date){
    	return new Timestamp(date.getTime());
    }
    
    /** 
     * 当前所属年份是否为闰年
     * @author wangzz-a
     * @return boolean
     * @date 2015年11月26日 上午10:00:50 
     */
    public static final boolean isLeapYear() {
    	Calendar c = Calendar.getInstance();
    	return isLeapYear(c.get(Calendar.YEAR));
    }
    
    /** 
     * 传入日期是否为闰年
     * @author wangzz-a
     * @param date 日期
     * @return boolean
     * @date 2015年11月26日 上午10:01:48 
     */
    public static final boolean isLeapYear(Date date) {
    	if(date==null)
    		return false;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
    	return isLeapYear(c.get(Calendar.YEAR));
    }
    
    /** 
     * 传入年份是否为闰年
     * @author wangzz-a
     * @param year 年
     * @return boolean
     * @date 2015年11月26日 上午10:02:24 
     */
    public static final boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
	/** 
     * 计算两个日期相差的天数
	 * @author wangzz-a
	 * @param date1
	 * @param date2
	 * @return long
	 * @date 2015年11月26日 上午10:03:08 
	 */
	public static long getOffsetDays(Date date1, Date date2) {
		
		if (date1 == null || date2 == null) {
			throw new IllegalArgumentException("The date must not be null");
		}

		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		c1.set(Calendar.HOUR_OF_DAY,0);
		c1.set(Calendar.MINUTE,0);
		c1.set(Calendar.SECOND,0);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.HOUR_OF_DAY,0);
		c2.set(Calendar.MINUTE,0);
		c2.set(Calendar.SECOND,0);

		return Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 根据类别加减日期（年、月、日）
	 * @author wangzz-a
	 * @param date 日期
	 * @param field （DateUtil.YEAR; DateUtil.MONTH; DateUtil.DAY;） 
	 * @param index 需要加减的天数，可以为负数，负数为减
     * @return Date
     * @date 2015年11月26日 上午10:04:05 
	 */
    public static final Date addField(Date date, String field, int index){
    	if(date==null||field==null)
    		return date;
    	if(YEAR.equals(field))
    		return addYear(date, index);
    	if(MONTH.equals(field))
    		return addMonth(date, index);
    	if(DAY.equals(field))
    		return addDay(date, index);
		return date;
    }
    
	/** 
	 * 加减年
	 * @author wangzz-a
	 * @param date 日期
	 * @param year 需要加减的年数
	 * @return Date
	 * @date 2015年11月26日 上午10:04:50 
	 */
	public static final Date addYear(Date date, int year) {
		if(date==null)
			return date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}
	
	/**
	 * 加减月份
	 * @author wangzz-a
	 * @param date 日期
	 * @param month 需要加减的月数
	 * @return Date
	 * @date 2015年11月26日 上午10:04:50 
	 */
	public static final Date addMonth(Date date, int month) {
		if(date==null)
			return date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}
	
    /**
     * 加减天数
	 * @author wangzz-a
	 * @param date 日期
	 * @param days 需要加减的天数
	 * @return Date
	 * @date 2015年11月26日 上午10:04:50 
     */
    public static final Date addDay(Date date, int days) {
		if(date==null)
			return date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

	/** 
	 * 根据传入类型 获取当前时间所属的年、月份、季度等
	 * @author wangzz-a
	 * @param field 传入类型（YEAR，MONTH，DAY，QUARTER）
	 * @return int
	 * @date 2015年11月26日 上午10:07:58 
	 */
	public static int getField(String field){
		Calendar cld = Calendar.getInstance();
		if(YEAR.equals(field)){
			return cld.get(Calendar.YEAR);
		}
		if(MONTH.equals(field)){
			return cld.get(Calendar.MONTH) + 1;
		}
		if(DAY.equals(field)){
			return 	cld.get(Calendar.DAY_OF_MONTH);
		}
		if(QUARTER.equals(field)){
			return (cld.get(Calendar.MONTH)/3)+1;
		}
		return 0;
	}

	/** 
	 * 获取传入日期和类别所属的年、月份、季度等
	 * @author wangzz-a
	 * @param date 日期
	 * @param field 传入类型（YEAR，MONTH，DAY，QUARTER）
	 * @return int
	 * @date 2015年11月26日 上午10:10:46 
	 */
	public static int getField(Date date, String field){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		if(YEAR.equals(field)){
			return cld.get(Calendar.YEAR);
		}
		if(MONTH.equals(field)){
			return cld.get(Calendar.MONTH) + 1;
		}
		if(DAY.equals(field)){
			return 	cld.get(Calendar.DAY_OF_MONTH);
		}
		if(QUARTER.equals(field)){
			return (cld.get(Calendar.MONTH)/3)+1;
		}
		return 0;
	}

	/** 
	 * 当前日期月份的最大天数
	 * @author wangzz-a
	 * @return int
	 * @date 2015年11月26日 上午10:11:56 
	 */
	public static int getMaxDay() {
		int maxDay = 0;
		Calendar calendar = Calendar.getInstance();
		maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}

	/** 
	 * 传入日期月份的最大天数
	 * @author wangzz-a
	 * @param date 日期
	 * @return int
	 * @date 2015年11月26日 上午10:12:17 
	 */
	public static int getMaxDay(Date date) {
		int maxDay = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}

	/** 
	 * 获取某年某月的天数
	 * @author wangzz-a
	 * @param year 年
	 * @param month 月
	 * @return int
	 * @date 2015年11月26日 上午10:12:52 
	 */
	public static int getMaxDay(int year,int month) {
		int maxDay = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month - 1,1);
        maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}

	/** 
	 * 根据时间戳计算总时长
	 * @author wangzz-a
	 * @param millisecond
	 * @return String
	 * @date 2015年11月26日 上午10:13:22 
	 */
	public static String getDuration(long millisecond){
		
		long hour = 0;
		long minute = 0;
		long second = 0;
		String hourUnit = "小时";
		String minuteUnit = "分钟";
		String secondUnit = "秒";
		String millisecondUnit = "毫秒";
		if(millisecond<0)
			return "0秒";
		if(millisecond<1000)
			return millisecond+millisecondUnit;
		second = millisecond/1000;
		StringBuilder sb = new StringBuilder();
		
		if(second>=3600){
			hour = second/3600;
			second = second%3600;
			sb.append(hour+hourUnit);
		}
		if(second>=60){
			minute = second/60;
			second = second%60;
			sb.append(minute+minuteUnit);
		}
		sb.append(second+secondUnit);
		return sb.toString();
	}
	
	public static void main(String[] args) throws ParseException {
		DateFormat format = getFormat(simple);
		Calendar c = Calendar.getInstance();
		System.out.println(format.format(c.getTime()));
		
		//测试1
		String dateToStr = dateToStr(c.getTime());
		System.out.println("dateToStr:"+dateToStr);
		//测试2
		dateToStr = dateToStr(c.getTime(),dtSimpleChineseWithTime);
		System.out.println("dateToStr:"+dateToStr);
		//测试3
		Date date = strToDate("20121212",dtShort);
		System.out.println("strToDate:"+date);
		//测试4
		date = currentTimeToUtilDate(1448443787750l);
		System.out.println("currentTimeToUtilDate:"+date);
		System.out.println(currentTimeToSqlDate(1448443787750l));
		System.out.println(currentTimeToTimestamp(1448443787750l));
		//测试5
		System.out.println("isLeapYear:"+isLeapYear());
		System.out.println("isLeapYear:"+isLeapYear(strToDate("20121212",dtShort)));
		System.out.println("isLeapYear:"+isLeapYear(2008));
		
		//测试6
		System.out.println("addField:"+dateToStr(date));
		date = addField(date, YEAR, -1);
		date = addField(date, MONTH, -1);
		date = addField(date, DAY, -1);
		System.out.println("addField:"+dateToStr(date));
		date = addYear(date, -1);
		System.out.println("addYear:"+dateToStr(date));
		date = addMonth(date, -1);
		System.out.println("addMonth:"+dateToStr(date));
		date = addDay(date, -1);
		System.out.println("addDay:"+dateToStr(date));
		
		//测试7
		System.out.println("getField:"+getField(YEAR));
		System.out.println("getField:"+getField(MONTH));
		System.out.println("getField:"+getField(DAY));
		System.out.println("getField:"+getField(QUARTER));
		System.out.println("getField:"+getField(date,YEAR));
		System.out.println("getField:"+getField(date,MONTH));
		System.out.println("getField:"+getField(date,DAY));
		System.out.println("getField:"+getField(date,QUARTER));
		
		//测试8
		System.out.println("getMaxDay:"+getMaxDay(strToDate("201202",yMShort)));
		System.out.println("getMaxDay:"+getMaxDay(2012,3));
		
		//测试9
		System.out.println("getDuration:"+getDuration(122222));
		
        
	}
	
}
