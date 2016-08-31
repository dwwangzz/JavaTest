package utils;

import com.sun.xml.internal.ws.util.UtilException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

/**
 * 常用数字处理工具类<br>
 * 如：随机数、四舍五入、计算文件大小等
 * @author wangzz-a
 * @version $Id: MathUtil.java, v 0.1 2015年11月26日 上午10:22:38 wangzz-a Exp $
 */
public class MathUtil {

	private MathUtil(){}
	
	private static final double KB = 1024D;
	private static final double MB = 1024D * 1024D;
	private static final double GB = 1024D * 1024D * 1024D;
	private static final double TB = 1024D * 1024D * 1024D * 1024D;

	/**
	 * 根据文件字节数(B)计算文件大小
	 * @author wangzz-a
	 * @param size 文件字节数
	 * @return String 文件大小
	 * @date 2015年11月26日 上午11:14:33
	 */
	public static String getSize(long size) {
		if (size < 0) {
			throw new IllegalArgumentException("The size must >= 0");
		}
		String unit = "";
		if (size <= KB) {
			unit = size + "B";
		} else if (size <= MB) {
			unit = String.format("%.2f", size / KB) + "KB";
		} else if (size <= GB) {
			unit = String.format("%.2f", size / MB) + "MB";
		} else if (size <= TB) {
			unit = String.format("%.2f", size / GB) + "GB";
		} else {
			unit = "" + size;
		}
		return unit;
	}
	
	/** 
	 * 获取指定位数有效数字
	 * @author wangzz-a
	 * @param v 需要获取有效数字的值
	 * @param scale 获取几位有效数字
	 * @return double
	 * @date 2015年11月26日 上午11:18:24 
	 */
	public static double getValidNumber(double v, int scale){
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v,new MathContext(scale));
		return b.doubleValue();
	}
	
	/** 
	 * 四舍五入,小数点后保留几位
	 * @author wangzz-a
	 * @param v 需要四舍五入的值
	 * @param scale 小数点后面的位数
	 * @return double
	 * @date 2015年11月26日 上午11:11:55 
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/** 
	 * 生成min-max之间的随机数<br>
	 * 包括最大值和最小值
	 * @author wangzz-a
	 * @param min 最小值
	 * @param max 最大值
	 * @return int
	 * @date 2015年7月14日 下午12:55:11 
	 */
	public static int randomInt(int min,int max){
		if(min>max){
			throw new UtilException("min must little max");
		}
        Random random = new Random();
        int s = random.nextInt(max-min+1) + min;
        return s;
	}
	
}
