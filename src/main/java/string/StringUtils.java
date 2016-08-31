package string;

import utils.EmptyUtil;

/**
 * Created by wangzz on 2016/8/11.
 */
public class StringUtils {

    //通用换行 wangzz
    public static final String separator = System.getProperty("line.separator", "\n");

    public static void main(String[] args) {
        String str = "152$.202150kuai$";
        System.out.println(stringToDouble(str));
    }


    /**
     * 清空所有非数字字符
     * @param numberStr 需要格式化的数字字符串
     * @return String
     * wangzz
     */
    public static String stringFormatNumber(String numberStr){
        if (EmptyUtil.isEmpty(numberStr)) {
            return null;
        }
        return numberStr.replaceAll("[^\\d.]", "");
    }

    /**
     * string转换成Integer
     * @param numberStr
     * @return Integer
     * wangzz
     */
    public static Integer stringToInteger(String numberStr){
        if (EmptyUtil.isEmpty(numberStr)) {
            return null;
        }
        numberStr = stringFormatNumber(numberStr);
        numberStr = numberStr.substring(0, numberStr.indexOf("."));
        return Integer.parseInt(numberStr);
    }

    /**
     * string转换成Long
     * @param numberStr
     * @return Long
     * wangzz
     */
    public static Long stringToLong(String numberStr){
        if (EmptyUtil.isEmpty(numberStr)) {
            return null;
        }
        numberStr = stringFormatNumber(numberStr);
        numberStr = numberStr.substring(0,numberStr.indexOf("."));
        return Long.parseLong(numberStr);
    }

    /**
     * string转换成Double
     * @param numberStr
     * @return Double
     * wangzz
     */
    public static Double stringToDouble(String numberStr){
        if (EmptyUtil.isEmpty(numberStr)) {
            return null;
        }
        numberStr = stringFormatNumber(numberStr);
        return Double.parseDouble(numberStr);
    }

}
