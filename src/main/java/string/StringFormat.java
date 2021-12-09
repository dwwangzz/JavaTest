package string;

import org.junit.Test;

import java.util.Date;

/**
 * Created by wangzz on 2016/10/26.
 * String的format方法 - 还有许多用法需要研究
 */
public class StringFormat {

    public static void main(String[] args) {
        //保留两位小数，四舍五入
        System.out.println(String.format("%.2f", 1234.2343));
        //%.2f %.表示 小数点前任意位数 2 表示两位小数 格式后的结果为f 表示浮点型
        // 月份如1月转成 01
        System.out.println(String.format("%02d", 1));
        System.out.println(String.format("%f %%", 0.1 * 100));
        String str = String.format("下载完成%1$b%2$s", 50, "%");
        System.out.println(str);

    }


    /**
     * 1. 常用转换符
     */
    @Test
    public void test() {
        // %s 字符串类型 "mingrisoft"
        System.out.println(String.format("你好%s", "刘亦菲"));
        // %c 字符类型 'm'
        System.out.println(String.format("我是：%c", 'A'));
        // %b 布尔类型 true
        System.out.println(String.format("布尔类型：%b", true));
        // %d 整数类型（十进制）
        System.out.println(String.format("100的一半是：%d", 100 / 2));
        // %x 整数类型（十六进制） FF
        System.out.println(String.format("100的16进制[小写]数是：%x", 100));
        System.out.println(String.format("100的16进制[大写]数是：%X", 100));
        // %o 整数类型（八进制） 77
        System.out.println(String.format("100的8进制数是：%o", 100));
        // %f 浮点类型 99.99
        System.out.println(String.format("50元的书打8.5折扣是：%f 元%n", 50 * 0.85));
        // %a 十六进制浮点类型 FF.35AE
        System.out.println(String.format("上面价格的16进制数是：%a", 50 * 0.85));
        System.out.println(String.format("上面价格的16进制数是：%A", 50 * 0.85));
        // %e 指数类型 9.38e+5
        System.out.println(String.format("上面价格的指数表示：%e", 50 * 0.85));
        System.out.println(String.format("上面价格的指数表示：%E", 50 * 0.85));
        // %g 通用浮点类型（f和e类型中较短的）
        System.out.println(String.format("上面价格的指数和浮点数结果的长度较短的是：%g", 50 * 0.85));
        // %h 散列码
        System.out.println(String.format("字母A的散列码是：%h", 'A'));
        // %% 百分比类型 ％
        System.out.println(String.format("上面的折扣是%d%%", 85));
        // %n 换行符
        System.out.println(String.format("下面有一个换行%n换行了"));
        // %tx 日期与时间类型（x代表不同的日期与时间转换符

    }


    /**
     * 2. 搭配转换符的标志
     * 占位符完整格式为： %[index$][标识]*[最小宽度][.精度]转换符
     */
    @Test
    public void test2() {
        // + 为正数或负数添加符号	format("%+d",99)	+99
        System.out.println(String.format("%+d", 99));
        System.out.println(String.format("%+d", -99));
        //-	左对齐	format("%-5s","str")	|str  |
        System.out.println(String.format("|%-10s|", "左对齐"));
        System.out.println(String.format("|%10s|", "右对齐"));
        // 0 数字前补0	format("%05d",99)	00099
        System.out.println(String.format("|%02d|", 9));
        // 空格	在整数前添加指定数量空格	format("% 5d",99)	|   99|
        System.out.println(String.format("|% 5d|", 99));
        // , 用,对数字进行格式化(三位一逗)	format("%,d",321321)	321,321
        System.out.println(String.format("|%,d|", 123456789));
        // ( 使用括号包含负数	format("%(d",-99)	99
        System.out.println(String.format("负号用括号包起来：%(d", -99));
        System.out.println(String.format("负号用括号包起来：%(d", 99));
        // 十进制转换成16进制/8进制
        System.out.println(String.format("十进制转换成16进制[小写]：%#x", 99));
        System.out.println(String.format("十进制转换成16进制[大写]：%#X", 99));
        System.out.println(String.format("十进制转换成8进制：%#o", 99));
        // > 格式化前一个转换符所描述的参数
        System.out.println(String.format("%f和%<3.2f", 99.45));
        // 【%3.2f】表示小数点前面部分最少占3位数，不够的话，前面补充空格。【.2】表示小数点后保留两位小数
        // 【%03.2f】表示小数点前面部分最少占3位数，不够的话，前面补充0
        System.out.println(String.format("%3.2f", 99.451234));
        System.out.println(String.format("%03.3f", 99.454564564));
        // 被格式化的参数索引
        System.out.println(String.format("|%1$d|%2$s|", 99, "哈哈"));
    }


