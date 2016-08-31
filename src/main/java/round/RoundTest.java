package round;

import java.math.BigDecimal;

/**
 * 四舍五入
 * 
 * @author wangzz-a
 * @version $Id: RoundTest.java, v 0.1 2014年12月31日 下午2:49:51 wangzz-a Exp $
 */
public class RoundTest {

	public static void main(String[] args) {
		baoLiu2WeiXiaoShu();
		// int ranNum = (int) (Math.random()*100);

		double i = 2, j = 2.1, k = 2.5, m = 2.9;
		System.out.println("舍掉小数取整:Math.floor(2)=" + (int) Math.floor(i));
		System.out.println("舍掉小数取整:Math.floor(2.1)=" + (int) Math.floor(j));
		System.out.println("舍掉小数取整:Math.floor(2.5)=" + (int) Math.floor(k));
		System.out.println("舍掉小数取整:Math.floor(2.9)=" + (int) Math.floor(m));

		System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

		System.out.println("凑整:Math.ceil(2)=" + (int) Math.ceil(i));
		System.out.println("凑整:Math.ceil(2.1)=" + (int) Math.ceil(j));
		System.out.println("凑整:Math.ceil(2.5)=" + (int) Math.ceil(k));
		System.out.println("凑整:Math.ceil(2.9)=" + (int) Math.ceil(m));

		System.out.println("舍掉小数取整:Math.floor(-2)=" + (int) Math.floor(-i));
		System.out.println("舍掉小数取整:Math.floor(-2.1)=" + (int) Math.floor(-j));
		System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int) Math.floor(-k));
		System.out.println("舍掉小数取整:Math.floor(-2.9)=" + (int) Math.floor(-m));

		System.out.println("四舍五入取整:(-2)=" + new BigDecimal("-2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.1)=" + new BigDecimal("-2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.5)=" + new BigDecimal("-2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.9)=" + new BigDecimal("-2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

		System.out.println("凑整:Math.ceil(-2)=" + (int) Math.ceil(-i));
		System.out.println("凑整:Math.ceil(-2.1)=" + (int) Math.ceil(-j));
		System.out.println("凑整:Math.ceil(-2.5)=" + (int) Math.ceil(-k));
		System.out.println("凑整:Math.ceil(-2.9)=" + (int) Math.ceil(-m));

		/*
		 * 这段被注释的代码不能正确的实现四舍五入取整 System.out.println("四舍五入取整:Math.rint(2)=" +
		 * (int)Math.rint(i)); System.out.println("四舍五入取整:Math.rint(2.1)=" +
		 * (int)Math.rint(j)); System.out.println("四舍五入取整:Math.rint(2.5)=" +
		 * (int)Math.rint(k)); System.out.println("四舍五入取整:Math.rint(2.9)=" +
		 * (int)Math.rint(m));
		 * 
		 * System.out.println("四舍五入取整:(2)=" + new DecimalFormat("0").format(i));
		 * System.out.println("四舍五入取整:(2.1)=" + new
		 * DecimalFormat("0").format(i)); System.out.println("四舍五入取整:(2.5)=" +
		 * new DecimalFormat("0").format(i)); System.out.println("四舍五入取整:(2.9)="
		 * + new DecimalFormat("0").format(i));
		 */

		/*
		 * int[] b=new int[10]; for(int i=0;i<b.length;i++){ b[i]=(int)
		 * (Math.random()*100); for(int j=0;j<i+1;j++){ if((i!=j)&&b[i]==b[j])
		 * b[i]=(int) (Math.random()*100); } } for(int i=0;i<b.length;i++){
		 * System.out.print(b[i]+"  "); }
		 */

	}

	public static void baoLiu2WeiXiaoShu() {
		// 一 Long是长整型，怎么有小数，是double吧
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		double d = 3.14159;
		System.out.println(df.format(d));

		// 二 java.math.BigDecimal
		BigDecimal bd = new BigDecimal("3.14159265");
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);

		// 三
		long l1 = Math.round(3.14659 * 100); // 四舍五入
		double ret = l1 / 100.0; // 注意：使用 100.0 而不是 100

		// 四
		double dd = 13.4324;
		dd = ((int) (dd * 100)) / 100;
		
		
		
		
		
		
		//===========================常用===============================
		int a = 2;
		double b = 3;
		double c = a*100/b;
		// 一 Long是长整型，怎么有小数，是double吧
		java.text.DecimalFormat df2 = new java.text.DecimalFormat("#.##");
		System.out.println(df2.format(c));
		// 二 java.math.BigDecimal
		BigDecimal bd2 = new BigDecimal(c);
		bd2 = bd2.setScale(2, BigDecimal.ROUND_HALF_UP);
		//================================================================
	}

    /**
     * BigDecimal 比较大小
     */
    public static void compareTo(){
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(2);
        BigDecimal b3 = new BigDecimal(1.00);
        System.out.println(b1.compareTo(b2));
        System.out.println(b1.compareTo(b3));
        System.out.println(b2.compareTo(b3));
    }

}
