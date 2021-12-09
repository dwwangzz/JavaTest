package Test;

import utils.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {

        //Date date = DateUtil.strToDate("2017-05-17 17:18:00");
        //System.out.println(date.getTime()/1000);
        //System.out.println(DateUtil.dateToStr(date));
        //System.out.println(DateUtil.strToDate("2017-05-17 17:20:00").getTime()/1000);



        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.multiply(b));

        float c = 0.1f;
        float d = 0.1f;
        System.out.println(c*d);


        double e = 0.1d;
        double f= 0.1d;
        System.out.println(e*f);
    }

}
