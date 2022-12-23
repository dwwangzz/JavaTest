package format;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * java.math.RoundingMode里面有几个参数搞得我有点晕，现以个人理解对其一一进行总结：
 * 为了能更好理解，我们可以画一个XY轴
 * RoundingMode.CEILING：取右边最近的整数
 * RoundingMode.DOWN：去掉小数部分取整，也就是正数取左边，负数取右边，相当于向原点靠近的方向取整
 * RoundingMode.FLOOR：取左边最近的正数
 * RoundingMode.HALF_DOWN:五舍六入，负数先取绝对值再五舍六入再负数
 * RoundingMode.HALF_UP:四舍五入，负数原理同上
 * RoundingMode.HALF_EVEN:这个比较绕，整数位若是奇数则四舍五入，若是偶数则五舍六入
 * 第二版
 * roundMode是指舍位时候的模式，传参数的时候用BigDecimal.ROUND_XXXX_XXX,
 * 有以下例子是setScale(0,BigDecimal.ROUND_XXXX_XXX));的情况。如果保留小数位数不是零，如
 * setScale(2,BigDecimal.ROUND_XXXX_XXX)); 是 2 ，则 此数字的小数位数要大于2位。第三位才是要取舍得位。
 * ROUND_CEILING:   舍位时往正无穷方向移动   1.1->2   1.5->2   1.8->2   -1.1->-1   -1.5->-1   -1.8->-1
 * ROUND_DOWN:向0的方向移动1.1->1   1.5->1   1.8->1   -1.1->-1   -1.5->-1   -1.8>-1
 * ROUND_FLOOR:与CEILING相反，往负无穷   1.1->1   1.5->1   1.8->1   -1.1->-2   -1.5->-2   -1.8->-2
 * ROUND_HALF_DOWN:以5为分界线，或曰五舍六入1.5->1   1.6->1   -1.5->-1   -1.6->-2 1.15->1.1   1.16->1.2 1.55->1.6  1.56->1.6
 * ROUND_HALF_EVEN:同样以5为分界线，如果是5，则前一位变偶数1.15->1.2   1.16->1.2   1.25->1.2   1.26->1.3
 * ROUND_HALF_UP:最常见的四舍五入
 * ROUND_UNNECESSARY:无需舍位
 * ROUND_UP:与ROUND_DOWN，远离0的方向1.1->2   1.5->2   1.8->2   -1.1->-2   -1.5->-2   -1.8->-2
 * 具体精确到几位因该采用
 * 商=被除数.devide(除数，保留小数位数，精确方法)
 * url: https://www.cnblogs.com/jpfss/p/9987319.html
 * @author: wangzz
 * @date: 2022年01月24日 15:07
 */
public class DecimalFormatDemo {

    @Test
    public void test() {
        // 取一位整数
        // 取两位整数，三位小数，不够部分补0
        System.out.println(new DecimalFormat("00.000").format(new BigDecimal("3.14")));// 03.140
        // 取两位整数，三位小数，不够部分不做处理
        System.out.println(new DecimalFormat("##.###").format(new BigDecimal("3.14")));// 3.14

        double pi = 3.1415927;//圆周率
        // 取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));

        // 取所有整数部分，小数部分四舍五入
        System.out.println(new DecimalFormat("#").format(new BigDecimal("12345.6789")));
        System.out.println(new DecimalFormat("0").format(new BigDecimal("12345.6789")));
        // PS: 也是取所有的整数部分，只不过00:表示整数部分不够2位用0填充，而##与#的效果一样，代表取整数部分，位数不够，不做任何填充，所以小数点前面的#一位即可，无需多个
        System.out.println(new DecimalFormat("##").format(new BigDecimal("5.6789")));
        System.out.println(new DecimalFormat("00").format(new BigDecimal("5.6789")));

        // 以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%
        System.out.println(new DecimalFormat("0.00%").format(pi));//314.16%

    }

    /**
     * BigDecimal格式化
     */
    @Test
    public void test2() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));



    }

}
