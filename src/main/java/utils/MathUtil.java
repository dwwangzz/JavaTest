package utils;

import com.sun.xml.internal.ws.util.UtilException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 常用数字处理工具类<br>
 * 如：随机数、四舍五入、计算文件大小等
 * @author wangzz-a
 * @version $Id: MathUtil.java, v 0.1 2015年11月26日 上午10:22:38 wangzz-a Exp $
 */
public class MathUtil {

    private MathUtil() {
    }

    private static final double KB = 1024D;
    private static final double MB = 1024D * 1024D;
    private static final double GB = 1024D * 1024D * 1024D;
    private static final double TB = 1024D * 1024D * 1024D * 1024D;

    /**
     * 格式化类型
     */
    interface Type {
        /**
         * 数值类型
         */
        String NUMBER = "NUMBER";
        /**
         * 百分比类型
         */
        String PERCENT = "PERCENT";
    }

    /**
     * 根据文件字节数(B)计算文件大小
     * @param size 文件字节数
     * @return String 文件大小
     * @author wangzz-a
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
     * @param v     需要获取有效数字的值
     * @param scale 获取几位有效数字
     * @return double
     * @author wangzz-a
     * @date 2015年11月26日 上午11:18:24
     */
    public static double getValidNumber(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v, new MathContext(scale));
        return b.doubleValue();
    }

    /**
     * 四舍五入,小数点后保留几位
     * @param v     需要四舍五入的值
     * @param scale 小数点后面的位数
     * @return double
     * @author wangzz-a
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
     * @param min 最小值
     * @param max 最大值
     * @return int
     * @author wangzz-a
     * @date 2015年7月14日 下午12:55:11
     */
    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new UtilException("min must little max");
        }
        Random random = new Random();
        int s = random.nextInt(max - min + 1) + min;
        return s;
    }

    /**
     * 秒转成小时,保留两位小数
     * @param second
     * @author wangzz-a
     * @date 2016年10月26日17:18:41
     */
    public static double secondToHour(double second) {
        if (second <= 0) {
            throw new UtilException("second must greater than zero");
        }
        double result = 0;
        if (second > 3600) {
            int hour = (int) (second / 3600);
            result += hour;
            second = second % 3600;
        }
        result += second / 3600;
        result = Double.parseDouble(String.format("%.2f", result));
        return result;
    }

    /**
     * 格式化数字，无精度问题【推荐使用】
     * @param value
     * @param type
     * @param bit
     * @param force
     * @return
     */
    private static String baseFormat(String value, String type, int bit, boolean force) {
        try {
            // 1. 百分比
            if (Type.PERCENT.equals(type)) {
                BigDecimal decimal = new BigDecimal(value).multiply(new BigDecimal(100));
                if (bit <= 0) {
                    return decimal.setScale(bit, RoundingMode.HALF_UP).longValue() + "%";
                }
                if (force) {
                    return decimal.setScale(bit, RoundingMode.HALF_UP) + "%";
                } else {
                    return decimal.setScale(bit, RoundingMode.HALF_UP).doubleValue() + "%";
                }
            }
            // 2. 整数/小数
            BigDecimal decimal = new BigDecimal(value);
            if (bit <= 0) {
                return String.valueOf(decimal.setScale(bit, RoundingMode.HALF_UP).longValue());
            }
            if (force) {
                return decimal.setScale(bit, RoundingMode.HALF_UP).toString();
            } else {
                return String.valueOf(decimal.setScale(bit, RoundingMode.HALF_UP).doubleValue());
            }
        } catch (Exception e) {
        }
        return value;
    }

    /**
     * 格式化基础方法，有精度问题【不推荐此方法】，如：baseFormat2("0.1125", Type.NUMBER, 3, false) //结果：0.112
     * @param value 需要计算的值
     * @param type  百分比/数值
     * @param bit   小数点位数
     * @param force 是否强制格式化为指定位数，不足补0
     * @return
     */
    private static String baseFormat2(String value, String type, int bit, boolean force) {
        try {
            // 1. 百分比
            if (Type.PERCENT.equals(type)) {
                if (bit <= 0) {
                    return new DecimalFormat("#%").format(new BigDecimal(value));
                }
                if (force) {
                    return new DecimalFormat(getFormatPattern("0.", "%", bit, "0")).format(new BigDecimal(value));
                } else {
                    return new DecimalFormat(getFormatPattern("#.", "%", bit, "#")).format(new BigDecimal(value));
                }
            }
            // 2. 整数/小数
            if (bit <= 0) {
                return new DecimalFormat("#").format(new BigDecimal(value));
            }
            if (force) {
                return new DecimalFormat(getFormatPattern("0.", "", bit, "0")).format(new BigDecimal(value));
            } else {
                return new DecimalFormat(getFormatPattern("#.", "", bit, "#")).format(new BigDecimal(value));
            }
        } catch (Exception e) {
        }
        return value;
    }

    /**
     * 获取格式化表达式， 重复seg多少（n）次
     * @param prefix 前缀
     * @param suffix 后缀
     * @param n      重复次数
     * @param seg    重复的字符
     * @return
     */
    private static String getFormatPattern(String prefix, String suffix, int n, String seg) {
        StringBuffer sb = new StringBuffer();
        if (EmptyUtil.isNotEmpty(prefix)) {
            sb.append(prefix);
        }
        if (n <= 0 || EmptyUtil.isEmpty(seg)) {
            return sb.toString();
        }
        for (int i = 0; i < n; i++) {
            sb.append(seg);
        }
        if (EmptyUtil.isNotEmpty(suffix)) {
            sb.append(suffix);
        }
        return sb.toString();
    }


}
