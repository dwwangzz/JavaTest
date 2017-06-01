package Test;

import utils.DateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {

        Date date = DateUtil.strToDate("2017-05-17 17:18:00");
        System.out.println(date.getTime()/1000);
        System.out.println(DateUtil.dateToStr(date));
        System.out.println(DateUtil.strToDate("2017-05-17 17:20:00").getTime()/1000);

    }

}
