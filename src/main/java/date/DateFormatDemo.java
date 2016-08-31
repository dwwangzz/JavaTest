package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {

    public static void main(String[] args) throws Exception {

        //新建一个当前日期java.util.Date;
        Date date = new Date();


        String strDate = "2014-01-01 13:13:13";
        //定义日期格式化输出器
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //将字符串转成日期格式  （字符串转日期）
        Date newDate = df.parse(strDate);
        //将日期类型的数据格式化    （日期转字符串）
        String formatDate = df.format(date);

        System.out.println("newDate=" + newDate);
        System.out.println("formatDate=" + formatDate);


        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        Date nowdate = new Date();
        String myString = "2008-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date d = sdf.parse(myString);

        boolean flag = d.before(nowdate);
        if (flag)
            System.out.print("早于今天");
        else
            System.out.print("晚于今天");

    }

}
