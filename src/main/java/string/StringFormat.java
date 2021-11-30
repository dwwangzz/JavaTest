package string;

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

    }
}
