package Test;

import utils.DateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {
        Date date = new Date(2017 - 1900, 4, 30);
        System.out.println(DateUtil.dateToStr(date, "yyyy-MM-dd"));
        date = DateUtil.addMonth(date, -1);
        System.out.println(DateUtil.dateToStr(date, "yyyy-MM-dd"));
    }

}