    /**
     * 3. 日期和时间
     */
    @Test
    public void test3() {
        Date now = new Date();

        // 1. 常见日期和时间组合的格式
        // 包括全部日期和时间信息 星期四 十二月 09 14:15:03 GMT+08:00 2021
        System.out.println(String.format("%tc", now));
        // 年-月-日格式 2021-12-09
        System.out.println(String.format("%tF", now));
        // “月/日/年”格式
        System.out.println(String.format("%tD", now));
        // “HH:MM:SS PM”格式（12时制）
        System.out.println(String.format("%tr", now));
        // HH:MM:SS 格式（24时制）
        System.out.println(String.format("%tT", now));
        // “HH:MM”格式（24时制）
        System.out.println(String.format("%tR", now));

        // 2. 日期格式化转换符
        // b或者h 月份简称 中：十月 英：Oct
        System.out.println(String.format("b或者h 月份简称：%tb", now));
        // B 月份全称中：十月 英：October
        System.out.println(String.format("B 月份全称中：%tB", now));
        // a 星期的简称 中：星期六 英：Sat
        System.out.println(String.format("a 星期的简称：%ta", now));
        // A 星期的全称 中：星期六 英：Saturday
        System.out.println(String.format("A 星期的全称：%tA", now));
        // C 年的前两位数字（不足两位前面补0） 20
        System.out.println(String.format("C 年的前两位数字：%tC", now));
        // y 年的后两位数字（不足两位前面补0） 07
        System.out.println(String.format("y 年的后两位数字：%ty", now));
        // Y 4位数字的年份（不足4位前面补0） 2007
        System.out.println(String.format("Y 4位数字的年份：%tY", now));
        // j 一年中的天数（即年的第几天） 300
        System.out.println(String.format("j 一年中的天数：%tj", now));
        // m 两位数字的月份（不足两位前面补0） 10
        System.out.println(String.format("m 两位数字的月份：%tm", now));
        // d 两位数字的日（不足两位前面补0） 27
        System.out.println(String.format("d 两位数字的日：%td", now));
        // e 月份的日（前面不补0） 5
        System.out.println(String.format("e 月份的日：%te", now));

        // 3. 时间格式化转换符
        // H 2位数字24时制的小时（不足2位前面补0） 15
        System.out.println(String.format("%tH", now));
        // I 2位数字12时制的小时（不足2位前面补0） 03
        System.out.println(String.format("%tI", now));
        // k 2位数字24时制的小时（前面不补0） 15
        System.out.println(String.format("%tk", now));
        // l 2位数字12时制的小时（前面不补0） 3
        System.out.println(String.format("%tl", now));
        // M 2位数字的分钟（不足2位前面补0） 03
        System.out.println(String.format("%tM", now));
        // S 2位数字的秒（不足2位前面补0） 09
        System.out.println(String.format("%tS", now));
        // L 3位数字的毫秒（不足3位前面补0） 015
        System.out.println(String.format("%tL", now));
        // N 9位数微妙(000000000~999999999)
        System.out.println(String.format("%tN", now));
        // p 小写字母的上午或下午标记  中：下午 英：pm
        System.out.println(String.format("%tp", now));
        // z 相对于GMT的RFC822时区的偏移量 +0800
        System.out.println(String.format("%tz", now));
        // Z 时区缩写字符串 CST
        System.out.println(String.format("%tZ", now));
        // 从1970-01-01 00:00:00 到现在的秒
        System.out.println(String.format("%ts", now));
        // 从1970-01-01 00:00:00 到现在的毫秒
        System.out.println(String.format("%tQ", now));
    }


}
