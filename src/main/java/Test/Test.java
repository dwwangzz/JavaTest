package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws Exception {
        String str = "第2行 任务类型:'订单组注意1'不存在，;\n" +
                "第2行 任务类型:'确认信息2'不存在，;\n" +
                "第3行 任务类型:'订单组注意3'不存在，;\n" +
                "第3行 任务类型:'追件3'不存在，;";
        str = str.replaceAll("[,，];",";");
        System.out.println(str);
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
