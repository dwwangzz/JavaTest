package date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间计算
 * 
 * @author wangzz-a
 * @version $Id: DateCalculate.java, v 0.1 2015年5月5日 下午2:35:56 wangzz-a Exp $
 */
public class DateCalculate {

	public static void main(String[] args) throws ParseException {
		System.out.println(new SimpleDateFormat("yyyyMM").format(new Date()) + "==========");
		// Timestamp time1 = new Timestamp(new Date().getTime());
		// Timestamp time2 = new Timestamp(System.currentTimeMillis());
		// 注意yyyy-MM-dd HH:mm:ss MM:月份; mm:分钟; hh:12小时制小时; HH:24小时制小时
		// Timestamp time3 = Timestamp.valueOf(new
		// SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));

		// Date date = new Date(2001,10,10);
		// String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
		// date = new SimpleDateFormat("yyyyMMdd").parse(str);
		// System.out.println(date);

		// 时间运算器
		Calendar cld = Calendar.getInstance();
		// 设置时间运算器的时间如果不设置，默认为当前时间
		// cld.setTime(date);
		int year = cld.get(Calendar.YEAR);
		int month = cld.get(Calendar.MONTH);
		int day = cld.get(Calendar.DAY_OF_MONTH);
		int hour = cld.get(Calendar.HOUR_OF_DAY);
		int minute = cld.get(Calendar.MINUTE);
		int second = cld.get(Calendar.SECOND);
		System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
		cld.set(year, month, day, 00, 00, 00);

		System.out.println(cld.getTimeInMillis());
		cld.add(Calendar.DAY_OF_MONTH, 1);

		System.out.println(cld.getTimeInMillis());
		System.out.println(cld.get(Calendar.DAY_OF_MONTH));

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cld.getTime()));

		// 获取当前时间
		// System.out.println(cld.getTime());

		// 当前时间加/减一天 +/-天数
		// cld.add(Calendar.DAY_OF_MONTH, 1);
		// System.out.println(cld.getTime());

		// 当前时间加/减一个月 +/-月数
		// cld.add(Calendar.MONTH, -1);
		// System.out.println(cld.getTime());

		// 三种获取时间戳的方式
		// System.out.println(System.currentTimeMillis()); //1430806718329
		// System.out.println(cld.getTimeInMillis()); //1430806718329
		// System.out.println(new Date().getTime());

		// getMaxDayByYearMonth(2015,2);
	}

	/**
	 * 根据年月获取当月最大日期，当月天数
	 * 
	 * @author wangzz-a
	 * @param year
	 * @param month
	 * @return
	 * @date 2015年7月11日 上午11:24:40
	 */
	public static int getMaxDayByYearMonth(int year, int month) {
		int maxDay = 0;
		int day = 1;
		/**
		 * 与其他语言环境敏感类一样，Calendar 提供了一个类方法 getInstance， 以获得此类型的一个通用的对象。Calendar 的
		 * getInstance 方法返回一 个 Calendar 对象，其日历字段已由当前日期和时间初始化：
		 */
		Calendar calendar = Calendar.getInstance();
		/**
		 * 实例化日历各个字段,这里的day为实例化使用
		 */
		calendar.set(year, month - 1, day);
		/**
		 * Calendar.Date:表示一个月中的某天 calendar.getActualMaximum(int
		 * field):返回指定日历字段可能拥有的最大值
		 */
		maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}

	/**
	 * org.apache.commons.lang.time.DateUtils
	 * @author wangzz-a
	 * @date 2015年11月25日 下午4:14:45
	 */
	@Test
	public void truncate() {
		
		Date date = new Date();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//2015-11-25 16:15:06
		System.out.println(dateFormat.format(date));
		//2015-11-25 16:00:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.HOUR_OF_DAY)));
		//2015-11-25 16:15:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.MINUTE)));
		//2015-11-25 16:15:06
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.SECOND)));
		//2015-11-25 00:00:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DAY_OF_MONTH)));
		//2015-11-25 00:00:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DATE)));
		//2015-11-01 00:00:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.MONTH)));
		//2015-01-01 00:00:00
		System.out.println(dateFormat.format(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.YEAR)));
		
		Calendar c = Calendar.getInstance();
		System.out.println(dateFormat.format(c.getTime()));
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		System.out.println(dateFormat.format(c.getTime()));
	}

}
