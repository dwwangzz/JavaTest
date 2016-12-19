package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws Exception {
        String str = "18653151533,显示签收未收到,售后客服注意,售中客服注意，确认换货/补发订单";

        System.out.println(getTelnum(str));
    }

    public static String getTelnum(String sParam) {
        if (sParam.length() <= 0)
            return "";
        Pattern pattern = Pattern.compile("(\\+?86)?1\\d{10}$*");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }

}
