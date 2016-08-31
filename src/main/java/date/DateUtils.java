package date;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	public static final String DF_SHORT_YF = "yy";
	public static final String DF_SHORT_YEAR = "yyyy";
	public static final String DF_SHORT_DATE = "yyyy-MM-dd";
	public static final String DF_LONG_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final String DF_SHORT_DATE2 = "yyyyMMdd";
	public static final String DF_LONG_DATE2 = "yyyyMMddHHmmssSSS";
	public static final String DF_LONG_DATE3 = "yyyyMMddHHmmss";
	public static final String DB_SHORT_DATE = "YYYY-MM-DD";
	public static final String DB_LONG_DATE = "YYYY-MM-DD HH:MI:SS";
	public static final String sqlSessionFactory = "sqlSessionFactory";
	
	public static final String DATE_MESSAGE = "您输入的日期是{0}，日期的正确格式应该是{1}(年-月-日)";
	public static final String DATE_ERRORCODE = "9999";//提醒信息的错误号
	/**
	 * 取当前年份，格式为：yy 。
	  * Title: getCurrentNf 
	  * Description: TODO
	  * Param @return
	  * Return String
	 */
	public static String getCurrentNf() {
		return new SimpleDateFormat(DF_SHORT_YF).format(Calendar.getInstance().getTime());
	}
	/**
	 * 取当前年份，格式为：yyyy 。
	  * Title: getCurrentNf 
	  * Description: TODO
	  * Param @return
	  * Return String
	 */
	public static String getCurrentYear() {
		return new SimpleDateFormat(DF_SHORT_YEAR).format(Calendar.getInstance().getTime());
	}
	/**
	 * 取当前日期时间 ，格式为：yyyy-MM-dd HH:mm:ss 。
	 * @return
	 */
	public static String getCurrentDateTime() {
		return new SimpleDateFormat(DF_LONG_DATE).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获取当前日期，格式为：yyyy-MM-dd。
	 * @return
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat(DF_SHORT_DATE).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 取当前日期时间 ，格式为：yyyyMMdd 。
	 * @return
	 */
	public static String getCurrentDateByShort2() {
		return new SimpleDateFormat(DF_SHORT_DATE2).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获取当前日期，格式为：yyyyMMddHHmmssSSS。
	 * @return
	 */
	public static String getCurrentDateByLong2() {
		return new SimpleDateFormat(DF_LONG_DATE2).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获取当前日期，格式为：yyyyMMddHHmmss。
	 * @return
	 */
	public static String getCurrentDateByLong3() {
		return new SimpleDateFormat(DF_LONG_DATE3).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获得当前时间的毫秒数
	 * @return
	 */
	public static String getCurrentTimeMillis(){
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 格式化短日期(yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatShortDate(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DF_SHORT_DATE).format(date);
		} else {
			return "";
		}
	}
	
	/**
	 * 格式化短日期(yyyyMMdd)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatShortDate2(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DF_SHORT_DATE2).format(date);
		} else {
			return "";
		}
	}

	/**
	 * 格式化长日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatLongDate(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DF_LONG_DATE).format(date);
		} else {
			return "";
		}
	}
	
	/**
	 * 格式化长日期(yyyyMMddHHmmssSSS)
	 * @param date
	 * @return
	 */
	public static String formatLongDate2(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DF_LONG_DATE2).format(date);
		} else {
			return "";
		}
	}

	/**
	 * 根据指定的格式格式化日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date != null) {
			return new SimpleDateFormat(format).format(date);
		} else {
			return "";
		}
	}

	/**
	 * 解析短日期(yyyy-MM-dd)
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date parseShortDate(String date) throws ParseException {
		if (date == null || date.trim().length() < 1) {
			return null;
		}
		return new SimpleDateFormat(DF_SHORT_DATE).parse(date);
	}
	
	/**
	 * 解析短日期(yyyyMMdd)
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date parseShortDate2(String date) throws ParseException {
		if (date == null || date.trim().length() < 1) {
			return null;
		}
		return new SimpleDateFormat(DF_SHORT_DATE2).parse(date);
	}

	/**
	 * 解析日期
	 * 
	 * @param date
	 *            日期字符串
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date, String format)
			throws ParseException {
		if (date == null || date.trim().length() < 1) {
			return null;
		}
		return new SimpleDateFormat(format).parse(date);
	}

	/**
	 * 解析长日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date parseLongDate(String date) throws ParseException {
		if (date == null || date.trim().length() < 1) {
			return null;
		}
		return new SimpleDateFormat(DF_LONG_DATE).parse(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param obj
	 * @return
	 */
	public static Date parseLongDate(Object obj) {
		try {
			return obj == null ? null : parseLongDate(obj.toString());
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * 得到当月第一天
	 * 
	 * @return
	 */
	public static Date getFirstDateOfThisMonth() {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		cal.clear();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);

		return cal.getTime();
	}

	/**
	 * 得到当月的下一个月的第一天
	 * 
	 * @return
	 */
	public static Date getFirstDateOfNextMonth() {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		cal.clear();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month + 1);
		cal.set(Calendar.DATE, 1);

		return cal.getTime();
	}

	/**
	 * 在当前日期基础上加/减一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date datePlusOneDay(Date date, int num) {
		
		Calendar cld = Calendar.getInstance();
		
		cld.setTime(date);
		cld.add(Calendar.DAY_OF_MONTH, num);
		
		return cld.getTime();
	}

	/**
	 * 在当前日期基础上加一天
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date datePlusOneDayByShort(String date) throws ParseException {
		
		Date temp = parseShortDate(date);
		
		return datePlusOneDay(temp, 1);
	}

	/**
	 * 在当前日期基础上加一天
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date datePlusOneDayByLong(String date) throws ParseException {
		
		Date temp = parseLongDate(date);
		
		return datePlusOneDay(temp, 1);
	}

	/**
	 * 在当前日期基础上减一天
	 * 
	 * @param date(yyyy-MM-dd)
	 * @return
	 * @throws ParseException
	 */
	public static Date dateMinusOneDayByShort(String date)
			throws ParseException {
		
		Date temp = parseShortDate(date);
		
		return datePlusOneDay(temp, -1);
	}

	/**
	 * 在当前日期基础上减一天
	 * 
	 * @param date(yyyy-MM-dd HH:mm:ss)
	 * @return
	 * @throws ParseException
	 */
	public static Date dateMinusOneDayByLong(String date) throws ParseException {
		
		Date temp = parseLongDate(date);
		
		return datePlusOneDay(temp, -1);
	}

	/**
	 * 讲日期（yyyy-MM-dd HH:mm:ss）格式化SQL日期，
	 * 
	 * @param obj
	 * @return
	 */
	public static java.sql.Date formatSqlLongDate(Object obj) {
		try {
			return obj == null || "".equals(obj) ? null : new java.sql.Date(
					parseLongDate(obj.toString()).getTime());
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * 将日期（yyyy-MM-dd）格式化SQL日期，
	 * 
	 * @param obj()
	 * @return
	 */
	public static java.sql.Date formatSqlShortDate(Object obj) {
		try {
			return obj == null || "".equals(obj) ? null : new java.sql.Date(
					parseShortDate(obj.toString()).getTime());
		} catch (ParseException e) {
			return null;
		}

	}
	
	/**
	 * 将日期格式化成SQL日期
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Date parseSqlDate(String date, String format)
			throws ParseException {
		
		if (date == null || date.trim().length() < 1) {
			return null;
		}
		
		Date d = new SimpleDateFormat(format).parse(date);
		
		return new java.sql.Date(d.getTime());
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPriviousDay(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		date = calendar.getTime();
		
		return date;
	}
	
	/**
	 *  校验日期格式
	 *  @param date日期字符串 可为空
	 *  @return boolean 是否为日期格式
	 */
	public static boolean isDate(String date){
		
		/*if(StringUtil.isEmpty(date)){
			return true;
		}*/
	    Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
	    Matcher m = p.matcher(date);
	    if(m.matches()){
	    	return true;
	    }
		return false;
	}
	
	/**
	 *  获取日期提示信息
	  * Title: getDateMessage
	  * @param inputDate 错误格式的日期
	  * @return String 提示信息
	 */
	public static String getDateMessage(String inputDate){
		Object[] inputArr = new Object[]{inputDate,DF_SHORT_DATE};
		return MessageFormat.format(DATE_MESSAGE, inputArr);
	}
	
	/**
	 *  计算两个日期差的天数
	  * Title: getDaysBetweenTwoDates 
	  * Description: TODO
	  * Param @return
	  * Return int
	 */
	public static long getDaysBetweenTwoDates(Date startDate,Date endDate){
		 Calendar startCal = Calendar.getInstance();
		 startCal.setTime(startDate);
		 
		 Calendar endCal = Calendar.getInstance();
		 endCal.setTime(endDate);
		
		long starttime = startCal.getTimeInMillis();
		long endtime = endCal.getTimeInMillis();
		
		long days = (endtime - starttime)/(1000 * 60 * 60 * 24);
		
		return days;
	}
	
	/**
	 *  把yyyyMMdd转换yyyy-mm-dd格式
	  * Title: transferShortDateStr 
	  * Description: TODO
	  * Param @param strDate
	  * Param @return
	  * Param @throws ParseException
	  * Return String
	 */
	public static String transferShortDateStr(String strDate) throws ParseException{
		return DateUtils.formatDate(DateUtils.parseShortDate2(strDate), DF_SHORT_DATE);
	}
	
	/**
	 *  把yyyy-mm-dd转换成yyyyMMdd
	  * Title: transferShortDateStr2 
	  * Description: TODO
	  * Param @param strDate
	  * Param @return
	  * Param @throws ParseException
	  * Return String
	 */
	public static String transferShortDateStr2(String strDate) throws ParseException{
		return DateUtils.formatDate(DateUtils.parseShortDate(strDate), DF_SHORT_DATE2);
	}
	
	/**
	 * 取到当前日期前N个月的第一天和最后一天
	  * Title: getFirstDay_LastDay 
	  * Description: TODO
	  * Param @param date  当前所要操作的日期
	  * Param @param ce  往前数第几个月
	  * Param @return
	  * Return Map
	 * @throws ParseException 
	 */
	public static Map getFirstDay_LastDay(String date, int ce) throws ParseException{
		Date opDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = Calendar.getInstance().getTime();
		Calendar calendar = Calendar.getInstance();
		if(date == null||date.equals("")){
			opDate = nowDate;
		}else{
			opDate = df.parse(date);
		}
		calendar.setTime(opDate);
		//减去传过来的月份数
		calendar.add(Calendar.MONTH, -ce);
		Date theDate = calendar.getTime();
		
		//求出N个月前的第一天
		GregorianCalendar gLast = (GregorianCalendar) Calendar.getInstance();
		gLast.setTime(theDate);
		gLast.set(Calendar.DAY_OF_MONTH,1);
		String firstDay = df.format(gLast.getTime());
		
		//求出N个月前的最后一天
		calendar.add(Calendar.MONTH, 1);//先加上一个月
		calendar.set(Calendar.DATE, 1);//设置日期为第一天
		calendar.add(Calendar.DATE, -1);//减去一天求得最后一天
		String lastDay = df.format(calendar.getTime());
		
		Map map = new HashMap();
		map.put("firstDay", firstDay);
		map.put("lastDay", lastDay);
		return map;
	}
	
	
	public static void main(String[] args) {
		long time = 12580000;
		System.out.println(getHourMinuteSecondBySecond(time));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date(time*1000));
		System.out.println(date);
		
		
		//String str = String.format("%tF %<tT", System.currentTimeMillis());
		String str = String.format("%tF %<tT",12580000);
		System.out.println(str);
	}
	
	/**
	 * 根据时间戳换成时分秒的时间
	 * @author wangzz-a
	 * @param second
	 * @return
	 * @date 2015年11月20日 上午11:06:56
	 */
	public static String getHourMinuteSecondBySecond(long millisecond){
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
}
