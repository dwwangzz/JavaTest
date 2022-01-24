package format;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author: wangzz
 * @date: 2022年01月24日 15:07
 */
public class DecimalFormatDemo {

    @Test
    public void test() {
        double pi = 3.1415927;//圆周率
        // 取一位整数
        System.out.println(new DecimalFormat("0").format(00));//3
        System.out.println(new DecimalFormat("00.00000").format(new BigDecimal("-011230.1230")));//3
        System.out.println(new DecimalFormat("###.#####").format(new BigDecimal("-011230.1230")));//3



        //// 取一位整数和两位小数
        //System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //// 取两位整数和三位小数，整数不足部分以0填补。
        //System.out.println(new DecimalFormat("00.000").format(pi));// 03.142
        //// 取所有整数部分
        //System.out.println(new DecimalFormat("#").format(pi));//3
        //// 以百分比方式计数，并取两位小数
        //System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%
    }

}
