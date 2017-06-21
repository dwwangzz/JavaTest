package app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 饿了么外卖金额计算
 */
public class Eleme {

    public static void main(String[] args) throws Exception {

        //实付总金额（折扣之后的金额）
        //double payPrice = 27.9;
        //eleme(payPrice, 31, 31);
        eleme();
    }

    /**
     * 饿了么
     * @param payPrice
     * @param priceArr
     */
    private static void eleme(double payPrice, double... priceArr) {
        //应付总金额（折扣之前的金额）
        double factPrice = 0;
        //计算总金额
        for (double price : priceArr) {
            factPrice += price;
        }
        System.out.println("原价总额：" + factPrice + "￥ 实际支付总额：" + payPrice + "￥");
        for (double price : priceArr) {
            double zhekou = (payPrice * price) / factPrice;
            BigDecimal b = new BigDecimal(Double.toString(zhekou));
            BigDecimal one = new BigDecimal("1");
            zhekou = b.divide(one, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("原价：" + price + " ； 折扣之后：" + zhekou);
        }
    }

    /**
     * 饿了么
     */
    private static void eleme() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入实付总金额：");
        double payPrice = s.nextDouble();
        s.nextLine();
        boolean flag = true;
        List<Double> priceList = new ArrayList<>();
        do {
            System.out.println("请输入一个实际金额(结束请输入;)：");
            String re = s.nextLine().trim();
            if (re.length() == 0 || re.contains(";")) {
                flag = false;
            } else {
                double e = Double.parseDouble(re);
                priceList.add(e);
            }

        } while (flag);

        //应付总金额（折扣之前的金额）
        double factPrice = 0;
        //计算总金额
        for (double price : priceList) {
            factPrice += price;
        }
        System.out.println("原价总额：" + factPrice + "￥ 实际支付总额：" + payPrice + "￥");
        for (double price : priceList) {
            //double zhekou = (payPrice * price) / factPrice;
            //zhekou = MathUtil.round(zhekou, 2);
            //System.out.println("原价：" + price + " ； 折扣之后：" + zhekou);
            double zhekou = (payPrice * price) / factPrice;
            BigDecimal b = new BigDecimal(Double.toString(zhekou));
            BigDecimal one = new BigDecimal("1");
            zhekou = b.divide(one, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("原价：" + price + " ； 折扣之后：" + zhekou);
        }
    }

}
